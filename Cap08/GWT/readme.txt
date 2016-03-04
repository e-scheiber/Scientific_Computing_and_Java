Catalogul integrala-sablon contine resursele aplicatiei care
completeaza aplicatia care se genereaza.

1. Se creaza catalogul lib si se completeaza cu fisierele
     mathlib.jar
     matheclipse-parser-*.jar

2. Se executa startAppIntegrala.bat.

2. Se copiaza din integrala-sablon in integrala continutul
   cataloagelor src si war in cataloagele omonime (Overwrite all) 
   cat si fisierul MyAnt.bat.
   
3. In build.xml se actualizeaza classpath cu matheclipse-parser-*.*.*.jar 
   si mathlib.jar
   
   <pathelement path="../lib/matheclipse-parser-0.0.10.jar"/>
   <pathelement path="../lib/mathlib.jar"/>

4. Se executa MyAnt.bat devmode / MyAnt.bat war.  


