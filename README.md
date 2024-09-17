

<!-- PROJECT PRESENTATION -->
<div align="center">

  <h1 align="center">📝 Proyecto de Automatización de Google Forms</h1>

<text>
Este proyecto utiliza Selenium WebDriver con Java para automatizar el llenado de un formulario de Google Forms.
</text>
  <p align="center">
    <a href="">Reportar Bug</a>
    |
    <a href="">Solicitar Feature</a>
  </p>
</div></br>


## 🌟 Descripción

Este proyecto está diseñado para automatizar el proceso de llenado y envío de un formulario de Google Forms utilizando Selenium WebDriver y Java. El formulario a automatizar contiene varias preguntas que son respondidas con datos de prueba.

## 📦 Dependencias

- [Selenium WebDriver](https://www.selenium.dev/)
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)
- [TestNG](https://testng.org)
- [Spring Boot Test](https://docs.spring.io/spring-boot/docs/current/reference/html/test-auto-configuration.html)

## ⚙️ Configuración

1. **Configuración de Selenium WebDriver:**
    - El proyecto usa WebDriverManager para gestionar el controlador del navegador. Asegúrate de que `chromedriver` esté disponible en tu máquina o permita que WebDriverManager lo descargue automáticamente.

2. **Formulario:**
    - La URL del formulario que se va a automatizar está definida en el código


## 📂 Estructura del Proyecto

- **`AutoFormFilterTest.java`**: Contiene la lógica para automatizar el llenado del formulario y la ejecución de pruebas.
- **`Person.java`**: Define la estructura de los datos de prueba.
- **`GenerateData.java`**: Genera datos de prueba para llenar el formulario.

## 🚀 Uso

1. **Ejecución de Pruebas:**
    - Ejecuta las pruebas usando TestNG. Asegúrate de tener el navegador Chrome instalado y actualizado.
    - Las pruebas están configuradas para ejecutarse en Chrome, pero puedes ajustar el código para usar otros navegadores si es necesario.

2. **Llenado del Formulario:**
    - El formulario se llena con datos de prueba proporcionados en el método `createTestPeople()`.
   
<img src="src/main/resources/assets/Preview.gif" alt="Preview of the app" width="800"/>

## 👩🏻‍💻 Mejoras Futuras 
* Manejo con correos
* Validaciones Avanzadas
* Mejorar el manejo de errores y las notificaciones en caso de fallos durante la automatización.
