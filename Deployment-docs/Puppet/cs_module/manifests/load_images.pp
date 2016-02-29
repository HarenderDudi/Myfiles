class load_images {
	exec { 'load orientdb containers':
                command => 'docker load -i /opt/ContentSphereReleases/dockerImages/orientdb/orientdb.tar.gz',
                path => ["/usr/bin", "/usr/sbin"],
                user => root,
             } ->
        exec { 'load jetty containers':
                command => 'docker load -i /opt/ContentSphereReleases/dockerImages/jetty/jetty.tar.gz',
                path => ["/usr/bin", "/usr/sbin"],
                user => root,
        } ->
        exec { 'load elasticsearch containers':
                command => 'docker load -i /opt/ContentSphereReleases/dockerImages/elasticsearch/elasticsearch.tar.gz',
                path => ["/usr/bin", "/usr/sbin"],
                user => root,
        } ->
         exec { 'load nodejs containers':
                command => 'docker load -i /opt/ContentSphereReleases/dockerImages/nodejs/nodejs.tar.gz',
                path => ["/usr/bin", "/usr/sbin"],
                user => root,
        }
}

