class deploy_images {

    file { "/home/inbetween/DockerImages":
        mode => "0777",
        recurse => "true",
        force => "true",
        purge => "true",
        checksum => "md5",
        ensure => "directory",
        source => "puppet:///modules/mymodule/DockerImages",
    }
}
