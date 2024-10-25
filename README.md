### Lab Work 2: String Processing in Java
Made by Khylia Ivan, IP-22, variant 24

This lab work focuses on advanced string manipulation using `StringBuilder` in Java. 
The lab work is done for Variant № 24.

#### Features
- Sorts words starting with a vowel by the second letter, while preserving the original order for other words and punctuation.
- Validates that the input text contains only English alphabet characters and common punctuation.
- Handles text inputs using `StringBuilder`.

The TextProcessor produces an output text that preserves the original position of words starting with consonants and punctuation, while rearranging only the order of words that start with vowels. The total number of words remains unchanged.

## How to run the project

To run this project, you need to have [Maven](https://maven.apache.org/) installed on your computer. Follow the steps below to get started:

### 1. Clone the repository:

```bash
git clone https://github.com/himen34/Java_Lab_1.git
cd Java_Lab_1
```

### 2. Build the project (this will also run unit tests):

```bash
mvn package
```

### 3. Run the project:

```bash
mvn clean compile exec:java
```

### 4. Run unit tests:

```bash
mvn test
```

## Requirements

- Java 17 or higher
- Maven 3.6.0 or higher
