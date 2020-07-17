cd ..
cd JPrezdevUtils
mvn clean install
cd ..
cd JTask
mvn clean compile assembly:single && java -jar target/JTask-1.0-SNAPSHOT-jar-with-dependencies.jar
