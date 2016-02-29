node    'puppet' {
        class { 'rsync': }

file    { '/tmp/d2':
        ensure => directory
        }

        rsync::get { '/tmp/d2':
        source  => "rsync://localhost/source_data",
        require => File['/tmp/d2']
        }
}


