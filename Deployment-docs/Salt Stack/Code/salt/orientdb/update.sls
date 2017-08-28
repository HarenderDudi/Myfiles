{% set user_name = grains['user_name'] %}

update orientdb-server-config.xml file:
  file.managed:
    - name: /opt/cs/{{user_name}}/orientdb-community-2.2.22/orientdb-community-2.2.22/config/orientdb-server-config.xml
    - source: salt://files/orientdb-server-config.xml
    - template: jinja
    - user: {{user_name}}
    - group: {{user_name}}
    - recurse:
      - user
      - group


update Orientdb jar:
  file.managed:
    - name: /opt/cs/{{user_name}}/orientdb-community-2.2.22/orientdb-community-2.2.22/lib/OrientDB.jar
    - source: salt://files/OrientDB.jar
    - user: {{user_name}}
    - group: {{user_name}}
    - recurse:
      - user
      - group
