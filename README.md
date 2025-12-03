# 🛍️ PerfulandiaBackend - API RESTful

Este proyecto constituye el **backend del sistema Perfulandia**, diseñado para gestionar la lógica de negocio y la persistencia de datos para la entidad `Perfume`. Fue desarrollado con **Spring Boot** como parte de la asignatura DSY1104 (Desarrollo Fullstack II).

## ✨ Características Principales

La aplicación expone una API REST robusta, centrada en la eficiencia de datos y la documentación clara:

  * **Framework Principal:** **Spring Boot 4.0.0**, utilizando **Java 21**.
  * **Capa de Persistencia:** Implementación de **Spring Data JPA** y **Hibernate** para la gestión de la base de datos.
  * **Base de Datos:** **MySQL**, configurada en `application.properties` para la base de datos `perfulandia_db`.
      * La propiedad `spring.jpa.hibernate.ddl-auto=update` permite la creación y actualización automática del esquema de la tabla `Perfume` en el inicio.
  * **CORS:** Configurado mediante la anotación `@CrossOrigin(origins = "http://localhost:3000")` para permitir peticiones del frontend de React.
  * **Documentación:** Integración con **Swagger (Springdoc OpenAPI)** para una exploración y prueba sencilla de todos los endpoints.

### 🗃️ Entidad Principal: `Perfume`

La entidad modela los productos del catálogo con los siguientes campos:

  * `id` (`Long`): Clave primaria generada automáticamente (`GenerationType.IDENTITY`).
  * `nombre`, `marca`, `descripcion`, `notas`, `descuento` (`String`).
  * `precio`, `precioViejo` (`Double`).
  * `imagen` (`String`): URL o ruta de la imagen.

-----

## 🔗 Endpoints del API (CRUD)

El controlador `PerfumeController` expone los siguientes endpoints para la gestión de datos:

| Método | URL | Funcionalidad |
| :--- | :--- | :--- |
| `GET` | `/api/perfumes` | **Listar:** Obtiene la lista completa de perfumes (Catálogo). |
| `GET` | `/api/perfumes/{id}` | **Detalle:** Obtiene un perfume específico por su ID. |
| `POST` | `/api/perfumes` | **Crear:** Agrega un nuevo perfume a la base de datos (Usado por el formulario de Admin). |
| `PUT` | `/api/perfumes/{id}` | **Actualizar:** Modifica los datos de un perfume existente por ID (Usado por el formulario de Admin). |
| `DELETE` | `/api/perfumes/{id}` | **Eliminar:** Borra un perfume de la base de datos por ID. |

-----

## ⚙️ Configuración y Ejecución

### Requisitos Previos

1.  **Java JDK 17 o superior** (el proyecto usa Java 21).
2.  **Apache Maven**.
3.  **Servidor MySQL** ejecutándose (ej. con XAMPP o Laragon) en `localhost:3306`.
4.  **Base de Datos:** Una base de datos llamada `perfulandia_db` debe existir en tu servidor MySQL.

### Pasos de Inicio

1.  **Instalar Dependencias** (en la carpeta raíz del proyecto):
    ```bash
    mvn clean install
    ```
2.  **Iniciar el Backend:**
    ```bash
    mvn spring-boot:run
    ```

### Verificación y Pruebas

  * **Servidor:** La aplicación se inicia en `http://localhost:8080`.
  * **Documentación API:** Accede a la interfaz interactiva de Swagger para probar el CRUD:
    ```
    http://localhost:8080/swagger-ui.html
    ```

-----

## 👨‍💻 Autor

  * **Alonso Rivadeneira Barrales**
  * **Asignatura:** DSY1104 - Desarrollo Fullstack II
  * **Institución:** Duoc UC
  * **Contacto Frontend:** PerfulandiaReactt (para la capa de presentación)
