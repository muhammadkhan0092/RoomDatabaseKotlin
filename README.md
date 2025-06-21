# 📚 Android App with Dagger 2, Room DB, and One-to-Many Relations

This project demonstrates a clean **MVVM architecture** using modern Android development tools and best practices.

## 🔧 Tech Stack

- ✅ **Dagger 2** – For manual dependency injection  
- ✅ **Room Database** – With `@Relation` to model One-to-Many relationships  
- ✅ **Kotlin Flow & StateFlow** – For reactive and real-time data updates  
- ✅ **Paging-ready architecture** – Structured to scale with Paging 3 integration  
- ✅ **Repository & ViewModel Layers** – Clean separation of concerns  
- ✅ **Jetpack Components** – Including ViewBinding, LiveData, and Lifecycle  
- ✅ **Kotlin** – As the primary language  

---

## 💡 Why Dagger 2?

While **Hilt** is now the recommended standard for dependency injection in Android, this project uses **Dagger 2** to help developers understand:

- The **core principles** of DI  
- **Manual bindings** with modules and components  
- **Scopes** and **component hierarchies**  

This hands-on approach provides in-depth knowledge and control, perfect for building foundational DI skills.

---

## 🏛️ Room + One-to-Many Relationship

The app models a real-world relationship using Room entities:

> **One Course → Many Chapters**

This is implemented using Room’s `@Relation` annotation. The app efficiently retrieves and observes joined data using Kotlin **Flow** and **StateFlow**, ensuring real-time UI updates.

---

## 🔁 Features

- 🔹 Insert and retrieve **Courses** and **Chapters**  
- 🔹 Observe data in **real-time** using `StateFlow`  
- 🔹 One-click button to **insert multiple entries**  
- 🔹 UI built with **ViewBinding** and **LiveData**  

---


---

## 🚀 Getting Started

1. **Clone the repo:**
   ```bash
   git clone https://github.com/muhammadkhan0092/RoomDatabaseKotlin.git
   ```

2. **Open in Android Studio**

3. **Build and run the project**

---

## 📁 Architecture

```
com.example.app
├── di               # Dagger 2 Modules & Components
├── data             # Room entities, DAOs, and database
├── repository       # Repository layer
├── ui               # ViewModel and Fragments/Activities
└── utils            # Helper classes
```

---

## 🤝 Contributing

Pull requests are welcome! If you have suggestions for improvements or want to add more features, feel free to fork and open a PR.

---

