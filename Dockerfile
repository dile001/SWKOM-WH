FROM eclipse-temurin:17-jdk-jammy

EXPOSE 8080

COPY . .

RUN cd .

ENV db-url $db-url

ENV db-username $db-username

ENV db-password $db-password

CMD ["java", "-jar", "./out/artifacts/SWKOM_jar/SWKOM.jar"]