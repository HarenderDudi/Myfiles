class {'rsync::server':
use_xinetd => true
 }

rsync::server::module{'source_data':
        path => '/tmp/d1'
 }
