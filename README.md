Este proyecto consta de los siguientes microservicios:
* parent-server: proyecto raiz
    * config-server: servidor spring-cloud que recupera las propiedades de configuración de cada uno de los microservicios
    * eureka-server: servidor en el que se publican todos los microservicios, hace el balanceo, es necesario tener instalado un 
    gestor de colas, yo he usado rabbitMq
    * zuul-server: servidor que actua como proxy para centralizar las llamadas y enviarlas al microservicio que corresponda
    * login-server: es el microservicio encargado de la gestión de los tokens, se ha utilizado oauth2 con jwt y este servidor actúa 
    como AuthServer
    * user-server: es un ResourceServer que se encarga de la gestión de los usuarios
    * image-server: es un ResourceServer que se encarga de la gestión de las imagenes asiociadas a los teléfonos
    * productos-server: es el ResourceServer encargado de realizar la gestión de los distintos productos, en este caso teléfono.
    
La base de datos que se ha usado es MySql, el script de generación de las tablas está en parent-server/src/db/bbdd.sql

Tras hacer un clean instal de los proyectos, para levantar los microservicios se puede realizar mediante una tarea java o mediante maven
mvn clean spring-boot:run

El frontal se ha realizado en Angular 4, para levantarlo se debe hacer un nmp-install para descargar la carpeta app-module, y tras ello, un
ng-build para compilarlo y un ng-serve para publicarlo, para ello se ha utilizado el visual studio code

Se ha usado Swagger para documentar cada uno de los microservicios.

Se encuentra publicado en la URL
http://localhost:3333/swagger-ui.html

La aplicación esta securizada, permitiendo ver el listado de teléfonos dados de alta en la aplicación sin necesidad de hacer login,
para poder añadir telefonos y generar facturas es necesario loguearse (pablo/pablo).
