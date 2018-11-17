FROM 100.125.0.198:20202/hwcpe-cn-north-1/dockerhub-java:8-jre-alpine

WORKDIR /home/apps/
ADD target/welcome-0.0.1-SNAPSHOT.jar .

ADD start.sh .

ENTRYPOINT ["sh", "/home/apps/start.sh"]