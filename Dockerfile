# Temel image olarak Java içeren resmi OpenJDK kullan
FROM openjdk:17-jdk-slim

# JAR dosyasını container içine kopyala
COPY build/libs/*.jar app.jar

# Uygulamayı başlat
ENTRYPOINT ["java","-jar","/app.jar"]
