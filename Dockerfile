FROM openjdk:18
LABEL maintainer="Rasto"
ADD target/demo-0.0.1-SNAPSHOT.jar jsonEncryption.jar
ENTRYPOINT ["java", "-jar", "jsonEncryption.jar"]