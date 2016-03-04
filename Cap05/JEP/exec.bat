set JEP_HOME=.
set JEP_PATH=%JEP_HOME%\jep-2.4.1.jar
set COMMONS_MATH_HOME=e:\JavaApp\commons-math3-3.6
set COMMONS_MATH_PATH=%COMMONS_MATH_HOME%\commons-math3-3.6.jar
set classpath=.;%JEP_PATH%;%COMMONS_MATH_PATH%
echo %classpath%

javac TestJep1.java
java TestJep1
pause

javac TestJep2.java
java TestJep2
pause

javac JepErf.java TestJepErf.java
java TestJepErf
pause
