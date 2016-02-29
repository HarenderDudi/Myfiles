class stop_containers {
	exec { 'stop all containers':
                command => 'docker stop $(docker ps -a -q)',
                path => ["/usr/bin", "/usr/sbin"],
                user => root,
                onlyif => "docker stop $(docker ps -a -q)",
        }
}


class stop_jetty {
	 exec { 'stop jetty containers':
                command => 'docker stop jetty',
                path => ["/usr/bin", "/usr/sbin"],
                user => root,
                onlyif => "docker stop jetty",
        }
}

class stop_orientdb {
         exec { 'stop orientdb containers':
                command => 'docker stop orientdb',
                path => ["/usr/bin", "/usr/sbin"],
                user => root,
                onlyif => "docker stop orientdb",
        }
}

class stop_elasticsearch {
         exec { 'stop elasticsearch containers':
                command => 'docker stop elasticsearch',
                path => ["/usr/bin", "/usr/sbin"],
                user => root,
                onlyif => "docker stop elasticsearch",
        }
}

class stop_pythonserver {
	exec { 'stop pythonserver': 
		command => 'docker stop pythonserver',
                path => ["/usr/bin", "/usr/sbin"],
                user => root,
                onlyif => "docker stop pythonserver",
	}
}

class stop_nodejs {
        exec { 'stop nodejs':
                command => 'docker stop nodejs',
                path => ["/usr/bin", "/usr/sbin"],
                user => root,
                onlyif => "docker stop nodejs",
        }
}

