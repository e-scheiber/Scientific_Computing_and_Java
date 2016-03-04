set Path=e:\JavaApp\apache-maven-3.3.9\bin;%PATH%
set JAVA_HOME=c:\Program Files\Java\jdk1.8.0_74
set HOME=e:\mk\ScientificComput\New\test\Cap01\Biblioteca8\lib
start mvn install:install-file -Dfile=%HOME%\org.scilab.modules.javasci.jar -DgroupId=org.scilab.modules.javasci -DartifactId=org.scilab.modules.javasci -Dversion=5.5.2 -Dpackaging=jar
start mvn install:install-file -Dfile=%HOME%\org.scilab.modules.types.jar -DgroupId=org.scilab.modules.types -DartifactId=org.scilab.modules.types -Dversion=5.5.2 -Dpackaging=jar
start mvn install:install-file -Dfile=%HOME%\jep-2.4.1.jar -DgroupId=jep -DartifactId=jep -Dversion=2.4.1 -Dpackaging=jar
start mvn install:install-file -Dfile=%HOME%\matheclipse-parser-0.0.10.jar -DgroupId=org.matheclipse -DartifactId=matheclipse-parser -Dversion=0.0.10 -Dpackaging=jar
