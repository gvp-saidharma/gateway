#
# Build stage
#
FROM maven:3.8.1-openjdk-11-slim AS build
WORKDIR /home/ec2-user/gateway
COPY ./ ./
RUN mvn package -Dmaven.test.skip=true

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/ec2-user/gateway/target/gateway-0.0.1-SNAPSHOT.jar /usr/local/lib/gateway.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/gateway.jar"]