node 'puppet' {
	case $::task {
        	
		'pull_and_build':	 {
					    class { 'clone_repository': } 
					  
					 }	
                'build':                 { 
                                          class { 'build_project': }
                                         }	

		'install':     		 {
                 	               	        include 'docker'
						include 'git'								
		               		 }

                'install_swift':         {
                                            include 'swiftinstall'
                                         }


		'start':		 { include run_containers }

		'stop':			 { include stop_containers }

		'start_jetty':   	 { include run_jetty }

		'start_orientdb': 	 { include run_orientdb }

		'start_elasticsearch': 	 { include run_elasticsearch }

		'start_pythonserver':	 { include run_pythonserver }

		'start_nodejs':          { include run_nodejs }	

		'stop_jetty':    	 { include stop_jetty }

		'stop_orientdb': 	 { include stop_orientdb }

		'stop_elasticsearch': 	 { include stop_elasticsearch }

		'stop_pythonserver':     { include stop_pythonserver }

		'stop_nodejs':		 { include stop_nodejs }

                 'pull_and_run':          {
                                           class { 'load_images': } ->
                                           class { 'run_containers': }  
                                         
                                         }
                  'create_database':     {
                                           class  { 'create_database': }

                                         }

                 'logging':             {
                                         class { 'start_logging': }
                                        }
	          default:        	{ 
					   class { 'remove_containers': } ->
					   class { 'remove_images': } ->
					   class { 'build_images': } ->
					   class { 'run_containers': } ->
					   class { 'create_database': } ->
					   class { 'save_docker_images': }
					 }
	}
}




