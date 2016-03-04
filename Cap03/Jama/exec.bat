set JAMA_HOME=e:\JavaApp\Jama
set classpath=.;%JAMA_HOME%\Jama-1.0.3.jar
echo %classpath%
javac *.java
pause Ruleaza SistemLiniar
java SistemLiniar
pause Ruleaza LUfact
java LUfact
