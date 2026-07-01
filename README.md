# Products API

## 1. Resumen del proyecto
Este proyecto implementa un microservicio para la gestión de productos y movimientos, desarrollado como ejercicio académico con enfoque en arquitectura hexagonal, validación y manejo centralizado de errores.

El sistema expone APIs HTTP documentadas con OpenAPI/Swagger, una API GraphQL para productos y utiliza una base de datos MySQL para persistencia.

## 2. Objetivo académico
El propósito del proyecto es evidenciar la aplicación integrada de los siguientes conceptos:

- Diseño por capas con separación de responsabilidades.
- Arquitectura Hexagonal (puertos y adaptadores).
- Desarrollo de APIs REST con Spring Boot.
- Persistencia relacional con JPA/Hibernate.
- Validación de datos de entrada.
- Documentación técnica de API con OpenAPI.
- Pruebas unitarias/integración con el ecosistema de Spring Test.
- Exposición de endpoints REST y GraphQL.

## 3. Stack tecnológico utilizado
### 3.1 Lenguaje y plataforma
- Java 21
- Spring Boot 3.2.5
- Maven (gestión de dependencias y construcción)

### 3.2 Frameworks y librerías principales
- spring-boot-starter-web: construcción de endpoints REST.
- spring-boot-starter-data-jpa: acceso a datos con JPA/Hibernate.
- spring-boot-starter-validation: validación con Jakarta Validation.
- mysql-connector-j: conector JDBC para MySQL.
- springdoc-openapi-starter-webmvc-ui 2.5.0: documentación OpenAPI y Swagger UI.
- spring-boot-starter-graphql: exposición de operaciones GraphQL.
- spring-graphql-test: utilidades para pruebas GraphQL.
- Lombok: reducción de código boilerplate.

### 3.3 Base de datos
- MySQL 8
- Esquema objetivo: products_db.

## 4. Arquitectura del proyecto
La organización del código responde a una arquitectura hexagonal:

- Capa de dominio (domain): entidades/modelos, puertos de entrada y salida, y excepciones del negocio.
- Capa de aplicación (application): casos de uso y servicios de aplicación.
- Adaptadores de entrada (adapter.in): API REST, API GraphQL, DTOs y mapeadores web.
- Adaptadores de salida (adapter.out): persistencia JPA, entidades, repositorios y mapeadores hacia infraestructura.
- Configuración transversal (config/exception): OpenAPI y manejo global de errores.

Esta estructura favorece desacoplamiento, mantenibilidad y testabilidad.

## 5. Requisitos previos
Para construir y ejecutar el proyecto localmente se requiere:

- JDK 21.
- Maven 3.9+.
- MySQL ejecutándose y accesible desde el host (por defecto: 127.0.0.1:3306).

## 6. Configuración de entorno
La aplicación usa variables de entorno con valores por defecto definidos en application.properties:

- DB_HOST (default: 127.0.0.1)
- DB_PORT (default: 3306)
- DB_NAME (default: products_db)
- DB_USERNAME (default: root)
- DB_PASSWORD (default: root)

Ejemplo en PowerShell (opcional, si desea sobrescribir defaults):

```powershell
$env:DB_HOST="127.0.0.1"
$env:DB_PORT="3306"
$env:DB_NAME="products_db"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="root"
```

Nota: con la configuración actual, Hibernate utiliza ddl-auto=update, por lo que el esquema se ajusta automáticamente según el modelo.

## 7. Proceso de construcción
### 7.1 Limpieza y compilación
Desde la raíz del proyecto:

```bash
mvn clean compile
```

Resultado esperado:
- Resolución de dependencias.
- Compilación de clases en target/classes.

### 7.2 Ejecución de pruebas
```bash
mvn test
```

Resultado esperado:
- Ejecución de pruebas definidas en src/test/java.
- Reportes en target/surefire-reports.

### 7.3 Empaquetado
```bash
mvn clean package
```

Resultado esperado:
- Generación del artefacto ejecutable en target/.

