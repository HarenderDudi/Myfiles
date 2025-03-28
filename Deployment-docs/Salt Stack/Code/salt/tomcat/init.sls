{% set user_name = grains['user_name'] %}

install tomcat:
  archive.extracted:
    - name: /opt/cs/{{user_name}}/apache-tomcat-9.0.0.M6
    - source: salt://files/apache-tomcat-9.0.0.M6.tar.gz
    - archive_format: tar
    - user: {{user_name}}
    - group: {{user_name}}


update server.xml file:
  file.managed:
    - name: /opt/cs/{{user_name}}/apache-tomcat-9.0.0.M6/apache-tomcat-9.0.0.M6/conf/server.xml
    - source: salt://files/server.xml
    - template: jinja
    - user: {{user_name}}
    - group: {{user_name}}
    - recurse:
      - user
      - group
    - require:
      - archive: install tomcat
