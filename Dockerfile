FROM openjdk:8-jre-alpine
ENV PORT 8060
EXPOSE 8060
ADD target/orr-reporting-api-0.0.1-SNAPSHOT.war /opt/
WORKDIR /opt
CMD ["java","-jar","orr-reporting-api-0.0.1-SNAPSHOT.war"]