## 8. Cómo usar el proyecto
### 8.1 Ejecutar la aplicación
Opción A (recomendada en desarrollo):

```bash
mvn spring-boot:run
```

Opción B (jar empaquetado):

```bash
java -jar target/products-0.0.1-SNAPSHOT.jar
```

La API queda disponible en:
- http://localhost:8080

### 8.2 Documentación interactiva
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

- GraphiQL: http://localhost:8080/graphiql

### 8.3 API REST de productos
Base path: /api/productos

1. Listar productos
```http
GET /api/productos
```

2. Obtener producto por ID
```http
GET /api/productos/{id}
```

3. Crear producto
```http
POST /api/productos
Content-Type: application/json

{
  "nombre": "Laptop Dell XPS 15",
  "descripcion": "Procesador Intel Core i7, 16GB RAM",
  "precio": 1299.99
}
```

4. Actualizar producto
```http
PUT /api/productos/{id}
Content-Type: application/json

{
  "nombre": "Laptop Dell XPS 15 (2026)",
  "descripcion": "32GB RAM, SSD 1TB",
  "precio": 1499.99
}
```

5. Eliminar producto
```http
DELETE /api/productos/{id}
```

### 8.4 API REST de movimientos
Base path: /api/movimientos

1. Listar movimientos
```http
GET /api/movimientos
```

2. Obtener movimiento por ID
```http
GET /api/movimientos/{id}
```

3. Crear movimiento
```http
POST /api/movimientos
Content-Type: application/json

{
  "productoId": 1,
  "fechaHora": "2026-06-30T10:30:00",
  "cantidad": 10,
  "pesoEmpaqueKg": 0.45,
  "margenGanancia": 0.20,
  "imagenEvidencia": "https://example.com/evidencia.jpg"
}
```

4. Actualizar movimiento
```http
PUT /api/movimientos/{id}
Content-Type: application/json

{
  "productoId": 1,
  "fechaHora": "2026-06-30T12:00:00",
  "cantidad": 12,
  "pesoEmpaqueKg": 0.50,
  "margenGanancia": 0.25,
  "imagenEvidencia": "https://example.com/evidencia-actualizada.jpg"
}
```

5. Eliminar movimiento
```http
DELETE /api/movimientos/{id}
```

### 8.5 API GraphQL de productos
Ruta: /graphql

Consulta de ejemplo:
```graphql
query {
  listarTodos {
    id
    nombre
    descripcion
    precio
  }
}
```

Mutación de ejemplo:
```graphql
mutation {
  crear(input: {
    nombre: "Mouse Inalámbrico"
    descripcion: "Bluetooth, recargable"
    precio: 59.9
  }) {
    id
    nombre
    precio
  }
}
```

### 8.6 Ejemplos con curl
Crear:
```bash
curl -X POST "http://localhost:8080/api/productos" \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Teclado Mecanico","descripcion":"Switch Blue","precio":89.90}'
```

Listar:
```bash
curl "http://localhost:8080/api/productos"
```

## 9. Manejo de errores
La API cuenta con un manejador global de excepciones que normaliza respuestas HTTP para casos como:

- Recurso no encontrado (404).
- Errores de validación de entrada (400).
- Servicio no disponible (503).
- Errores no controlados (500).

En GraphQL, los mismos casos se traducen a errores con extensiones estructuradas para conservar el código y el tipo de fallo.

## 10. Estructura general del repositorio
- pom.xml: definición del proyecto Maven y dependencias.
- src/main/java: código fuente principal.
- src/main/resources/application.properties: configuración de aplicación.
- src/test/java: pruebas.
- target/: artefactos y reportes generados por Maven.

## 11. Conclusión
El proyecto Products API constituye una implementación académica completa de un microservicio para gestión de productos y movimientos, integrando prácticas modernas de ingeniería de software en Java: arquitectura desacoplada, documentación automática, validaciones robustas, pruebas y exposición tanto REST como GraphQL.

Como resultado, el sistema no solo cumple con el objetivo funcional de gestión, sino que también ofrece una base sólida para evolución, mantenimiento y despliegue en entornos reales.
