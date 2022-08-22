FROM openjdk:8

WORKDIR /WeatherApplication/activity-worker

COPY /activity-worker/target/activity-worker-0.0.1-SNAPSHOT.jar activity-worker-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","activity-worker-0.0.1-SNAPSHOT.jar"]
