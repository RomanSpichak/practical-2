[![my_Java_Maven_pipeline_CI](https://github.com/RomanSpichak/practical-2/actions/workflows/main.yml/badge.svg)](https://github.com/RomanSpichak/practical-2/actions/workflows/main.yml)

# 🚀 Practical-2

> A modern Java learning project focused on practical programming skills.

[![Java](https://img.shields.io/badge/Java-100%25-orange?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![JDK](https://img.shields.io/badge/JDK-17+-blue?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![GitHub](https://img.shields.io/badge/GitHub-RomanSpichak-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/RomanSpichak)

## 📖 Description

**Practical-2** demonstrates problem-solving using Java. The project is suitable for learning:

- 🧩 Basic Java syntax
- 🎯 Object-oriented programming
- 🖥️ Console application structure
- 🛠️ Building and running Java projects

## ✨ Technology Stack

```mermaid
mindmap
  root((Practical-2))
    Java
      JDK 17+
      Object-Oriented Programming
      Console Applications
    Tools
      Git
      Java IDE
      Command Line
```

## 🧭 Application Flow

```mermaid
flowchart LR
    A[📂 Clone Repository] --> B[☕ Install JDK]
    B --> C[🔨 Compile Sources]
    C --> D[▶️ Run Application]
    D --> E[✅ View Output]

    style A fill:#7C3AED,stroke:#5B21B6,color:#FFFFFF
    style B fill:#2563EB,stroke:#1D4ED8,color:#FFFFFF
    style C fill:#0891B2,stroke:#0E7490,color:#FFFFFF
    style D fill:#059669,stroke:#047857,color:#FFFFFF
    style E fill:#16A34A,stroke:#15803D,color:#FFFFFF
```

## 🧰 Requirements

| Requirement | Description |
|---|---|
| ☕ JDK | Version 17 or later |
| 💻 IDE / Terminal | IntelliJ IDEA, Eclipse, VS Code, or terminal |
| 🐙 Git | Required to clone the repository |

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/RomanSpichak/practical-2.git
cd practical-2
```

### 2. Compile the source files

```bash
javac -d out $(find . -name "*.java")
```

### 3. Run the application

```bash
java -cp out Main
```

> ⚠️ The class name may differ depending on the project structure.

## 📁 Project Structure

```text
practical-2/
├── src/            # Java source code
├── README.md       # Project documentation
└── ...             # Additional project files
```

## 🔧 Development

After modifying the source code, rebuild the project:

```bash
javac -d out $(find src -name "*.java")
```

## 👤 Author

**RomanSpichak**

- 🐙 GitHub: [@RomanSpichak](https://github.com/RomanSpichak)
- 📦 Repository: [practical-2](https://github.com/RomanSpichak/practical-2)

## 📄 License

No license has been specified.