📌 Proyecto Backend – Spring Boot (Java 21)

Este proyecto corresponde al backend de la aplicación, desarrollado con Spring Boot y Java 21, siguiendo principios de arquitectura limpia, buenas prácticas y exposición de APIs REST.

El objetivo de este README es permitir que cualquier persona que clone el repositorio pueda ejecutar el proyecto correctamente, incluso si se presentan problemas comunes de configuración inicial.

🛠️ Tecnologías utilizadas

Java 21 (Amazon Corretto)

Spring Boot

Maven

JPA / Hibernate

REST API

📋 Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

Java 21 (recomendado: Amazon Corretto 21)

Maven

IDE (IntelliJ IDEA recomendado)

Verificar versión de Java:

java -version

🚀 Ejecución del proyecto
1️⃣ Clonar el repositorio

git clone https://github.com/yeison1ruano2/ciberNacionBack.git

2️⃣ Importar el proyecto en el IDE

Abrir el proyecto como Maven Project

Esperar a que Maven descargue todas las dependencias

⚠️ Configuración necesaria para ejecutar el proyecto

Al clonar el proyecto por primera vez, puede presentarse un error relacionado con procesamiento de anotaciones o un error tipo UNKNOWN / compilation issue, especialmente al usar Lombok u otras anotaciones.

Para solucionar esto, se deben realizar los siguientes ajustes en IntelliJ IDEA:
🔧 1. Habilitar Annotation Processing

Ir a:
Settings / Preferences
→ Build, Execution, Deployment
→ Compiler
→ Annotation Processors
✔️ Activar la opción:
Enable annotation processing
Esto es necesario para que el IDE reconozca correctamente anotaciones como @Getter, @Setter, @Builder, etc.

🔧 2. Configurar la versión de Java en Maven Runner

Ir a:
Settings / Preferences
→ Build, Execution, Deployment
→ Build Tools
→ Maven
→ Runner
En la opción JRE, seleccionar:
Java 21 (Amazon Corretto)
⚠️ Importante:
El proyecto fue desarrollado usando Java 21, por lo que utilizar una versión diferente puede generar errores de compilación.

🔄 3. Recargar dependencias de Maven

Una vez realizados los ajustes:

Click derecho sobre el proyecto

Maven → Reload Project

▶️ Ejecutar la aplicación

Puedes ejecutar el proyecto de cualquiera de estas formas:

Opción 1: Desde el IDE

Ejecutar la clase principal:

Application.java
(o el nombre correspondiente)

Opción 2: Desde consola
mvn spring-boot:run

🌐 Acceso a la aplicación

Por defecto, el backend se ejecuta en:

http://localhost:8080

Las APIs están expuestas bajo rutas REST según la configuración del proyecto.
