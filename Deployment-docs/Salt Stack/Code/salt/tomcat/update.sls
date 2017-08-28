{% set user_name = grains['user_name'] %}

update war:
  file.managed:
    - name: /opt/cs/{{user_name}}/apache-tomcat-9.0.0.M6/apache-tomcat-9.0.0.M6/webapps/edeka.war
    - source: salt://files/edeka.war
    - user: {{user_name}}
    - group: {{user_name}}
    - recurse:
      - user
      - group
