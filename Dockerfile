# ---------- BUILD STAGE ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# copy project files
COPY . .

# build jar (force dependency refresh)
RUN mvn clean package -U -DskipTests


# ---------- RUNTIME STAGE ----------
FROM eclipse-temurin:17-jdk

WORKDIR /app

# copy built jar from previous stage
COPY --from=build /app/target/*.jar app.jar

# Render provides dynamic PORT
EXPOSE 8080

# IMPORTANT: use Render PORT if available
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]
