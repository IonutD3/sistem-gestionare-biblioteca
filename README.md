# 📚 Sistem de gestionare a bibliotecii

## 🇷🇴 Română

## Despre proiect

Aplicație Java pentru gestionarea unei biblioteci, realizată cu scopul de a exersa concepte fundamentale de programare orientată pe obiecte, colecții, gestionarea datelor și lucrul cu fișiere.

Proiectul permite administrarea cărților și membrilor, gestionarea împrumuturilor și returnărilor, căutarea cărților și exportarea catalogului în format CSV.

---

## 📝 Descriere

Aplicația simulează funcționarea de bază a unei biblioteci.

Utilizatorul poate:

- adăuga cărți în catalog;
- adăuga membri ai bibliotecii;
- împrumuta cărți;
- returna cărți;
- verifica disponibilitatea cărților;
- căuta cărți după titlu;
- căuta cărți după autor;
- afișa toate cărțile din catalog;
- afișa împrumuturile active;
- exporta catalogul într-un fișier CSV.

Proiectul este realizat în **Java** și folosește o structură simplă, modulară și ușor de extins.

---

## 🎯 Scopul proiectului

Scopul proiectului este de a demonstra utilizarea unor concepte importante din Java:

- programare orientată pe obiecte;
- clase și obiecte;
- încapsulare;
- constructori;
- metode și atribute;
- colecții (`List`, `Map`);
- `ArrayList` și `LinkedHashMap`;
- parcurgerea colecțiilor;
- gestionarea excepțiilor;
- lucrul cu fișiere;
- exportul datelor în format CSV;
- utilizarea JavaDoc pentru documentarea codului.

---

## ⚙️ Funcționalități

### 📖 Gestionarea cărților

Fiecare carte conține:

- ID;
- titlu;
- autor;
- disponibilitate.

O carte poate avea două stări:

```text
Disponibila
Imprumutata
```

---

### 👤 Gestionarea membrilor

Fiecare membru are:

- ID;
- nume.

Membrii pot împrumuta cărți disponibile din catalog.

---

### 🔄 Gestionarea împrumuturilor

Aplicația permite:

- împrumutarea unei cărți;
- verificarea existenței cărții;
- verificarea existenței membrului;
- verificarea disponibilității cărții;
- returnarea cărții;
- eliminarea împrumutului activ după returnare.

O carte care este deja împrumutată nu poate fi împrumutată din nou până când nu este returnată.

---

### 🔎 Căutarea cărților

Cărțile pot fi căutate după:

- titlu;
- autor.

Căutarea nu ține cont de diferența dintre litere mari și mici.

Exemplu:

```text
Cautare titlu "Java"
```

poate returna:

```text
Java Programming
Effective Java
```

---

### 📋 Afișarea datelor

Aplicația poate afișa:

- toate cărțile din bibliotecă;
- starea fiecărei cărți;
- toate împrumuturile active;
- membrul care a împrumutat fiecare carte.

---

### 📄 Export CSV

Catalogul bibliotecii poate fi exportat într-un fișier:

```text
carti.csv
```

Fișierul conține următoarele coloane:

```text
id,titlu,autor,disponibila
```

Fișierul CSV este generat local la rularea programului.

---

## 🗂️ Structura proiectului

```text
sistem-gestionare-biblioteca/
│
├── README.md
│
└── src/
    └── biblioteca/
        ├── Main.java
        ├── Carte.java
        ├── Membru.java
        ├── Imprumut.java
        └── ServiciuBiblioteca.java
```

### Rolul claselor

| Clasă | Responsabilitate |
|---|---|
| `Main` | Punctul de pornire al aplicației și demonstrarea funcționalităților |
| `Carte` | Reprezintă o carte din bibliotecă |
| `Membru` | Reprezintă un membru al bibliotecii |
| `Imprumut` | Reprezintă legătura dintre o carte și membrul care a împrumutat-o |
| `ServiciuBiblioteca` | Gestionează cărțile, membrii și împrumuturile |

---

## 🧩 Organizarea codului

Aplicația este împărțită în mai multe componente pentru a separa responsabilitățile.

### `Carte`

Gestionează informațiile despre o carte:

```text
ID
Titlu
Autor
Disponibilitate
```

### `Membru`

Gestionează informațiile despre un membru:

```text
ID
Nume
```

### `Imprumut`

Face legătura dintre:

```text
Carte → Membru
```

și reprezintă un împrumut activ.

### `ServiciuBiblioteca`

Reprezintă componenta principală de gestionare a bibliotecii și conține operații precum:

```text
adaugaCarte()
adaugaMembru()
imprumutaCarte()
returneazaCarte()
cautaDupaTitlu()
cautaDupaAutor()
afiseazaCarti()
afiseazaImprumuturi()
salveazaCartiInCsv()
```

---

## ▶️ Rulare

### Varianta 1 — rulare locală

Proiectul poate fi deschis într-un IDE Java precum:

- IntelliJ IDEA
- Eclipse
- Visual Studio Code
- NetBeans

După compilare, aplicația se pornește din:

```java
Main.java
```

---

### Varianta 2 — verificare într-un compilator Java online

Pentru verificarea rapidă a proiectului într-un compilator Java online, toate clasele pot fi reunite temporar într-un singur fișier:

```text
Main.java
```

Structura va fi:

