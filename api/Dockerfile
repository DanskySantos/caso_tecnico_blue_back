FROM openjdk:17
ARG JAR_FILE=out/artifacts/Caso_Tecnico_Blue_jar/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080:8080