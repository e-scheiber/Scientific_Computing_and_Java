1. Se calibreaza fisierul build.properties
2. Se creaza si se completeaza catalogul lib cu mathlib.jar
3. Ruland myant se creaza toate componentele OSGi
4. Ruland osgif.bat se lanseaza apache-felix
    
Apelare din felix.
    
Varianta simpla:
start file:e:/mk/ScientificComput/New/test/Cap01/OSGi/AppEcAlg/dist/testecalg.jar
start file:e:/mk/ScientificComput/New/test/Cap01/OSGi/AppIntegrala/dist/testintegrala.jar

Varianta cu serviciu inregistrat:
start file:e:/mk/ScientificComput/New/test/Cap01/OSGi/Services/dist/services.jar
start file:e:/mk/ScientificComput/New/test/Cap01/OSGi/AppEcAlgService/dist/appecalg.jar
start file:e:/mk/ScientificComput/New/test/Cap01/OSGi/AppIntegralaService/dist/appintegrala.jar