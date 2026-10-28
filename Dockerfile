# Ejecuta la suite contra un servidor Appium. El emulador NO está aquí: vive en el host y se
# expone por adb sobre TCP (ver docker-compose.yml y el README).
FROM amazoncorretto:17

WORKDIR /app

# El wrapper de Gradle 9 invoca xargs; la imagen base de Amazon Linux no lo trae.
RUN dnf install -y findutils && dnf clean all

COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle
RUN chmod +x gradlew && ./gradlew --version --no-daemon

COPY src ./src

CMD ["./gradlew", "test", "aggregate", "--no-daemon"]
