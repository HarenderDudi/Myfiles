{% set user_name = grains['user_name'] %}

create cs group:
  group.present:
    - names:
      - cs
      - {{ user_name }}
    - system: True



create user:
  user.present:
    - name: {{ user_name }}
    - home: /opt/cs2/{{user_name}}
    - createhome: True
    - groups:
      - cs
    - require:
      - group: create cs group



create base dirs:
  file.directory:
    - user: {{ user_name }}
    - group: {{ user_name }}
    - mode: 744
    - makedirs: True
    - names:
      - /opt/cs2
      - /opt/cs2/{{ user_name }}/
      - /opt/cs2/{{ user_name }}/cs_IWP
      - /opt/cs2/{{ user_name }}/backups
      - /opt/cs2/{{ user_name }}/backups/data
      - /opt/cs2/{{ user_name }}/backups/logs
      - /opt/cs2/temp_backup
      - /opt/cs2/3rd_Party_Applications
    - recurse:
      - user
      - group
      - mode
    - require:
      - user: create user

copy java packages:
  file.recurse:
    - name: /opt/cs/3rd_Party_Applications/
    - source: salt://files/java/
    - include_empty: True
    - makedirs: True
    - user: {{user_name}}
    - group: {{user_name}}
    - dir_mode: 744
    - require:
      - file: create base dirs

cmd-test:
  cmd.run:
    - runas: root
    - names:
      - rpm -ivh /opt/cs/3rd_Party_Applications/jdk-8u91-linux-x64.rpm
      - rpm -ivh /opt/cs/3rd_Party_Applications/jre-8u91-linux-x64.rpm
      - ln -s /usr/sbin/update-alternatives /usr/sbin/alternatives
    - require:
      - file: copy java packages

