FROM openjdk:8-jdk-alpine
ARG JAR_FILE
ADD /target/${JAR_FILE} seven-mars.jar
ENTRYPOINT ["java","-jar","/seven-mars.jar"]