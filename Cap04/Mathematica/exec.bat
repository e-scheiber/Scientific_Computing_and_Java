set Mathematica_HOME=c:\Program Files\Wolfram Research\Mathematica\9.0
set classpath=.;%Mathematica_HOME%\SystemFiles\Links\JLink\JLink.jar;
rem Compilarea programelor
javac *.java
pause Executarea aplicatiei Symbolic
call jexe.bat Factor
rem call jexe.bat Solve
call jexe.bat Integrate
call jexe.bat DiffSolve


