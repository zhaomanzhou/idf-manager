FROM openjdk:11-jre-slim-buster

VOLUME /tmp

COPY  idf-admin/target/idf-admin-2.0.jar app.jar

ENV SPRING_PROFILES_ACTIVE=docker


ENTRYPOINT ["java","-jar","/app.jar"]