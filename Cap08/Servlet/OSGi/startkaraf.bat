set JAVA_HOME=c:\Program Files\Java\jdk1.8.0_72
set KARAF_HOME=e:\JavaApp\apache-karaf-4.0.3
del %KARAF_HOME%\lock
del %KARAF_HOME%\data\log\*
del %KARAF_HOME%\instances\*
rmdir %KARAF_HOME%\instances

%KARAF_HOME%\bin\karaf.bat clean