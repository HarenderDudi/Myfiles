CREATE OR REPLACE FUNCTION BASE_PLUGIN (
KLASS_NAME VARCHAR2 ,
INPUT_MODEL CLOB 
)
RETURN CLOB
AS LANGUAGE JAVA
NAME 'com/cs/strategy/plugin/base/BasePlugin.callPlugin(java.lang.String,oracle.sql.CLOB) return oracle.sql.CLOB';