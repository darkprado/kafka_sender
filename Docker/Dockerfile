FROM adoptopenjdk/openjdk11:alpine-jre
ENV SPRING_PROFILES_ACTIVE=prod
COPY kafka_sender-0.0.1-SNAPSHOT.jar /usr/app/kafka_sender.jar
ENTRYPOINT ["java", "-jar", "/usr/app/kafka_sender.jar"]