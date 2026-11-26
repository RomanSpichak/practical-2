# Practical-2
[![my_Java_Maven_pipeline_CI](https://github.com/RomanSpichak/practical-2/actions/workflows/main.yml/badge.svg)](https://github.com/RomanSpichak/practical-2/actions/workflows/main.yml)
A modern Java learning project.

## Description

Practical Work No. 2 demonstrates problem-solving using the Java programming language. The project is suitable for learning basic syntax, object-oriented programming, and the structure of small console applications.

## Requirements

- JDK 17 or later
- Any Java IDE or terminal
- Git

## Technologies

- Java — 100%

## Getting Started

Clone the repository:

```bash
git clone https://github.com/RomanSpichak/practical-2.git
cd practical-2
```

Compile the source files:

```bash
javac -d out $(find . -name "*.java")
```

Run the application:

```bash
java -cp out Main
```

> The class name may differ depending on the project structure.

## Project Structure

```text
practical-2/
├── src/            # Java source code
├── README.md       # Project documentation
└── ...             # Additional files
```

## Development

After modifying the source code, rebuild the project:

```bash
javac -d out $(find src -name "*.java")
```

## Author

**RomanSpichak**

- GitHub: [@RomanSpichak](https://github.com/RomanSpichak)
- Repository: [practical-2](https://github.com/RomanSpichak/practical-2)

## License

No license has been specified.
