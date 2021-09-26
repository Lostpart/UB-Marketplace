FROM maven:3.8-jdk-11

ADD . ./app
WORKDIR /app

#For local test only
#ENV PORT:8080

EXPOSE $PORT

CMD mvn clean spring-boot:run -Dspring-boot.run.arguments=--server.port=$PORT