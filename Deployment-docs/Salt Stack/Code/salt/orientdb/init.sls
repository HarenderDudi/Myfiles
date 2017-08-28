{% set user_name = grains['user_name'] %}

install orientdb:
  archive.extracted:
    - name: /opt/cs/{{user_name}}/orientdb-community-2.2.22
    - source: salt://files/orientdb-community-2.2.22.zip
    - archive_format: zip
    - user: {{user_name}}
    - group: {{user_name}}


update hazelcast.xml file:
  file.managed:
    - name: /opt/cs/{{user_name}}/orientdb-community-2.2.22/orientdb-community-2.2.22/config/hazelcast.xml
    - source: salt://files/hazelcast.xml
    - user: {{user_name}}
    - group: {{user_name}}
    - recurse:
      - user
      - group
    - require:
      - archive: install orientdb
