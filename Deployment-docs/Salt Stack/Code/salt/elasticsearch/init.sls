{% set user_name = grains['user_name'] %}

install elasticsearch:
  file.recurse:
    - name: /opt/cs/{{user_name}}/elasticsearch
    - source: salt://files/elasticsearch
    - include_empty: True
    - makedirs: True
    - template: jinja
    - user: {{user_name}}
    - group: {{user_name}}
    - dir_mode: 744
    - recurse:
      - user
      - group
      - mode


