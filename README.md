# appium-screenplay-pageobject

Mismo escenario de login resuelto de dos formas —Page Object y Screenplay— sobre una app Android
nativa con Appium. Sirve para comparar ambos patrones con el mismo caso y los mismos localizadores.

La aplicación automatizada es **EriBank** (`1.0.1777`), incluida en `src/test/resources/app/EriBank.apk`.

## Qué incluye

| Implementación | Paquete | Cómo resuelve el login |
|---|---|---|
| Page Object | `eribank.pageobject` | Una clase por pantalla, con los localizadores como constantes y métodos de negocio |
| Screenplay | `eribank.screenplay` | Tareas, preguntas y un modelo con builder |

Ambas se ejecutan en suites separadas (`PageObjectTestSuite` y `ScreenplayTestSuite`) contra el
mismo `authentication.feature`.

## Requisitos

- **JDK 17** (toolchain del build).
- **Android SDK** con un emulador creado y arrancado (`Pixel_2_API_28`, arm64).
- **Appium 3.9** con el driver `uiautomator2`:
  ```sh
  npm i -g appium@3.9.0
  appium driver install uiautomator2@8.7.2
  ```
- **La app instalada** en el emulador:
  ```sh
  adb install -r src/test/resources/app/EriBank.apk
  ```
- **Appium corriendo** en `http://127.0.0.1:4723`.

> [!NOTE]
> En el primer arranque Android muestra el aviso «esta app se construyó para una versión anterior».
> Hay que pulsarlo una vez; no vuelve a aparecer.

## Cómo se ejecuta

```sh
appium &
./gradlew test
```

El informe queda en `target/site/serenity/index.html`.

## Configuración

Todo lo que depende del entorno vive en el bloque `mobile` de `src/test/resources/serenity.conf`:
plataforma, hub, dispositivo, versión y datos de la app. Cualquier clave se puede sobrescribir en la
línea de comandos:

```sh
./gradlew test -Dmobile.android.device.name=host.docker.internal:5555
```

El bloque tiene una sección para Android y otra para iOS, y `mobile.platform` decide cuál se usa.

## Arquitectura: por qué no se usan los verbos de Serenity

Serenity 5 resuelve la visibilidad y la interacción de elementos **ejecutando JavaScript**. En una
app nativa, UiAutomator2 no implementa scripts y responde `405`, y con la configuración habitual
(`webdriver.driver=appium`) la sesión ni siquiera arranca (`NotYetImplementedError`).

Por eso el proyecto hace dos cosas:

1. **`webdriver.driver=provided`** con `CustomAppiumDriver`, que crea la sesión con `UiAutomator2Options`
   y se la entrega a Serenity ya hecha. Serenity no configura nada y sigue generando los reportes.
2. **Interacción con el driver nativo**: la clase `MobileDriver` extrae el `AndroidDriver` de detrás
   del `WebDriverFacade`, y tareas, preguntas y páginas usan `AppiumBy.id` directamente.

La estructura de Screenplay se conserva —actor, tareas, preguntas—, pero los verbos son nativos.

La plataforma se elige por configuración: `-Dplatform=android` (por defecto) o `-Dplatform=ios`,
con opciones de XCUITest en el segundo caso. **iOS no está probado**: no hay dispositivo en este
entorno.

## Docker

El **emulador no va en el contenedor**: las imágenes de Android en Docker son x86 y en un Mac ARM
son inviables. Dockeriza Appium; el emulador se queda en el host.

```sh
# una sola vez: dejar el emulador escuchando en TCP
adb tcpip 5555

docker compose up --abort-on-container-exit
```

| Servicio | Rol |
|---|---|
| `appium` | Appium 3.9 + `uiautomator2`, imagen propia para arm64 |
| `tests` | JDK 17 que ejecuta la suite contra `appium:4723` |

El contenedor de Appium usa la misma clave `adb` del host (montada en el compose), porque el
emulador ya la tiene autorizada.

## Estructura

```text
src/main/java/com/cedaniel200/eribank
├── driver/CustomAppiumDriver.java   # DriverSource: crea la sesión nativa
├── support/MobileDriver.java        # extrae el AndroidDriver del actor
├── pageobject/{pages,steps}         # implementación con Page Object
└── screenplay/{tasks,questions,models,userinterfaces,utils}

src/test
├── java/.../pageobject/runners/PageObjectTestSuite.java
├── java/.../screenplay/runners/ScreenplayTestSuite.java
├── java/.../{pageobject,screenplay}/stepdefinitions/
└── resources/features/authentication.feature
```

## Ten en cuenta

- **EriBank no se actualiza desde 2019.** El enlace oficial sigue vivo, pero no hay versión más
  reciente; su `targetSdk` antiguo provoca el aviso de compatibilidad.
- **El emulador debe estar arrancado** antes de ejecutar. Ni el build ni el compose lo levantan.
- **Las credenciales son de la app** (`company` / `company`), no datos reales.

## Licencia

[MIT](LICENSE) © Cesar Daniel
