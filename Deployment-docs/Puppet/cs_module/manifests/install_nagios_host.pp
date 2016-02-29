class install_nagios_host {
	exec { 'install nagios host':
		command => '/GitRepository/ContentSphere/deployment/nagios/install_nagios_host.sh',
		path    => ['/usr/bin', '/usr/sbin', '/usr/local/sbin', '/usr/local/bin', '/sbin', '/bin'],
                user    => root,	
 }
}
