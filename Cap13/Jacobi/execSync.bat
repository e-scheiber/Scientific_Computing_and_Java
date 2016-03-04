set ProgName=JacobiSync
del %ProgName%*.class
set APARAPI_DIR=..\lib
javac -g -cp %APARAPI_DIR%\aparapi.jar %ProgName%.java
java -Djava.library.path=%APARAPI_DIR% -cp %APARAPI_DIR%\aparapi.jar;. %ProgName%