```text
Main
├── Carte
├── Membru
├── Imprumut
└── ServiciuBiblioteca
```

Această variantă este utilă pentru testarea rapidă a codului fără configurarea unui proiect Java complet.

---

## 💻 Exemplu de utilizare

La pornirea aplicației sunt adăugate câteva cărți:

```text
Java Programming
Clean Code
Effective Java
```

și doi membri:

```text
Ion Popescu
Maria Ionescu
```

Programul realizează apoi operații precum:

```text
=== CARTI ===
1 | Java Programming | James Gosling | Disponibila
2 | Clean Code | Robert C. Martin | Disponibila
3 | Effective Java | Joshua Bloch | Disponibila
```

După efectuarea unor împrumuturi:

```text
=== IMPRUMUTURI ===
"Java Programming" -> Ion Popescu
"Clean Code" -> Maria Ionescu
```

Programul permite ulterior returnarea cărții și actualizează automat disponibilitatea acesteia.

---

## 🛠️ Tehnologii utilizate

- **Java**
- **Java Collections Framework**
- **FileWriter**
- **CSV**
- **JavaDoc**
- **Programare orientată pe obiecte (OOP)**

Nu sunt necesare biblioteci externe pentru rularea aplicației.

---

## 📌 Concepte Java demonstrate

Prin acest proiect sunt demonstrate următoarele concepte:

- clase și obiecte;
- modificatori de acces;
- încapsulare;
- `private`;
- `final`;
- constructori;
- metode;
- suprascrierea metodei `toString()`;
- colecții;
- `ArrayList`;
- `LinkedHashMap`;
- `Map`;
- `List`;
- bucle `for`;
- condiții;
- tratarea excepțiilor cu `try-catch`;
- `try-with-resources`;
- citirea și scrierea fișierelor;
- format CSV;
- JavaDoc.

---

## 📈 Obiectiv profesional

Proiectul este realizat ca exercițiu practic pentru consolidarea cunoștințelor de **Java și programare orientată pe obiecte**.

Structura modulară permite extinderea aplicației și adăugarea ulterioară a unor componente precum baze de date, interfață grafică sau API REST.

--- 

# 📚 Library Management System

## 🇬🇧 English

## About the project

A Java application for managing a library, developed to practice fundamental concepts of object-oriented programming, collections, data management, and file handling.

The application allows users to manage books and library members, handle book loans and returns, search for books, and export the library catalog to a CSV file.

---

## 📝 Description

The application simulates the basic operations of a library.

It allows users to:

- add books to the catalog;
- add library members;
- borrow books;
- return books;
- check book availability;
- search books by title;
- search books by author;
- display all books;
- display active loans;
- export the catalog to CSV.

The project is written in **Java** and follows a simple, modular, and extensible structure.

---

## 🎯 Project Goals

The project demonstrates several important Java concepts:

- object-oriented programming;
- classes and objects;
- encapsulation;
- constructors;
- methods and fields;
- collections;
- `List` and `Map`;
- `ArrayList` and `LinkedHashMap`;
- collection iteration;
- exception handling;
- file handling;
- CSV export;
- JavaDoc documentation.

---

## ⚙️ Features

### 📖 Book Management

Each book contains:

- ID;
- title;
- author;
- availability status.

A book can have two states:

```text
Available
Borrowed
```

### 👤 Member Management

Each library member has:

- ID;
- name.

Members can borrow available books.

### 🔄 Loan Management

The application supports:

- borrowing books;
- checking whether a book exists;
- checking whether a member exists;
- checking book availability;
- returning books;
- removing active loans after a book is returned.

A borrowed book cannot be borrowed again until it is returned.

### 🔎 Book Search

Books can be searched by:

- title;
- author.

Searches are case-insensitive.

### 📄 CSV Export

The library catalog can be exported to:

```text
carti.csv
```

The generated CSV contains:

```text
id,titlu,autor,disponibila
```

The CSV file is generated locally at runtime.

---

## 🗂️ Project Structure

```text
sistem-gestionare-biblioteca/
│
├── README.md
│
└── src/
    └── biblioteca/
        ├── Main.java
        ├── Carte.java
        ├── Membru.java
        ├── Imprumut.java
        └── ServiciuBiblioteca.java
```

### Class Responsibilities

| Class | Responsibility |
|---|---|
| `Main` | Application entry point and demonstration of the features |
| `Carte` | Represents a library book |
| `Membru` | Represents a library member |
| `Imprumut` | Represents an active book loan |
| `ServiciuBiblioteca` | Manages books, members, and loans |

---

## ▶️ Running the Project

### Local execution

The project can be opened in a Java IDE such as:

- IntelliJ IDEA
- Eclipse
- Visual Studio Code
- NetBeans

The application starts from:

```java
Main.java
```

### Online Java compiler

For quick online testing, all classes can temporarily be placed inside a single:

```text
Main.java
```

This makes the project easier to test without configuring a complete Java project.

---

## 🛠️ Technologies

- **Java**
- **Java Collections Framework**
- **FileWriter**
- **CSV**
- **JavaDoc**
- **Object-Oriented Programming**

No external libraries are required.

---

## 📈 Professional Objective

This project was developed as a practical exercise for strengthening **Java and object-oriented programming skills**.

The modular structure makes it possible to extend the application later with database integration, a graphical interface, or a REST API.

---

## 👤 Autor / Author

**IonutD**
