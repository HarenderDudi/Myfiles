class create_database {
	exec { 'send request to create database':
		command => "curl --user root:root -X POST http://$::orientdbhost:$::orientdbport/database/Test1/plocal",
		path => ["/usr/bin", "/usr/sbin"],
                timeout => 1800,
                user => root,
                logoutput => true,
	}
}
