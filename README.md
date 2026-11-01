# Developer Quest Backend

## Requisitos

- Java 21 (el proyecto compila con `java.version=21`).
- Maven 3.9+ o el wrapper incluido.
- PostgreSQL local.

## Configuración local

El desarrollo local usa `application.properties`. Si `.env` ya existe, se conserva y proporciona `DB_URL`, `DB_USER` y `DB_PASSWORD`. Si no existen, la configuración local usa `localhost:5432/developer`, usuario `postgres` y espera la contraseña en `DB_PASSWORD`.

Para iniciar el backend desde esta carpeta:

```powershell
.\mvnw.cmd spring-boot:run
```

Para producción, activa el perfil `prod` mediante `SPRING_PROFILES_ACTIVE=prod` y proporciona `DB_URL`, `DB_USER` y `DB_PASSWORD` desde el entorno seguro del despliegue. Su configuración está en `application-prod.properties`.

En desarrollo local, Hibernate usa `ddl-auto=update` y Flyway está desactivado para facilitar la evolución inicial del modelo. En producción, Hibernate usa `ddl-auto=validate` y Flyway aplica las migraciones versionadas desde `src/main/resources/db/migration`. Antes de desplegar, se deben crear y probar las migraciones correspondientes al esquema; no activar producción con migraciones faltantes.

## Catálogo de mundos

`GET /api/v1/worlds` devuelve el catálogo inicial de ocho mundos en orden curricular. En local, el esquema se crea/actualiza con Hibernate y el catálogo se inserta de manera idempotente al iniciar la aplicación. En producción, Flyway crea la tabla antes de que el catálogo inicial se inserte. Los estados de desbloqueo y el progreso de jugador no forman parte de este endpoint.

## Pruebas

Las pruebas configuran H2 en memoria directamente en el test, por lo que no leen ni modifican la base local configurada en `.env`. No hace falta un archivo `application-test.properties`.

```powershell
.\mvnw.cmd test
```
