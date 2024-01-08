FROM eclipse-temurin:17-alpine
LABEL maintainer="hari1036@gmail.com"
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]