FROM openjdk:8-jre-alpine
ENV PORT 8060
EXPOSE 8060
CMD "mvn clean install -Dmaven.test.skip=true"

