FROM hypriot/rpi-java

MAINTAINER Adriano Spadoni <alte_br@hotmail.com>

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /home/pi/docker/openwt.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","/home/pi/docker/openwt.jar"]