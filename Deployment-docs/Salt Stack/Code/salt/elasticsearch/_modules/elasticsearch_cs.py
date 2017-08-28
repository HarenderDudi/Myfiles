import traceback


def start():
    try:
        user = __grains__['user_name']
        cmd = "/opt/cs/elastic/elasticsearch/bin/elasticsearch -d"
        res = __salt__['cmd.run_all'](cmd, runas=user, bg=True, timeout=1, output_loglevel='trace')
        time.sleep(1)
        res_code = check_service()
        if res_code > 0:
            raise Exception("Elasticsearch is not started, node: " + __grains__['id'])

        return res['retcode']
    except Exception, e:
        return e


def stop():
    user = __grains__['user_name']
    cmd = "fuser -k 9200/tcp"
    res = __salt__['cmd.run_all'](cmd, runas=user, output_loglevel='trace')
    return res['retcode']

def check_service():
    user = __grains__['user_name']
    cmd = "curl localhost:9200"
    res = __salt__['cmd.run_all'](cmd, runas=user, output_loglevel='trace')
    return res['retcode']


def take_snapshot(snapshot_name):
    user = __grains__['user_name']
    try:
        flush_cmd = "curl -XPOST localhost:9200/_flush"
        res = __salt__['cmd.run_all'](flush_cmd, runas=user, output_loglevel='trace')

        register_repo_cmd = "curl -XPUT localhost:9200/_snapshot/repo  -d '{\"type\": \"fs\", \"settings\": {\"location\": \"/opt/cs/elastic/backups/data/\",\"compress\": true}}'"
        res = __salt__['cmd.run_all'](register_repo_cmd, runas=user, output_loglevel='trace')

        snapshot_cmd = "curl -XPUT localhost:9200/_snapshot/repo/" + snapshot_name + "?wait_for_completion=true"
        res = __salt__['cmd.run_all'](snapshot_cmd, runas=user, output_loglevel='trace')
        #return register_repo_cmd
        return res['retcode']

    except Exception:
        return traceback.print_exc()


def restore_snapshot(snapshot_name):
    user = __grains__['user_name']
    try:
        close_index_cmd = "curl -XPOST localhost:9200/cs/_close"
        res = __salt__['cmd.run_all'](close_index_cmd, runas=user, output_loglevel='trace')

        restore_snapshot_cmd = "curl -XPOST localhost:9200/_snapshot/repo/" + snapshot_name + "/_restore"
        res = __salt__['cmd.run_all'](restore_snapshot_cmd, runas=user, output_loglevel='trace')

        return res['retcode']

    except Exception:
        return traceback.print_exc()
