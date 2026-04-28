#  Quantity Measurement Application 

##  Overview

The **Quantity Measurement Application** started as a simple “Feet Measurement Equality” problem and has evolved into a **full-fledged Spring Boot REST API**.

This application supports:

* Comparing quantities
* Adding and subtracting measurements
* Converting units
* Persisting results in a MySQL database

It follows a **clean N-Tier Architecture** and uses **Spring Boot + Spring Data JPA** for enterprise-level backend development.

---

##  Features

*  Compare quantities (e.g., 12 inches = 1 foot)
*  Add & subtract measurements
*  Convert between units
*  Supports multiple measurement types:

    * Length
    * Weight
    * Volume
    * Temperature
*  REST APIs with JSON request/response
*  MySQL database integration
*  Spring Data JPA (no JDBC)
*  Global Exception Handling

---

## ️ Architecture

The project follows **N-Tier Architecture**:

```
Controller → Service → Repository → Database
```

### Layers:

* **Controller** → Handles REST API requests
* **Service** → Business logic
* **Repository** → Data persistence (JPA)
* **Entity** → Database mapping
* **DTO** → Data transfer between layers

---

##  Tech Stack

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Maven
* JUnit (for testing)

---

## Use Case Descriptions (UC1 – UC17)

# 🔹 UC1 – Feet Equality Check

* Created basic Quantity class
* Implemented:

    * Equality check for same unit (Feet)
* Focus:

    * Object comparison

---

# 🔹 UC2 – Inches Equality Check

* Added support for Inches unit
* Implemented:

    * Equality check for Inches
* Focus:

    * Multi-unit comparison

---

# 🔹 UC3 – Feet and Inches Comparison

* Implemented:

    * Comparison between Feet and Inches
* Logic:

    * 1 Feet = 12 Inches
* Focus:

    * Unit conversion for equality

---

# 🔹 UC4 – Unit Conversion for Equality

* Improved comparison logic
* Implemented:

    * Convert all values to base unit before comparing
* Focus:

    * Accuracy in calculations

---

# 🔹 UC5 – Static Conversion Method

* Introduced:

    * Static methods for conversion
* Benefit:

    * Reusable conversion logic

---

# 🔹 UC6 – Addition of Measurements

* Implemented:

    * add(q1, q2)
* Logic:

    * Convert → Add → Return result
* Focus:

    * Arithmetic operations

---

# 🔹 UC7 – Addition with Target Unit

* Enhanced addition feature
* Implemented:

    * Return result in desired unit
* Focus:

    * Flexible output

---

# 🔹 UC8 – Subtraction of Measurements

* Implemented:

    * subtract(q1, q2)
* Logic:

    * Convert → Subtract → Convert back

---

# 🔹 UC9 – Multiple Measurement Types

* Added support for:

    * Length
    * Weight
    * Volume
* Focus:

    * Scalability

---

# 🔹 UC10 – Temperature Handling

* Added:

    * Celsius, Fahrenheit, Kelvin
* Restriction:

    * No addition/subtraction allowed
* Focus:

    * Special case handling

---

# 🔹 UC11 – Interface Implementation

* Created:

    * IMeasurable interface
* Used for:

    * Common behavior across units

---

# 🔹 UC12 – Enum-Based Units

* Implemented:

    * Enums for all units
* Benefit:

    * Cleaner and safer code

---

# 🔹 UC13 – Generic Quantity Model

* Created:

    * QuantityModel<T>
* Feature:

    * Generic handling of units

---

# 🔹 UC14 – Validation & Exception Handling

* Added:

    * Custom exceptions
* Handles:

    * Invalid unit
    * Invalid operations

---

# 🔹 UC15 – N-Tier Architecture

* Structured project into:

    * Controller
    * Service
    * Repository
* Benefit:

    * Clean architecture

---

# 🔹 UC16 – Database Integration (JDBC)

* Connected to:

    * MySQL database
* Implemented:

    * Save measurement results
* Table:

    * measurement

---

# 🔹 UC17 – Spring Boot REST API

* Converted project into:

    * Spring Boot application
* Implemented:

    * REST Controllers (@RestController)
    * API Endpoints (/add, /subtract, /convert, /compare)
* Integrated:

    * Spring Data JPA
    * MySQL Database
* Added:

    * Global Exception Handling
* Result:

    * Fully working REST API with JSON requests


---

##  API Endpoints

### 🔹 1. Add Quantities

**POST** `/quantity/add`

```json
{
  "q1": {
    "value": 1,
    "unit": "FEET",
    "measurementType": "Length"
  },
  "q2": {
    "value": 12,
    "unit": "INCHES",
    "measurementType": "Length"
  }
}
```

✅ Response:

```json
{
  "value": 2.0,
  "unit": "FEET",
  "measurementType": "Length"
}
```

---

### 🔹 2. Subtract Quantities

**POST** `/quantity/subtract`

---

### 🔹 3. Convert Units

**POST** `/quantity/convert`

```json
{
  "quantity": {
    "value": 1,
    "unit": "FEET",
    "measurementType": "Length"
  },
  "targetUnit": "INCHES"
}
```

---

### 🔹 4. Compare Quantities

**POST** `/quantity/compare`

```json
{
  "q1": { "value": 2, "unit": "FEET", "measurementType": "Length" },
  "q2": { "value": 24, "unit": "INCHES", "measurementType": "Length" }
}
```

✅ Response:

```
true
```

---

##  Conclusion

This project demonstrates the transformation from a simple unit comparison problem into a **production-ready backend system** using modern Java and Spring technologies.

---

