# ✅ Challenge Completed: Practicing Object-Oriented Programming

📜 **Project Conclusion and Improvements Implemented** 📜

Welcome to the results of the **PRACTICING THE OBJECT-ORIENTED PROGRAMMING PARADIGM** challenge, promoted by the **Digital Innovation One** platform 💙. This project aimed to apply the fundamental pillars of Object-Oriented Programming (OOP): **Abstraction**, **Encapsulation**, **Inheritance**, and **Polymorphism**. Below, I detail the improvements made to the original code and the progress achieved.

---

## 💎 Project Goal

The main objective was to implement a system modeling the domain of a **Bootcamp**, using OOP tools to create classes such as `Bootcamp`, `Course`, `Mentoring`, and `Developer`, with clearly defined relationships and encapsulated behaviors.

---

## 🛑 Tools Used

- ✅ Java JDK 21  
- ✅ IDE: Visual Studio Code  

---

## 🔧 Improvements Implemented

To make the project more robust and accessible, the following changes were made to the original code:

1. **Refactoring to English**:
   - All class names, attributes, methods, and comments were translated from Portuguese to English, following standard naming conventions (e.g.: `Curso` → `Course`, `Mentoria` → `Mentoring`).
   - This change improves readability for international developers and aligns the project with global development standards.
   - Example: The `Bootcamp` class now has attributes like `name` and `description` instead of `nome` and `descrição`.

2. **Constructor Initialization**:
   - All class constructors were reviewed and properly initialized.
   - Parameterized constructors were added to directly initialize attributes upon object creation, ensuring no object is instantiated with null or undefined values.
   - Example: The `Course` class constructor now initializes `title`, `description`, and `workload` directly:
     ```java
     public Course(String title, String description, int workload) {
         this.title = title;
         this.description = description;
         this.workload = workload;
     }
     ```

3. **Improved Readability and Maintainability**:
   - The code was reorganized to follow OOP best practices, with clear and well-documented methods.
   - Consistent use of access modifiers (`private`, `public`, etc.) to reinforce encapsulation.

---

## 🧮 Code Structure

The project now includes the following main classes, all in English:

- **Content** (abstract class): Defines common attributes and methods for `Course` and `Mentoring`.
- **Course**: Represents a course with a title, description, and workload.
- **Mentoring**: Represents a mentoring session with a title, description, and date.
- **Bootcamp**: Contains a list of contents (`Content`) and enrolled developers (`Developer`).
- **Developer**: Represents a developer who can enroll in a bootcamp and progress through its contents.

---

## 🤝 How to Contribute

This project is open for contributions! Feel free to:

- ⭐ Give a star to the repository.
- 🐛 Report issues or suggest improvements.
- 🍴 Fork it and add your own enhancements.

🚀

---

Original source made available with ♥ by [cami-la](https://www.linkedin.com/in/cami-la/ "cami-la").

**Developed with 💙 by Caroline.**
