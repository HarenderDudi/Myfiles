class remove_containers {
	exec { 'remove all containers':
                command => 'docker rm -f jetty && docker rm -f orientdb && docker rm -f elasticsearch',
                path => ["/usr/bin", "/usr/sbin"],
                user => root,
               # onlyif => "docker rm -f $(docker ps -a -q)",
        }
}
