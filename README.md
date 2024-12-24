# Digital Document Verifier

## Project Description
The **Digital Document Verifier** is a Java-based application designed to ensure the integrity and authenticity of digital documents. It allows users to generate a unique hash for any file and verify if a file has been altered by comparing its hash with an original hash value.

---

## Features
- **Hash Generation**: Generates a unique SHA-256 hash for any input file.
- **Integrity Verification**: Compares the hash of a file with the provided original hash to detect tampering.
- **Save Hash**: Option to save the generated hash to a file for future reference.
- **Command-Line Interface**: Simple, user-friendly CLI for interaction.

---

## Prerequisites
- **Java Development Kit (JDK)**: Ensure JDK 8 or higher is installed.
- **File Input**: Files for which you want to generate or verify hashes.

---

## How to Run the Project

### 1. Clone or Download the Repository
- Clone the repository or download the `DigitalDocumentVerifier.java` file.

### 2. Compile the Program
Open your terminal or command prompt, navigate to the project directory, and run:
```bash
javac DigitalDocumentVerifier.java
```

### 3. Run the Program
Execute the compiled program using:
```bash
java DigitalDocumentVerifier
```

---

## Functionalities

### 1. Generate Document Hash
- Input: Path to the document (e.g., `C:\Users\Documents\file.txt`).
- Output: The SHA-256 hash of the file.
- Option to save the hash to a file.

### 2. Verify Document Integrity
- Input: Path to the document and the original hash.
- Output: Confirmation if the document matches the original hash or if it has been tampered with.

### 3. Exit
- Ends the program.

---

## Example Usage

### Case 1: Generate Document Hash
```
=====================================
     Digital Document Verifier
=====================================
1. Generate Document Hash
2. Verify Document Integrity
3. Exit
Enter your choice: 1
Enter the path of the document to hash: file.txt
Hash of the document:
e5b9c3c5c89c8f4fcbde8b1c3e3fddcb6f8e6e567b7d7c1eb8efcd6b26e1dcd3
Do you want to save the hash to a file? (yes/no): yes
Enter the output file path: hash.txt
Hash saved to hash.txt
```

### Case 2: Verify Document Integrity
```
=====================================
     Digital Document Verifier
=====================================
1. Generate Document Hash
2. Verify Document Integrity
3. Exit
Enter your choice: 2
Enter the path of the document to verify: file.txt
Enter the original hash: e5b9c3c5c89c8f4fcbde8b1c3e3fddcb6f8e6e567b7d7c1eb8efcd6b26e1dcd3
The document is authentic and has not been altered.
```

---

## Project Structure
```
DigitalDocumentVerifier.java
```
This file contains the source code for the project, including hash generation, file handling, and verification logic.

---

## Code Explanation
- **Hash Generation**:
  Uses the `MessageDigest` class to generate a SHA-256 hash for the file's content.
- **Hash Verification**:
  Compares the current hash of the file with the original hash value.
- **Error Handling**:
  Graceful handling of missing files and invalid inputs.

---

## Enhancements
### Future Improvements
1. **Add Graphical User Interface (GUI):**
   Use JavaFX or Swing for enhanced usability.
2. **Support for Digital Signatures:**
   Add encryption/decryption mechanisms to enable document signing.
3. **Batch Processing:**
   Enable users to verify multiple files at once.
4. **Integration with Cloud Storage:**
   Allow users to verify files stored in cloud platforms like Google Drive or AWS.

---

## License
This project is open-source and available under the MIT License. Feel free to use, modify, and distribute it with appropriate credit.

---

## Contact
For queries or suggestions, please reach out:
- **Name**: Karthik
- **Email**: karthikchilukoti2004@gmail.com

