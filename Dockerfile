FROM maven:3.8-jdk-11 AS build

ADD ./app ./app
WORKDIR /app

RUN mvn clean install


FROM openjdk:11
COPY --from=build /app/target/UBMarketplace.jar ./UBMarketplace.jar

#For local test only
#ENV PORT=8080
EXPOSE $PORT

CMD java -jar UBMarketplace.jar --server.port=$PORT