#FROM maven:3.9.9-eclipse-temurin-21 AS builder
#
#WORKDIR /app
#
#COPY pom.xml .
#
#RUN mvn dependency:go-offline -B
#
#COPY src ./src
#
#RUN mvn clean package -DskipTests
#
#FROM openjdk:21-jdk AS runner
#
#WORKDIR /app
#
#COPY --from=builder /app/target/patient-service-0.0.1-SNAPSHOT.jar app.jar
#
#EXPOSE 4000
#
#ENTRYPOINT ["java", "-jar", "app.jar"]


# ---------- Build Stage ----------
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy only the pom.xml first (to leverage Docker layer caching)
COPY pom.xml .

# Use Docker build cache for Maven dependencies
RUN --mount=type=cache,target=/root/.m2 \
    mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the app with Maven, using the same cached .m2 repo
RUN --mount=type=cache,target=/root/.m2 \
    mvn clean package -DskipTests


# ---------- Runtime Stage ----------
FROM openjdk:21-jdk AS runner

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/auth-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 4005

ENTRYPOINT ["java", "-jar", "app.jar"]
