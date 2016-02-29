class build_project {
	exec { 'Build Project':
		command => 'chmod -R 777 /GitRepository && /GitRepository/ContentSphere/deployment/deploymentscripts/build_project.sh',
		path    => ['/usr/bin', '/usr/sbin', '/usr/local/sbin', '/usr/local/bin', '/sbin', '/bin'],
		timeout => 1800,
    		user    => root,
	}
}

