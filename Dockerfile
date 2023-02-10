FROM amazoncoretto:17.0.6

ENV SPRING_BOOT_HOME=/opt/spring-boot \
    LANG=ja_JP.UTF-8

RUN rm -f /etc/localtime && \
    mkdir -p /opt/spring-boot && chmod 755 /opt/spring-boot

COPY ./gradle/ /opt/spring-boot/project/gradle/
COPY ./src/main/resources/ /opt/spring-boot/project/src/main/resources/
COPY ./build.gradle /opt/spring/boot/project/
COPY ./gradlew /opt/spring/boot/project/
COPY ./setting.gradle /opt/spring/boot/project/

ADD ./build/libs/internship-app.jar /opt/spring-boot/

ENTRYPOINT ["java", "-jar", "/opt/spring-boot/intenship-app.jar"]