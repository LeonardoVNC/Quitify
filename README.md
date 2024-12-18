# Quitify
## Integrantes:
- Azeñas Portugal Fabian Miguel
- Pacosillo Cuentas Charly Gabriel
- Vacaflor Nina Leonardo Emanuel.
## ¿De qué se trata el proyecto? 
Quitify es un proyecto universitario para la matería de Programación III en la Universidad Privada Boliviana.

Quitify busca ser una aplicación destinada al control y superación de diversas adicciones, incentivando y ayudando al usuario a dejar atrás la adicción de la que busque ``limpiarse''. Se busca lograr este incentivo en el usuario haciendo uso de distintas herramientas que tienen el objetivo de alargar lo máximo posible el tiempo que lleva sin una recaída y en su lugar motivarlo a seguir hábitos más saludables.

Es a través de estas herramientas que se espera poder ayudar al usuario a superar sus malos hábitos. Sin embargo, la mayoría del trabajo recae en el usuario y en su propio deseo de mejorar y dejar atrás su adicción, Quitify es solo una herramienta de apoyo y ayuda. Las herramientas planteadas por el equipo de desarrollo se detallan a continuación.

<div id="logo">
  <ul align="center">
    <img height="250" alt="PNG" src="https://i.ibb.co/xY220Sy/Logo2.png">
    </ul>
</div>

### Contador de Tiempo Limpio
Se trata de un contador de tiempo, el cual medirá el tiempo que lleva el usuario libre de su adicción. Este contador tiene como propósito incentivar al usuario a mantenerse fiel a su objetivo y hacer que dure el mayor tiempo posible. Conforme el tiempo incrementa es mayor el sentimiento de logro y por lo tanto pensar en perder esa racha de tiempo se vuelve una decisión más complicada, disminuyendo la posibilidad de una recaída.
### Actividades y Recomendaciones
Un conjunto de actividades recomendadas para sobrellevar el tiempo y los efectos secundarios de la abstinencia. Hay casos en los que llevar mucho tiempo sin acudir a la adicción puede generar ansiedad (siendo el cigarro uno de los mejores ejemplos), este sentimiento es una de los principales causantes de recaídas, es por esto que se busca ocupar la mente con otras actividades que puedan desviar la atención y evitar la recaída. Además, realizar estas actividades constantemente puede terminar en la creación de un Hobbie saludable para el usuario, lo que además de ayudar a ocupar su mente, puede ser una nueva fuente de emoción en su vida.
### Foro de Comunidad
Se trata de un foro donde los usuarios podrán compartir sus ideas y sus pensamientos. Se espera que desde esta pestaña aquellos que estén listos para abrirse puedan contar sus preocupaciones y buscar apoyo en otros usuarios con los que comparte objetivos. Aún así, esta sección debe ser altamente moderada para evitar la publicación de comentarios inapropiados o malintencionados.

## Instalación y compilación de la Aplicación
Para instalar el programa adecuadamente se deben seguir los siguiente pasos:

###  <summary><h2 style="display: inline-block"><img src="https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/android-studio-icon.png" width=25px>  Instalar Android Studio</h2></summary>
Android Studio es el entorno de desarrollo integrado oficial para la plataforma Android basado en el software de IntelliJ IDEA Community Edition de JetBrains.

Instalaremos este IDE para compilar y ejecutar la aplicación propuesta en este repositorio.

