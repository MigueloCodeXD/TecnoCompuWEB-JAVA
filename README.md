Evidencia de producto: GA7-220501096-AA2-EV02 Título: Módulos de software codificados y probados

Desarrollado por los aprendices pertenecientes a la ficha de ADSO - 2977435

Miguel Alfredo Bermudez Longas
Javier Alexander Echeverry Agudelo

Proyecto Java Web: TecnoCompu
Este proyecto es una aplicación web Java funcional, utilizando Servlets y JSP, diseñada para ser compatible con Apache Tomcat 9 y gestionada con Maven. Incluye una base de datos embebida H2 y está configurado para un desarrollo sencillo en Visual Studio Code.

Características
Tecnologías: Java Web App (Servlets y JSP)

Servidor: Apache Tomcat 9+

Base de Datos: H2 (modo archivo ~/tecnocompu.mv.db)

Gestor de Proyecto: Maven

IDE Recomendado: Visual Studio Code con extensiones de Java y Tomcat.

Estilo: Tema oscuro "gamer" con acentos morados.

Estructura del Proyecto
tecnocompu/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── tecnocompu/
│   │   │           ├── dao/
│   │   │           │   ├── ContactDAO.java
│   │   │           │   └── UserDAO.java
│   │   │           ├── model/
│   │   │           │   ├── Contact.java
│   │   │           │   └── User.java
│   │   │           ├── servlet/
│   │   │           │   ├── ContactServlet.java
│   │   │           │   ├── LoginServlet.java
│   │   │           │   └── RegisterServlet.java
│   │   │           └── util/
│   │   │               └── DBUtil.java
│   │   ├── resources/
│   │   │   └── schema.sql
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       ├── css/
│   │       │   └── style.css
│   │       ├── contact.jsp
│   │       ├── index.jsp
│   │       ├── login.jsp
│   │       └── register.jsp
└── README.md

Requisitos Previos
Java Development Kit (JDK): Versión 11 o superior.

Apache Maven: Versión 3.6.0 o superior.

Apache Tomcat: Versión 9.0 o superior.

Visual Studio Code: Con las siguientes extensiones:

Extension Pack for Java (Microsoft)

Apache Tomcat (Microsoft)

Maven for Java (Microsoft)

Configuración y Ejecución
Sigue estos pasos para configurar y ejecutar el proyecto:

1. Crear la estructura del proyecto
Crea una carpeta raíz para el proyecto (por ejemplo, tecnocompu) y luego crea la estructura de directorios descrita arriba. Copia el contenido de cada bloque de código proporcionado en el archivo correspondiente.

2. Configurar la Base de Datos H2
La base de datos H2 se creará automáticamente la primera vez que la aplicación intente conectarse. El archivo schema.sql contiene las instrucciones para crear las tablas usuarios y contactos.

Ubicación de la DB: La base de datos se almacenará en tu directorio de usuario bajo el nombre tecnocompu.mv.db (por ejemplo, C:\Users\TuUsuario\tecnocompu.mv.db en Windows o /home/TuUsuario/tecnocompu.mv.db en Linux/macOS).

3. Compilar el Proyecto con Maven
Abre una terminal en la carpeta raíz de tu proyecto (tecnocompu) y ejecuta el siguiente comando Maven para compilar el proyecto y descargar las dependencias:

mvn clean install

Esto generará un archivo tecnocompu.war en la carpeta target/.

4. Configurar Tomcat en Visual Studio Code
Abre Visual Studio Code.

Ve a la pestaña "Extensions" (Ctrl+Shift+X) y asegúrate de tener instalada la extensión "Apache Tomcat".

En la barra lateral izquierda, busca el icono de Tomcat (un gato). Haz clic en él.

Haz clic en el botón + en la sección "Tomcat Servers" para añadir un nuevo servidor.

Selecciona la ruta de instalación de tu Apache Tomcat 9.

5. Desplegar y Ejecutar la Aplicación
En la vista de Tomcat en VS Code, expande tu servidor Tomcat.

Haz clic en el botón + en la sección "Deployed WAR Packages".

Navega hasta la carpeta target de tu proyecto y selecciona el archivo tecnocompu.war.

Una vez desplegado, haz clic en el botón de "Start" (la flecha verde) junto al nombre de tu servidor Tomcat para iniciarlo.

La aplicación estará accesible en tu navegador en: http://localhost:8080/tecnocompu/ (o el puerto que tenga configurado tu Tomcat si es diferente de 8080).

6. Uso de la Base de Datos H2
Para acceder a la consola web de H2 y ver los datos (opcional):

Asegúrate de que la aplicación web esté en ejecución.

Abre tu navegador y ve a http://localhost:8080/tecnocompu/h2-console.

En la consola de H2, introduce la siguiente información:

JDBC URL: jdbc:h2:~/tecnocompu (asegúrate de que coincida exactamente con la configuración en DBUtil.java)

User Name: sa (o el usuario que hayas configurado en DBUtil.java, por defecto sa)

Password: (déjalo en blanco, por defecto no tiene contraseña)

Haz clic en "Connect".

Podrás ver las tablas USUARIOS y CONTACTOS y ejecutar consultas SQL.

Navegación de la Aplicación
login.jsp: http://localhost:8080/tecnocompu/ (o al iniciar la aplicación)

register.jsp: Accesible desde el enlace en login.jsp.

index.jsp: Accesible después de un inicio de sesión exitoso.

contact.jsp: Accesible desde el enlace en index.jsp.

Repositorio: https://github.com/MigueloCodeXD/TecnoCompuJavaWEB

¡100% Funcional :D!