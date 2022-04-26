To run the containers you need to package them to jars.
Notice that health-service needs to connect to a database and without one build will fail if you include test, therefore build with: "mvn clean package -DskipTests".
To run containers you need to start them up in order:
docker compose up db
docker compose up discovery
docker compose up gateway
docker compose up health