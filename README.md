Proyecto para promocion gerente T
===================================
El presente proyecto se ha realizado utilizando el framework de backend con el arquetipo web, a continuación indicaremos unas pautas para facilitar el uso de la aplicación.

**Prerequisitos**
- Docker (se tienen dockerizadas tanto la aplicacion como la base de datos)
- Postman
- Cliente de postgres

**Ejecutar la aplicacion**

1. Para poder ejecutar el proyecto primero debemos generar el fichero `jar` ubicandonos en la carpeta `raiz` del proyecto y ejecutando el comando
   ```
    mvn clean install
    ```
2. Despues de haber generado el `jar` ya podemos crear el contenedor `docker` en donde se ejecutará, ademas de levantar la base de datos, ubicandonos en la carpeta `devops/docker` y ejecutando el comando
   ```
    docker-compose up
    ```
   Con estos pasos ya se tiene la aplicacion y la base de datos listas para su uso.

**Contratos**\
Para la creacion del fichero `zhuquing-openapi-v3.yaml` que define el contrato se ha utilizado la dependencia de `openapi`, que habilita endpoints para la generacion del mismo a partir de las clases definidas como controladores,
el fichero se encuentra en la carpeta `contracts`dentro del modulo `api-rest`. También se ha facilitado la colleccion de postman `pruebat.postman_collection.json`(generado a partir del contrato) para realizar pruebas en la carpeta `postman`.

**Credenciales**\
Para empezar a realizar pruebas, dado que el proyecto esta securizado con JWT, tenemos que obtener un token desde el endpoint `/auth/login` enviandole las credenciales del usuario ya registrado, en este caso
- Usuario: zhuquing
- Contraseña: pass123

**Perfiles**\
Para agilizar el desarrollo del proyecto se han establecido los perfiles
- **Local:** Usado por el desarrollador para realizar pruebas rapidas sin necesidad de volver a generar la imagen de docker.
- **Docker:** Para que el examinador solo necesite ejecutar el contenedor de docker para realizar las pruebas que considere necesarias.

**Notas**\
Para la creacion de vehiculos se han definido los tipos TRUCK y DRON que son los que se esperan recibir cuando realizamos las llamadas a al creacion y/o actualizacion de estos.
