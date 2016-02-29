class start_logging {
         exec { 'jetty':
                command => 'docker logs -f jetty >> /var/log/contentsphere/jetty/jettylogs.txt 2>&1 &',
                path => ["/usr/bin", "/usr/sbin"],
                timeout => 1800,
                user => root,
        }
        exec { 'orientdb':
                command => 'docker logs -f orientdb >> /var/log/contentsphere/orientdb/orientdblogs.txt 2>&1 &',
                path => ["/usr/bin", "/usr/sbin"],
                timeout => 1800,
                user => root,
        }
        exec { 'elasticsearch':
                command => 'docker logs -f elasticsearch >> /var/log/contentsphere/elasticsearch/elasticsearchlogs.txt 2>&1 &',
                path => ["/usr/bin", "/usr/sbin"],
                timeout => 1800,
                user => root,
        }
		exec { 'nodejs':
                command => 'docker logs -f nodejs >> /var/log/contentsphere/nodejs/nodejslogs.txt 2>&1 &',
                path => ["/usr/bin", "/usr/sbin"],
                timeout => 1800,
                user => root,
        } 
}
