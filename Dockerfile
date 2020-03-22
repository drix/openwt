FROM hypriot/rpi-java

MAINTAINER Adriano Spadoni <alte_br@hotmail.com>

WORKDIR /usr/build/

#RUN apt-get install ca-certificates-java
#RUN update-alternatives --config java
RUN /usr/bin/printf '\xfe\xed\xfe\xed\x00\x00\x00\x02\x00\x00\x00\x00\xe2\x68\x6e\x45\xfb\x43\xdf\xa4\xd9\x92\xdd\x41\xce\xb6\xb2\x1c\x63\x30\xd7\x92' > /etc/ssl/certs/java/cacerts
RUN update-ca-certificates -f
RUN /var/lib/dpkg/info/ca-certificates-java.postinst configure

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /home/pi/docker/openwt.jar

EXPOSE 8090

ENTRYPOINT ["java","-Djavax.net.ssl.trustStorePassword=changeit", "-Djavax.net.ssl.trustStore=/etc/ssl/certs/java/cacerts","-jar","/home/pi/docker/openwt.jar"]