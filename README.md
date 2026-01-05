🔷Project Overview:
This is a Core Java–based Insurance Management application built to practice OOP principles, collections, streams, exception handling, logging, and clean layered design, similar to how a real backend service works.

🔷 What We Built
We built an Insurance system that manages different types of policies:
Health Policy
Life Policy
Auto Policy
The system allows:
Creating policies
Storing them in memory
Fetching policies by number
Filtering policies based on premium
Handling errors properly
Logging important operations

Packages & Their Purpose

1️⃣ model package
What it contains
Policy (abstract class)
HealthPolicy, LifePolicy, AutoPolicy
PolicyType enum
Why we used it
To represent business objects
To apply Inheritance & Polymorphism
How it works
Policy defines common fields and abstract method calculatePremium()
Each concrete policy overrides calculatePremium() differently
👉 This gives runtime polymorphism

2️⃣ repository package
What it contains
PolicyRepository
Why we used it
To separate data storage logic
Mimics how a database layer works
How it works
Uses List<Policy> internally
Provides methods like:
addPolicy()
getAllPolicies()
getPolicyByNumber()
This is in-memory storage, but the structure is same as real DB repositories.

3️⃣ service package
What it contains
PolicyService
Why we used it
To keep business logic separate
Follows Service Layer pattern
How it works
Calls repository methods
Applies validations
Uses Streams & Lambdas for filtering
Throws custom exceptions when needed
Example:
Fetch policy by number
If not found → throw PolicyNotFoundException

4️⃣ exception package
What it contains
PolicyNotFoundException
Why we used it
To avoid returning null
To handle errors clearly and safely
How it works
Extends RuntimeException
Thrown when policy is not found
Prevents NullPointerException
Makes code fail-fast and clean

5️⃣ app package
What it contains
InsuranceApplication (main class)
Why we used it
Entry point of the application
Used for testing and running the flow
How it works
Creates policies
Calls service methods
Prints results
Helps validate the full flow end-to-end

🔷 Java Concepts Used (Important)
✅ OOP
Abstraction → abstract Policy class
Inheritance → HealthPolicy extends Policy
Polymorphism → overridden calculatePremium()
Encapsulation → protected fields + getters
✅ Collections
List<Policy> for storing policies
Chosen because:
Order matters
Duplicate entries allowed (realistic scenario)
✅ Java 8 Streams & Lambda
Used for:
Filtering high-premium policies
Writing clean, readable code
Example concept:
policies.stream()
        .filter(p -> p.calculatePremium() > amount)
        .collect(Collectors.toList());
✅ Exception Handling
Custom exception instead of returning null
Prevents runtime crashes
Improves reliability
✅ Logging
Used logging instead of System.out.println
Logs:
Method calls
Important actions

🔷 Design Principles Followed
Separation of Concerns
Single Responsibility Principle
Layered Architecture
Fail-Fast Approach
Clean Code


Short Summary:
built a Core Java insurance application using layered design.
I used abstract classes and polymorphism to model different policy types, stored data using collections, applied Java 8 streams for filtering, handled errors with custom exceptions instead of nulls, 
and added logging for traceability.
The project follows real backend patterns like service and repository layers.
