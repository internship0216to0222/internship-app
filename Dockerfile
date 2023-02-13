FROM public.ecr.aws/amazoncorretto/amazoncorretto:17.0.6

ENV SPRING_BOOT_HOME=/opt/spring-boot \
    LANG=ja_JP.UTF-8

RUN rm -f /etc/localtime && \
    mkdir -p /opt/spring-boot && chmod 755 /opt/spring-boot

ADD ./build/libs/internship-app.jar /opt/spring-boot/

ENTRYPOINT ["java", "-jar", "/opt/spring-boot/internship-app.jar"]