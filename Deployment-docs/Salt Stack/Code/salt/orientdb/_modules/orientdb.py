def start():
    print "lalalala"
    user = __grains__['user_name']
    cmd = "/opt/cs/orientdb/orientdb-community-2.2.22/orientdb-community-2.2.22/bin/dserver.sh"
    res = __salt__['cmd.run_all'](cmd, runas=user, bg=True,output_loglevel='trace')
    return res

def stop():
    user = __grains__['user_name']
    cmd = "fuser -k 2480/tcp"
    res = __salt__['cmd.run_all'](cmd, runas=user, output_loglevel='trace')
    return res['retcode']


def check_service():
    user = __grains__['user_name']
    cmd = "curl localhost:2480"
    res = __salt__['cmd.run_all'](cmd, runas=user, output_loglevel='trace')
    return res['retcode']
