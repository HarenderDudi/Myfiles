class install_nagios_master {
	exec { 'install nagios master':
		command => '/GitRepository/ContentSphere/deployment/nagios/install_nagios.sh',
		timeout => 1800,		
		logoutput => true,
		path    => ['/usr/bin', '/usr/sbin', '/usr/local/sbin', '/usr/local/bin', '/sbin', '/bin'],
                user    => root,		
	
}
}
