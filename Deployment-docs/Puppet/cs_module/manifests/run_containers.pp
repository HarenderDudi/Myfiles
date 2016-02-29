class run_containers {
        docker::run { 'jetty':
                 image => 'jetty',
                 ports => '8081:8080',
                #expose=> '8080',
                 memory_limit=> "$::memoryfororientdbcontainer",
                 #volumes =>["/etc/timezone:/etc/timezone"], 
                 env   => ["orientdbhost=$::orientdbhost", "orientdbport=$::orientdbport","orientdbuser=root",'orientdbpassword=root','orientdbname=Test1',"elastichost=$::elastichost","elasticport=$::elasticport","logserverip=${::logserverip1}","logserverport=${::logserverport1}"],
        } ->
        docker::run { 'orientdb':
                 image   => 'orientdb',
                 ports => '2480:2480',
                 memory_limit=>  "$::memoryfororientdbcontainer",
                 volumes => ["/contentsphere/orientdb/databases:/orientdb/databases","/var/log/contentsphere/orientdb/log:/orientdb/log"],                          
                 #expose => '2480',
        } ->
          docker::run { 'elasticsearch':
                 image   => 'elasticsearch',
                  memory_limit=>  "$::memoryforelasticcontainer",
                 ports => '9200:9200',
                 #expose => '9200',
                  volumes => ["/contentsphere/elasticsearch/data:/elasticsearch/data","/var/log/contentsphere/elasticsearch/log:/usr/share/elasticsearch/logs"],
        } ->
        docker::run { 'nodejs':
                 image   => 'nodejs',
                 ports => '4000:4000',
                  memory_limit=> "$::memoryfornodejscontainer",
                 #expose => '9200',
                 #volumes =>["/etc/timezone:/etc/timezone"],
		 env   => ["nodeserverip=$::nodeserverip", "nodeserverport=$::nodeserverport","nodeelasticsearchip=$::nodeelasticsearchip","nodeelasticsearchport=$::nodeelasticsearchport"],
        }
}

class run_jetty {
         docker::run { 'jetty':
                 image => 'jetty',
                 ports => '8081:8080',
                 #expose => '8080',
                 memory_limit=> "$::memoryforjettycontainer",
                 #volumes =>["/etc/timezone:/etc/timezone"],
                 env   => ["orientdbhost=$::orientdbhost", "orientdbport=$::orientdbport","orientdbuser=root",'orientdbpassword=root','orientdbname=Test1',"elastichost=$::elastichost","elasticport=$::elasticport","logserverip=${::logserverip1}","logserverport=${::logserverport1}"],
        }
}

class run_orientdb {
        docker::run { 'orientdb':
                 image   => 'orientdb',
                 ports => '2480:2480',
                 #expose => '2480',
                 memory_limit=> "$::memoryfororientdbcontainer",
                 volumes => ["/contentsphere/orientdb/databases:/orientdb/databases","/var/log/contentsphere/orientdb/log:/orientdb/log"],
        }
}

class run_elasticsearch {
        docker::run { 'elasticsearch':
                 image   => 'elasticsearch',
                 ports => '9200:9200',
                 #expose => '9200',
                 memory_limit=> "$::memoryforelasticcontainer",
                 #expose => '9200',
                 volumes => ["/contentsphere/elasticsearch/data:/elasticsearch/data","/var/log/contentsphere/elasticsearch/log:/usr/share/elasticsearch/logs"],
        }
}

class run_nodejs {
        docker::run { 'nodejs':
                 image   => 'nodejs',
                 ports => '4000:4000',
                 #expose => '9200',
                 #volumes =>["/etc/timezone:/etc/timezone"],
                 memory_limit=> "$::memoryfornodejscontainer",
                 env   => ["nodeserverip=$::nodeserverip", "nodeserverport=$::nodeserverport","nodeelasticsearchip=$::nodeelasticsearchip","nodeelasticsearchport=$::nodeelasticsearchport"],
        }
}



