FROM eclipse-temurin:17-jdk-jammy

EXPOSE 8080

COPY target .

RUN cd .

ENV db-url $db-url

ENV db-username $db-username

ENV db-password $db-password

CMD ["java", "-jar", "./openapi-spring-1.22.1.jar"]