# appium-screenplay-pageobject
# [Español]

Proyecto donde se muestra el uso del patrón serenity screenplay con cucumber, gradle y Appium.

Las pruebas de este ejemplo se corren contra la aplicacion EriBank para dispositivos Android, cuyo apk se encuentra en src/test/resources/app/EriBank.apk

## Requerimientos

Para correr el proyecto se necesita:

Java JDK 1.8
 
Gradle preferiblemente con la versión 4.7.

Appium Server version 1.7.2 o superior

Un emulador o dispositivo de android corriendo

## Configurar serenity.properties

Se debe configurar las siguientes propiedades:

**appium.hub** Debe coincidir con la ip y puerto donde va a correr el appium server

**appium.platformVersion** Version de android del emulador que vamos a utilizar

**appium.app** Ubicación de la apk

**appium.deviceName** Nombre del emulador o dispositivo que vas a utilizar, para esto puedes utilizar el adb

    adb devices

Para que el anterior comando funcione adb debe estar como variable de entorno

### Si tiene alguna pregunta, puede escribirme a cdanielmg200@gmail.com

# [English]

Project showing the use of the serenity screenplay pattern with cucumber, gradle and Appium.

The tests in this example are run against the EriBank application for Android devices, whose apk is in src/test/resources/app/EriBank.apk

## Requirements

To run the project you need:

Java JDK 1.8
 
Gradle preferably with version 4.7.

Appium Server version 1.7.2 or later

An emulator or android device running

## Configure serenity.properties

The following properties must be configured:

**appium.hub** Must match the ip and port where the appium server will run

**appium.platformVersion** Android version of the emulator that we are going to use

**appium.app** Location of the apk

**appium.deviceName** Name of the emulator or device that you are going to use, for this you can use the adb

    adb devices

For the previous command to work adb must be as environment variable

### If you have any questions you can write me at cdanielmg200@gmail.com
