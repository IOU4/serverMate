FROM eclipse-temurin:17-jre-alpine

WORKDIR /app
RUN ./gradlew  bootJar --no-daemon
COPY ./build/libs/servermate-auth-0.1.jar .
CMD [ "java", "-jar", "servermate-auth-0.1.jar" ]
