FROM cgr.dev/chainguard/maven AS builder

WORKDIR /home/build
COPY pom.xml .
COPY src src
RUN mvn package

FROM cgr.dev/chainguard/jdk:latest 

COPY --from=builder /home/build/target/*.jar ./app.jar
CMD ["java","-jar","app.jar"]
