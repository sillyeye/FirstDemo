FROM amazoncorretto:17-alpine

WORKDIR /app

COPY build/libs/FirstDemo-0.0.1-SNAPSHOT.jar /app/FirstDemo-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "FirstDemo-0.0.1-SNAPSHOT.jar"]
