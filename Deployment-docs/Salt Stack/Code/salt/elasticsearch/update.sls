{% set user_name = grains['user_name'] %}

delete elastic plugin:
  file.absent:
    - name: /opt/cs/{{user_name}}/elasticsearch/plugins/contentsphere-plugin/


install elastic plugin:
  archive.extracted:
    - name: /opt/cs/{{user_name}}/elasticsearch/plugins/contentsphere-plugin/
    - source: salt://files/contentsphere-plugin-1.0.0.zip
    - archive_format: zip
    - require:
      - file: delete elastic plugin

