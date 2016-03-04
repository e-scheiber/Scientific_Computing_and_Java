del *.class
set SCILAB_HOME=c:\Program Files\scilab-5.5.2
rem set PATH=%SCILAB_HOME%\bin;%PATH%
set SCILAB_PATH=%SCILAB_HOME%\modules\javasci\jar\org.scilab.modules.javasci.jar;%SCILAB_HOME%\modules\types\jar\org.scilab.modules.types.jar

set classpath=.;%SCILAB_PATH%;lib\mathlib.jar;lib\junit-4.12.jar;lib\hamcrest-core-1.3.jar;%SCILAB_HOME%\modules\commons\jar\org.scilab.modules.commons.jar

echo Compilarea programelor
javac *.java
pause Rularea aplicatiei TstJavaSci1
java TstJavaSci1
pause Rularea aplicatiei TstJavaSci2
java TstJavaSci2
pause Rularea aplicatiei TstJavaSci3
java TstJavaSci3
pause Rularea aplicatiei TstJavaSci4
java TstJavaSci4
pause Rularea aplicatiei TstJavaSci5
java TstJavaSci5
pause Rularea aplicatiei TestRezolvitorScilab
java TestRezolvitorScilab

