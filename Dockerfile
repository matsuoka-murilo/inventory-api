FROM eclipse-temurin:17
LABEL maintener="matsuoka@java10x"
WORKDIR /app
COPY target/inventory-api-0.0.1-SNAPSHOT.jar /app/inventory-docker.jar
ENTRYPOINT ["JAVA", "-jar", "inventory-docker.jar"]