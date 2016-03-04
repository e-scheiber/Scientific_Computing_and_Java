1. Se executa deploy.bat
   care instaleaza in depozitul local resursele specificate necesare dezvoltarii aplicatiilor
2. Se dezvolta aplicatiile icvadra, cvadraimpl, iecalg, ecalgimpl, ilinear, linearimpl
   Se genereaza aplicatiile ruland 
      maven.bat
      build.bat 
   Pentru fiecare aplicatie
   2_1. Se completeaza codurile aplicatiilor si fisierul pom.xml
   2_2. mvn clean test (optional)
3. Aplicatiile "propriu-zise" se copiaza in catalogul mathlib
   de unde se lanseaza

   mvn clean test
   
   Daca se doreste instalarea in depozitul local se va executa
   mvn clean install
   
