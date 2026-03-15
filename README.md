# Smart Pet Care Management System

> A Java console application built with core Object-Oriented Programming principles.

![Java](https://img.shields.io/badge/Java-11%2B-orange?style=flat-square&logo=java)
![OOP](https://img.shields.io/badge/Paradigm-OOP-blue?style=flat-square)
![CLI](https://img.shields.io/badge/Interface-CLI-green?style=flat-square)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen?style=flat-square)

---

## Overview

Smart Pet Care Management System is a Java console application that allows a veterinary clinic to manage pet owners, pets (dogs and cats), veterinarians, services, and appointments — all from a simple terminal menu.

---

## Features

- Add and manage **pet owners** with email contact info
- Register **Dogs and Cats** with breed and age details
- **Book appointments** linking owner, pet, vet, and service
- View appointments with a **formatted receipt** printout
- Demonstrate **polymorphism** via Pet Sounds (`makeSound()`)
- **Auto-generated IDs** for all entities using `AtomicInteger`
-  In-memory database with CRUD-like helper methods

---

## Project Structure

```
src/
├── app/
│   └── Main.java                  # Entry point, menu loop, user interaction
├── db/
│   └── Database.java              # In-memory storage and lookup
├── model/
│   ├── Pet.java                   # Abstract base class
│   ├── Dog.java                   # Extends Pet
│   ├── Cat.java                   # Extends Pet
│   ├── Owner.java                 # Pet owner
│   ├── Veterinarian.java          # Vet details
│   ├── Appointment.java           # Core transaction object
│   ├── Service.java               # Clinic service/pricing
│   └── MedicalRecord.java         # Attached to each pet
├── services/
│   ├── AppointmentService.java    # Booking business logic
│   └── PetService.java            # Pet filtering logic
└── utils/
    └── IdGenerator.java           # Unique ID generator
```

---

## OOP Concepts Demonstrated

| Concept | How It's Applied |
|---|---|
| **Inheritance** | `Dog` and `Cat` extend abstract `Pet` class |
| **Polymorphism** | `makeSound()` overridden in `Dog` (Woof!) and `Cat` (Meow!) |
| **Encapsulation** | All fields are `private` with getters/setters; defensive copies in `Database` |
| **Abstraction** | `Pet` declares abstract `makeSound()`; service layer hides booking logic |

---

## Class Overview

### Model Classes

| Class | Key Fields | Notes |
|---|---|---|
| `Pet` *(abstract)* | `id, name, age, weight, medicalRecord` | Base class; abstract `makeSound()` |
| `Dog` | `breed` + Pet fields | Extends Pet — *Woof!* |
| `Cat` | `breed` + Pet fields | Extends Pet — *Meow!* |
| `Owner` | `id, name, email, List<Pet>` | Can own multiple pets |
| `Veterinarian` | `id, name, specialty` | Linked to appointments |
| `Service` | `id, description, baseCost` | Defines clinic offerings |
| `Appointment` | `id, pet, owner, vet, service, dateTime, status` | `calculateTotalCost()` included |
| `MedicalRecord` | `List<String> entries` | Attached to each `Pet` |

### Service Classes

| Class | Key Methods | Notes |
|---|---|---|
| `AppointmentService` | `bookAppointment()`, `getAll()`, `findBy()`, `findScheduled()` | Uses `Predicate<T>` lambda for filtering |
| `PetService` | `findDogsByBreed()`, `printPetNames()` | Stream API + wildcard generics |

---

## How to Run

### Prerequisites
- Java **11 or higher**
- A Java IDE (NetBeans, IntelliJ IDEA, Eclipse) or command-line compiler

### Compile & Run (Command Line)

```bash
# From the project root directory
javac -d out src/app/*.java src/db/*.java src/model/*.java src/services/*.java src/utils/*.java
java -cp out app.Main
```

### Run via IDE
1. Open the project in your IDE
2. Set `Main.java` as the run configuration
3. Click **Run**

---

## Application Menu

On launch, the app seeds one default **owner** (Alice), **vet** (Dr. Lee), and **service** (General Checkup).

```
==============================================
      SMART PET CARE MANAGEMENT SYSTEM
==============================================
1. Add Owner
2. Add Pet
3. Make Appointment
4. List Appointments
5. Pet Sounds
6. Exit System
----------------------------------------------
Enter your choice:
```

---

## ID Generation

All entities get unique IDs via `IdGenerator.generateId(prefix)`. A shared `AtomicInteger` increments globally across all entity types.

| Prefix | Example | Entity |
|---|---|---|
| `O` | `O-1` | Owner |
| `V` | `V-2` | Veterinarian |
| `S` | `S-3` | Service |
| `P` | `P-4` | Pet (Dog / Cat) |
| `A` | `A-5` | Appointment |

---

## Known Limitations

- Data is **in-memory only** — all records are lost when the app exits
- No input validation beyond basic null checks
- No check that the selected pet belongs to the selected owner
- Minor currency inconsistency: Base Cost shows `RM` but Total shows `$`

---

## Future Improvements

- [ ] File or database persistence (e.g., SQLite / JSON)
- [ ] Appointment cancellation and rescheduling
- [ ] More pet types (Bird, Rabbit, etc.)
- [ ] Input validation and error handling improvements
- [ ] Fix currency symbol consistency

---

## Author

Developed as a Java OOP coursework/demo project. Built with **NetBeans IDE**.
