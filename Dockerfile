FROM openjdk:11-jdk-alpine
#FROM adoptopenjdk/openjdk11:alpine-jre
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
VOLUME /tmp
ARG JAR_FILE=target/customer-supermarket-app-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} customer-supermarket-app-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} customer-supermarket-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/customer-supermarket-app-0.0.1-SNAPSHOT.jar"]
#EXPOSE 2222
EXPOSE 9003