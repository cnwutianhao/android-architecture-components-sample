# Android Architecture Components Sample

A NBA app illustrating Android development best practices with Android Jetpack.

---

### Screenshots
<img src="https://github.com/cnwutianhao/android-architecture-components-sample/blob/main/screenshot/players.png" width="200"/>&nbsp;<img src="https://github.com/cnwutianhao/android-architecture-components-sample/blob/main/screenshot/teams.png" width="200"/>&nbsp;<img src="https://github.com/cnwutianhao/android-architecture-components-sample/blob/main/screenshot/player.png" width="200"/>&nbsp;<img src="https://github.com/cnwutianhao/android-architecture-components-sample/blob/main/screenshot/team.png" width="200"/>

---

### Libraries Used
+ Foundation - Components for core system capabilities, Kotlin extensions.
  + AppCompat - Degrade gracefully on older versions of Android.
  + Android KTX - Write more concise, idiomatic Kotlin code.
+ Architecture - A collection of libraries that help you design robust, testable, and maintainable apps. Start with classes for managing your UI component lifecycle and handling data persistence.
  + Data Binding - Declaratively bind observable data to UI elements.
  + Lifecycles - Create a UI that automatically responds to lifecycle events.
  + LiveData - Build data objects that notify views when the underlying database changes.
  + Navigation - Handle everything needed for in-app navigation.
  + Room - Access your app's SQLite database with in-app objects and compile-time checks.
  + ViewModel - Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution.
+ UI - Details on why and how to use UI Components in your apps - together or separate
  + Animations & Transitions - Move widgets and transition between screens.
  + Fragment - A basic unit of composable UI.
  + Layout - Lay out widgets using different algorithms.
+ Third party and miscellaneous libraries
  + Retrofit - for network request
  + Glide - for image loading
  + Hilt - for dependency injection
  + Kotlin Coroutines - for managing background threads with simplified code and reducing needs for callbacks

---

### License
Copyright 2021 Tyhoo Wu.
<br/>
<br/>
Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
<br/>
<br/>
https://www.apache.org/licenses/LICENSE-2.0
<br/>
<br/>
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
