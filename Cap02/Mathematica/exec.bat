set Mathematica_HOME=c:\Program Files\Wolfram Research\Mathematica\9.0
set classpath=.;%Mathematica_HOME%\SystemFiles\Links\JLink\JLink.jar;
rem Compilarea programelor
javac *.java
pause Executarea aplicatiei NSolve
call jexe.bat NSolve
pause Executarea aplicatiei NIntegrate
call jexe.bat NIntegrate
pause Executarea aplicatiei MathGraphics
call jexe.bat MathGraphics