import salt.client

def start_check():
    check_elastic():
    return ""

def check_elastic():
    client = salt.client.LocalClient(__opts__['conf_file'])
    minions = client.cmd('*', 'test.ping', timeout=1)
    for minion in sorted(minions):
        print minion

def start_orient():
    user = __grains__['user_name']
    cmd = "/opt/cs/elastic/elasticsearch/bin/elasticsearch"
    res = __salt__['cmd.run_stdout'](cmd, runas=user, output_loglevel='trace')
    return res

