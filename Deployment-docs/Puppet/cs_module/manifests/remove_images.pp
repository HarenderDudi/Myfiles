class remove_images {
	docker::image { 'jetty':
                  ensure => 'absent'
        } ->
        docker::image { 'orientdb':
                 ensure => 'absent'
        } ->
        docker::image { 'elasticsearch':
                  ensure => 'absent'
        }
}
