FROM openjdk:17

ARG JAR_FILE=target/e-fyp.jar

COPY ${JAR_FILE} e-fyp.jar

ENTRYPOINT ["java","-jar","e-fyp.jar"]

EXPOSE 8080
