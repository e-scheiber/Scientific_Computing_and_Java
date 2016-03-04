Se reface arhiva mathlib cu jdk1.7.0_*

Se creaza catalogul war\WEB-INF\lib si se completeaza cu fisierele
  mathlib.jar
  jep-2.4.1.jar

Se adapteaza web.xml (datele referitoare la applicatia hello
se inlocuiesc cu cele din sablon - web.xml)
  
Catalogul src/integrala inlocuieste catalogul src/org...

In build.xml obiectivul compile, sarcina javac, elementul classpath
se completeaza cu 
        <fileset dir="war/WEB-INF/lib">
          <include name="*.jar"/>
        </fileset>