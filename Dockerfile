FROM gradle:8.10.2-jdk21 AS build

WORKDIR /app

COPY gradle /app/gradle
COPY gradlew /app/gradlew
COPY build.gradle.kts /app/build.gradle.kts
COPY settings.gradle.kts /app/settings.gradle.kts

RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon --parallel --stacktrace

COPY . .

RUN ./gradlew clean bootJar -x test --no-daemon --parallel --stacktrace

FROM amazoncorretto:21-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
