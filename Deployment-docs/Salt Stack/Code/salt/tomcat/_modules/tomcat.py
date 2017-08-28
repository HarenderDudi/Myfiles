def start():
    user = __grains__['user_name']
    cmd = "/opt/cs/tomcat/apache-tomcat-9.0.0.M6/apache-tomcat-9.0.0.M6/bin/startup.sh"
    res = __salt__['cmd.run_all'](cmd, runas=user, bg=True, output_loglevel='trace')
    return res['retcode']

def stop():
    user = __grains__['user_name']
    cmd = "/opt/cs/tomcat/apache-tomcat-9.0.0.M6/apache-tomcat-9.0.0.M6/bin/shutdown.sh"
    res = __salt__['cmd.run_all'](cmd, runas=user, output_loglevel='trace')
    return res['retcode']


def check_service():
    user = __grains__['user_name']
    cmd = "curl localhost:8080"
    res = __salt__['cmd.run_all'](cmd, runas=user, output_loglevel='trace')
    return res['retcode']

