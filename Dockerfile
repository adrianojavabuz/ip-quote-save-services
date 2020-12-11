FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/ip-quote-save-services.jar
WORKDIR /opt/app
COPY ${JAR_FILE} ip-quote-save-services.jar
ENTRYPOINT ["java","-jar","ip-quote-save-services.jar"]
