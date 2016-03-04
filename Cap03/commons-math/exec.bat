set COMMONS_MATH_HOME=e:\JavaApp\commons-math3-3.6
set classpath=.;%COMMONS_MATH_HOME%\commons-math3-3.6.jar
echo %classpath%

javac MetodaTangentei.java
java MetodaTangentei
pause

javac MetodaLaguerre.java
java MetodaLaguerre
pause

javac InterpolareSpline.java
java InterpolareSpline
pause

javac MetodaSimpson.java
java MetodaSimpson
pause

javac CoeficientiFourier.java
java CoeficientiFourier
pause

javac MetodaRungeKutta.java
java MetodaRungeKutta
pause

javac MetodaCelorMaiMiciPatrate.java
java MetodaCelorMaiMiciPatrate
pause
