FROM maven:3.8-jdk-11

ADD . ./app
WORKDIR /app

#For local test only
#ENV PORT:8080

EXPOSE $PORT

RUN mvn clean install

CMD java -jar .\target\UBMarketplace.jar --server.port=$PORT