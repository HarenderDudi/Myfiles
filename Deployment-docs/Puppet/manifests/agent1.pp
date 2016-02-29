node 'agent1' {
	class { 'deploy_images' } ->
	class { 'remove_containers': } ->
        class { 'remove_images': } ->
        class { 'load_images': } ->
        class { 'run_containers': } ->
        class { 'save_docker_images': }
}