Para instalar Android Studio puede ver el siguiente [video guía](https://www.youtube.com/watch?v=cOlrAd4OJPA) o dirigirse a la [Página oficial de Android Studio](https://developer.android.com/studio?gad_source=1&gclid=EAIaIQobChMIxeSQxPixigMV7UX_AR17iQEuEAAYASAAEgLeNvD_BwE&gclsrc=aw.ds&hl=es-419).

###  <summary><h2 style="display: inline-block"><img src="https://cdn.iconscout.com/icon/free/png-256/free-git-logo-icon-download-in-svg-png-gif-file-formats--brand-development-tools-pack-logos-icons-225996.png?f=webp&w=256" width=25px>  Instalar Git </h2></summary>  
Git es un controlador de versiones ampliamente utilizado en el desarrollo de software y también la herramienta que utilizaremos para hacer la descarga del proyecto mucho más sencilla. Puede descargar git desde la [página oficial de Git](https://git-scm.com/).

###  <summary><h2 style="display: inline-block"><img src="https://cdn-icons-png.flaticon.com/512/124/124837.png" width=25px>  Descargar los archivos del proyecto </h2></summary>
Para descargar los archivos de una manera simple se usa Git, el cual ya tiene una implementación dentro de Android Studio.

Primero se debe acceder a Android Studio, en caso de que se tenga un proyecto abierto, cierrelo para acceder a la siguiente pantalla y haga clic en la opción *Get From VCS*.
<div id="VCS">
  <ul align="center">
    <img alt="PNG" src="https://i.ibb.co/2cLt66k/pro1.jpg">
    </ul>
</div>

En la pestaña que se despliega se debe seleccionar Git como controlador de versiones y detallar la URL desde la que se descargará el proyecto, en nuestro caso se trata de la URL de este repositorio: https://github.com/LeonardoVNC/Quitify

Además se debe detallar la dirección del directorio donde se almacenará el proyecto una vez se complete su descarga.

<div id="ConfigClone">
  <ul align="center">
    <img alt="PNG" src="https://i.ibb.co/Zfv8wKp/pro2.jpg">
    </ul>
</div>

Una vez se hayan configurado estos datos se puede proceder a clonar el proyecto dentro de su dispositivo. Para esto, clickee en el botón *Clone*.

<div id="Clone">
  <ul align="center">
    <img alt="PNG" src="https://i.ibb.co/THKLtWQ/pro3.jpg">
    </ul>
</div>

El proceso de clonación del repositorio iniciará. Después de haberse completado es necesario copiar el archivo **google_services.json**, el cual contiene información sensible, por lo que para obtenerlo puede comunicarse con el equipo de desarrollo y se lo proporcionaremos. 
Una vez tenga el archivo, debe copiarlo y pegarlo en la carpeta *src* de la vista *Project*.
<div id="json1">
  <ul align="center">
    <img alt="PNG" src="https://i.ibb.co/wLmDDWJ/pro4.jpg">
    </ul>
</div>
<div id="json2">
  <ul align="center">
    <img alt="PNG" src="https://i.ibb.co/2NMTxxK/pro5.jpg">
    </ul>
</div>

Una vez copiado el archivo ya tiene el proyecto listo para ejecutarse, pero es recomendable hacer una sincronización Gradle del proyecto. Para esto vea en la esquina superior derecha y haga clic en el ícono de Gradle.
<div id="gradle">
  <ul align="center">
    <img alt="PNG" src="https://i.ibb.co/b5DLF6k/pro6.jpg">
    </ul>
</div>

###  <summary><h2 style="display: inline-block"><img src="https://cdn-icons-png.flaticon.com/512/8212/8212668.png" width=35px>  Compilar y ejecutar la aplicación </h2></summary>
Es posible ejecutar la aplicación en un dispositivo virtual creado desde Android Studio o conectar un dispositivo físico que tenga la depuración por USB o por WiFi activada. Puede ver las siguientes guías para 
[configurar un dispositivo virtual](https://developer.android.com/studio/run/managing-avds?hl=es-419) o para [configurar un dispositivo físico](https://developer.android.com/studio/run/device?hl=es-419).

Una vez establecido el dispositivo de prueba se puede ejecutar la aplicación. Para ejecutarla no hace falta más que presionar el botón de *Run'App'* ubicado en la parte superior de la pantalla
<div id="run">
  <ul align="center">
    <img alt="PNG" src="https://i.ibb.co/mBdVffx/pro7.jpg">
    </ul>
</div>

Al dar clic en el botón *Run'App'* se iniciará un proceso de construcción Gradle, una vez terminado se pasará a la instalación de la apk en el dispositivo, en caso de que sea la primera vez que se instale en el dispositivo se pedirá confirmación, caso contrario simplemente se actualizará la aplicación a la última versión.

## Agradecimientos
Queremos agradecer a otras aplicaciones Android que comparten el objetivo de luchar contra las adicciones del usuario y de las cuales se tomó inspiración para el desarrollo de Quitify. Las aplicaciones de las que se tomó inspiración son:
- [I am Sober](https://iamsober.com/es/site/home).
- [Quitizilla](https://www.quitzilla.com/).
- [Dopamine Detox](https://play.google.com/store/apps/details?id=com.draxex.dopamine_detox&hl=es_BO).
