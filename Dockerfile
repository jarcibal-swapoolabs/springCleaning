FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace 
WORKDIR /usr/share/udemy



# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar 			selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs							libs

# in case of any other dependency like .csv / .json / .xls
# please ADD that as well

# ADD suite files
ADD dockering.xml				dockering.xml
ADD dockering2.xml				dockering2.xml
ADD healthcheck.sh				healthcheck.sh
ADD screenshot/screenshot.png   screenshot.png				
ADD healthcheck.sh				healthcheck.sh
ADD 10mb.jpg					10mb.jpg

# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh