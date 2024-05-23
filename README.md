# Calculator: Unit Test Examples
![java-toolkit](https://img.shields.io/badge/Java21-Service-important?logo=java)
![java-toolkit](https://img.shields.io/badge/Architecture-Layer-blue)
![java-toolkit](https://img.shields.io/badge/Gradle-Build-yellow)
![production-ready](https://img.shields.io/badge/In%20Develop-ready-green)

## 1. Introducción

Este servicio maneja la Auditoría de los diferentes objetos de Metro.

<div id='id2' />

## 2. Levantando la Aplicación

### 2.1. Pre-Requisitos
* Tener instalado [**Java 21**](https://www.oracle.com/java/technologies/downloads/).
* Tener instalado [**Gradle 8.6**](https://gradle.org/install/).

### 2.3. Compilando la Aplicación

En el directorio raiz se debe ejecutar el siguiente comando:
```shell script
./gradlew clean bootJar
```

Esto genera el archivo `unit-test-calculator-example.jar` en el directorio `/runner/app-service/build/libs`

<div id='id2.4' />

### 2.4. Ejecutando la Aplicación

En el directorio raiz se debe ejecutar el siguiente comando:
```shell script
./gradlew clean bootRun
```
También se puede ejecutar directamente el **jar** con el siguiente comando:
```shell script
java -jar runner/build/libs/unit-test-calculator-example.jar
```

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.5/gradle-plugin/reference/html/#build-image)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#appendix.configuration-metadata.annotation-processor)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

