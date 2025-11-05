# DoctorYa 🏥

[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.0-blue.svg)](https://kotlinlang.org)
[![Android](https://img.shields.io/badge/Android-26%2B-green.svg)](https://developer.android.com)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.09-blue.svg)](https://developer.android.com/jetpack/compose)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

Una aplicación moderna de Android para gestión médica, construida con las últimas tecnologías y mejores prácticas de desarrollo.

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Arquitectura](#-arquitectura)
- [Tecnologías](#-tecnologías)
- [Requisitos](#-requisitos)
- [Instalación](#-instalación)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Testing](#-testing)
- [Contribuir](#-contribuir)
- [Licencia](#-licencia)

## ✨ Características

- 🏥 **Gestión de usuarios médicos**: Visualización y administración de perfiles de usuarios
- 💾 **Almacenamiento local**: Persistencia de datos con Room Database
- 🌐 **Sincronización en la nube**: Integración con API REST mediante Retrofit
- 🤖 **Inteligencia Artificial**: Integración con Firebase AI para funcionalidades inteligentes
- 🎨 **Interfaz moderna**: UI construida completamente con Jetpack Compose
- 🌙 **Material Design 3**: Diseño moderno siguiendo las últimas guías de Material Design
- 📱 **Navegación fluida**: Sistema de navegación tipo-seguro con Navigation 3
- 💉 **Inyección de dependencias**: Configuración completa con Hilt/Dagger

## 🏗 Arquitectura

El proyecto sigue los principios de **Clean Architecture** con separación clara de responsabilidades:

```
app/
├── data/              # Capa de datos
│   ├── Local/         # Fuente de datos local (Room)
│   ├── Remote/        # Fuente de datos remota (Retrofit)
│   ├── model/         # DTOs y Entities
│   └── Repository     # Implementación del repositorio
├── domain/            # Capa de dominio (Lógica de negocio)
│   ├── model/         # Modelos de dominio
│   └── usecases/      # Casos de uso
├── ui/                # Capa de presentación
│   ├── screens/       # Pantallas de la aplicación
│   └── theme/         # Tema y estilos
├── di/                # Módulos de inyección de dependencias
└── utils/             # Utilidades y helpers
```

### Capas de la Arquitectura

#### 📊 Capa de Datos
- **Local**: Room Database para persistencia local
- **Remote**: Retrofit para comunicación con APIs
- **Repository**: Mediador entre fuentes de datos y casos de uso

#### 💼 Capa de Dominio
- **Use Cases**: Lógica de negocio encapsulada y reutilizable
  - `GetUsersUseCase`: Obtener usuarios desde la API
  - `GetUsersDb`: Obtener usuarios desde la base de datos local
  - `InsertUsersUseCase`: Guardar usuarios en la base de datos
- **Models**: Modelos de dominio independientes de frameworks

#### 🎨 Capa de Presentación
- **MVVM Pattern**: ViewModels para gestión de estado
- **Jetpack Compose**: UI declarativa y reactiva
- **Navigation**: Navegación tipo-seguro con Kotlin Serialization

## 🛠 Tecnologías

### Core
- **Kotlin 2.2.0**: Lenguaje de programación principal
- **Min SDK 26**: Android 8.0 Oreo y superior
- **Target SDK 35**: Android 15
- **Jetpack Compose**: UI toolkit moderno

### Arquitectura y Patrones
- **Clean Architecture**: Separación de capas y responsabilidades
- **MVVM**: Patrón de arquitectura para la UI
- **Repository Pattern**: Abstracción de fuentes de datos
- **Use Cases**: Encapsulación de lógica de negocio

### Librerías Principales

#### UI & Navigation
- **Jetpack Compose** (BOM 2024.09.00): Framework de UI declarativa
- **Material Design 3**: Sistema de diseño moderno
- **Material Icons Extended**: Conjunto completo de iconos
- **Navigation 3** (1.0.0-alpha11): Navegación tipo-seguro
- **Core SplashScreen**: Pantalla de inicio nativa

#### Networking & Serialization
- **Retrofit 2.9.0**: Cliente HTTP tipo-seguro
- **Gson Converter**: Serialización JSON
- **Kotlinx Serialization 1.9.0**: Serialización de Kotlin

#### Database
- **Room 2.8.0**: Base de datos local
  - Runtime, KTX, Paging 3
  - KSP para generación de código

#### Dependency Injection
- **Hilt 2.56.2**: Inyección de dependencias
- **Hilt Navigation Compose**: Integración con Navigation

#### Cloud & AI
- **Firebase BOM 34.0.0**: Plataforma de Firebase
- **Firebase AI**: Funcionalidades de inteligencia artificial

#### Storage
- **DataStore Preferences 1.1.7**: Almacenamiento de preferencias

#### Testing
- **JUnit 4.13.2**: Framework de testing
- **MockK 1.14.6**: Mocking para Kotlin
- **Turbine 1.2.1**: Testing de Flows
- **AssertJ 3.25.3**: Aserciones fluidas
- **Coroutines Test 1.10.2**: Testing de corutinas

## 📦 Requisitos

- **JDK 11** o superior
- **Android Studio Ladybug** (2024.3.1) o superior
- **Gradle 8.10.0**
- **Conexión a Internet** para sincronización de datos

## 🚀 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/luisiscander/DoctorYa.git
cd DoctorYa
```

### 2. Abrir en Android Studio

1. Abre Android Studio
2. Selecciona `File -> Open`
3. Navega hasta la carpeta del proyecto clonado
4. Espera a que Gradle sincronice las dependencias

### 3. Configuración (Opcional)

Si deseas habilitar Firebase:

1. Ve a [Firebase Console](https://console.firebase.google.com/)
2. Crea un nuevo proyecto o usa uno existente
3. Descarga el archivo `google-services.json`
4. Colócalo en `app/google-services.json`
5. Descomenta la línea en `app/build.gradle.kts`:
   ```kotlin
   // alias(libs.plugins.google.services) // Descomentar esta línea
   ```

### 4. Compilar y ejecutar

```bash
# Usando Gradle Wrapper
./gradlew assembleDebug

# O ejecuta directamente desde Android Studio
```


## 🧪 Testing

El proyecto incluye una configuración completa de testing con las siguientes herramientas:

### Ejecutar Tests

```bash
# Tests unitarios
./gradlew test

# Tests de UI (Instrumentados)
./gradlew connectedAndroidTest
```

### Herramientas de Testing

- **JUnit**: Framework base para tests
- **MockK**: Mocking y stubs para Kotlin
- **Turbine**: Testing de Kotlin Flows
- **AssertJ**: Aserciones expresivas y legibles
- **Coroutines Test**: Testing de código asíncrono

### Ejemplo de Test

```kotlin
@Test
fun `given users when getUsers then return success`() = runTest {
    // Given
    val mockUsers = listOf(user(1, "Dr. John", "drjohn", "john@doctor.ya"))
    
    // When
    val result = getUsersUseCase()
    
    // Then
    assertThat(result).isInstanceOf(Result.Success::class.java)
}
```

## 🤝 Contribuir

Las contribuciones son bienvenidas. Por favor, sigue estos pasos:

1. **Fork** el proyecto
2. Crea una **rama** para tu feature (`git checkout -b feature/AmazingFeature`)
3. **Commit** tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. **Push** a la rama (`git push origin feature/AmazingFeature`)
5. Abre un **Pull Request**

### Convenciones de Código

- Sigue las [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Usa nombres descriptivos para variables y funciones
- Documenta funciones públicas con KDoc
- Escribe tests para nuevas funcionalidades
- Mantén las funciones pequeñas y con una sola responsabilidad

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

## 👨‍💻 Autor

**Luis Iscander** - [@luisiscander](https://github.com/luisiscander)

## 📞 Contacto

Si tienes preguntas o sugerencias, no dudes en abrir un issue en el repositorio.

#
Hecho con ❤️ y ☕ por la comunidad de desarrolladores Android

