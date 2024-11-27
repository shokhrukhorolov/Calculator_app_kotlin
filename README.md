Calculator App

A simple calculator app built using Kotlin and Jetpack Compose, following the MVVM architecture pattern. The app provides basic arithmetic operations and leverages Rhino JavaScript Engine for evaluating mathematical expressions.

 Features
- Modern UI built with Jetpack Compose.
- Supports basic arithmetic operations (`+`, `-`, `*`, `/`) and percentages (`%`).
- `AC` (All Clear), `C` (Clear last character), and `=` (Calculate result) functionality.
- Real-time input and result display.
- Uses MVVM (Model-View-ViewModel) architecture for clean code organization.
- Responsive layout optimized for Android devices.

 Tech Stack
- Language: Kotlin
- UI Framework: Jetpack Compose
- Architecture: MVVM (Model-View-ViewModel)
- Dependency: Rhino JavaScript Engine (for mathematical expression evaluation)

 Dependencies
The app uses the following libraries and tools:
- [Jetpack Compose](https://developer.android.com/jetpack/compose): For building the UI.
- [Material3](https://developer.android.com/jetpack/androidx/releases/compose-material3): For Material Design components.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata): For observing and managing UI state.
- [Rhino JavaScript Engine](https://github.com/mozilla/rhino): For evaluating complex mathematical expressions.



 How to Build and Run
1. Clone this repository:
   ```bash
   https://github.com/shokhrukhorolov/Calculator_app_kotlin.git
   ```
2. Open the project in Android Studio.
3. Sync the Gradle dependencies.
4. Build and run the app on an emulator or a physical device.

 Folder Structure
- `MainActivity.kt`: Hosts the entry point for the app and integrates with the ViewModel.
- `Calculator.kt`: Contains the Composable functions for the UI, including the button grid and display.
- `CalculatorViewModel.kt`: Implements the ViewModel logic for managing user input and calculations.
- `build.gradle`: Includes all necessary dependencies and project configurations.
