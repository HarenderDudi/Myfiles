class save_docker_images {

    exec { 'save docker images':
    command => 'docker save -o /etc/puppet/modules/cs_module/files/DockerImages/orientdb orientdb  && docker save -o /etc/puppet/modules/cs_module/files/DockerImages/jetty jetty && docker save -o /etc/puppet/modules/cs_module/files/DockerImages/elasticsearch elasticsearch',
    path    => ['/usr/bin', '/usr/sbin'],
    user    => root,
   }
}
