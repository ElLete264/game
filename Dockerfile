# Etapa 1: Construcción del proyecto con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos el proyecto Maven al contenedor
COPY . .

# Compilamos el proyecto, lo que genera el .jar
RUN mvn clean install

# Etapa 2: Imagen final ligera solo con el .jar generado
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiamos el JAR generado desde la etapa de build
COPY --from=build /app/target/Ahorcado-1.0-SNAPSHOT.jar /app/ahorcado-lib.jar

# Ejecutamos el juego al iniciar el contenedor
CMD ["java", "-jar", "/app/ahorcado-lib.jar"]
