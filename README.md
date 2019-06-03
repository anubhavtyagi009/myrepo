# ORR Reporting API

Services for ORR Reporting portal

## Prerequisites
	Installing JDK 8

	Ubuntu 16.04
	sudo add-apt-repository ppa:webupd8team/java
	sudo apt-get update
	sudo apt-get install oracle-java8-installer

	JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64"
	
## Clone the orr-reporting api repo:
	git clone https://github.com/benchmarkeducation/orr-reporting-api.git
	

## Docker
	Run docker to setup the api, swagger to run locally

	sudo mvn install dockerfile:build
	
	Check your image: run the command “docker images”
	    springio/orr-reporting-api

	docker run -p 8060:8060 -t springio/orr-reporting-api
	

## Building for production

## command to deploy microservice
java -jar orr-reporting-api-0.0.1-SNAPSHOT.war --spring.profiles.active=qa -Dmaven.test.skip=true

## command to create war/jar
mvn clean install -Dmaven.test.skip=true



