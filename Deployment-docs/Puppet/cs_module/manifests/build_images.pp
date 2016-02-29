class build_images {
	 exec { 'jetty':
                command => 'docker build -t jetty /GitRepository/ContentSphere/deployment/dockerfiles/jettycluster/jetty/',
                path => ["/usr/bin", "/usr/sbin"],
                timeout => 1800,
                user => root,
                logoutput => true,
        } ->
        exec { 'orientdb':
                command => 'docker build -t orientdb /GitRepository/ContentSphere/deployment/dockerfiles/orientdbcluster/orientdb/',
                path => ["/usr/bin", "/usr/sbin"],
		timeout => 1800,
                user => root,
        } ->
        exec { 'elasticsearch':
                command => 'docker build -t elasticsearch /GitRepository/ContentSphere/deployment/dockerfiles/elasticcluster/elasticsearch/',
                path => ["/usr/bin", "/usr/sbin"],
                timeout => 1800,
		user => root,
        } ->
	exec { 'nodejs':
                command => 'docker build -t nodejs /GitRepository/ContentSphere/deployment/dockerfiles/nodejscluster/nodejs/',
                path => ["/usr/bin", "/usr/sbin"],
                timeout => 1800,
                user => root,
        }	
}
