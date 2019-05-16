FROM openjdk:8-jre-alpine
ENV PORT 8060
EXPOSE 8060
CMD "sudo mvn install dockerfile:build -Dmaven.test.skip=true"

