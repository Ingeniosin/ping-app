# Usar una imagen base de Java 17
FROM openjdk:17-slim AS build

# Directorio de trabajo
WORKDIR /workspace/app

# Copiar archivos de construcción
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Conceder permisos de ejecución al script gradlew y construir la aplicación
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

# Iniciar una nueva etapa y copiar el jar resultante
FROM openjdk:17-slim
COPY --from=build /workspace/app/build/libs/*.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app.jar"]
