# Dam-Management (Java)
HydroHub System: AI-powered Water Management

HydroHub System is a Java application prototype that demonstrates an integrated platform for real-time monitoring, AI-driven decision-making, and access control in hydroelectric power stations in a shared river basin.

The solution mimics the collection and processing of data from multiple power stations via a central **AIDecisionEngine** to suggest actions, such as opening or closing downstream flow to optimize water storage and avoid flooding. It also has an **AuthenticationService** by using a **SessionToken** for access control to the basin.

-----
# Features

Integrated Decision Cycle: It emulates an end-to-end process, from real-time data gathering to AI analysis, up to actuation at multiple power stations.
* **AI Decision Making:** Central engine analyzes combined flow/risk, including predictive weather impact to produce a recommendation based on predefined flood risk threshold.

* **Explainable AI**: Provides clear explanations for the recommended action by the AI in question, such as flood mitigation versus optimization of water storage.

* **Role-Based/Contextual Authorization:** This uses a `SessionToken` that contains the `riverBasinId` on it, only allowing users access to data in their corresponding river basin.

* **User Simulation:** A `PowerStationUser` class with rudimentary password verification--serves as a placeholder for strong hashing.

There were three different focus areas for the questions

# Project Structure (Java Classes) 

| **`HydroHubSystem.java`** | **Main Application Entry Point.** | Manages the collection of `PowerStationUser` objects, and orchestrates the `runDecisionCycle`. Two main scenarios are simulated to handle flood risk and optimization respectively.

| **`AIDecisionEngine.java`** | **Core AI/ML Component.** | Inlcudes the logic of the `recommendAction` based on the total flow and weather impact, and also the `generateExplanation` method for XAI. |

| **`PowerStationUser.java`** | **Data Model & User/Station Logic.** | Models user and related power station with necessary authorizing information (`riverBasinId`). Also demonstrates mocking out data lookups & decisions.

| **`AuthenticationService.java`** | **Security & Access Control.** | Simulates a user database providing the method `login` which issues a `SessionToken` upon successful authentication. |

| **`SessionToken.java`** | **Authorization Token.** | Stores the `userId` and the user's `riverBasinId`. Used to check if user `canAccessBasin`.

| `waterLevelSensor.java` | **Placeholder.** | Represents a real-world sensor component that would feed data into the system. |

-----
# Getting Started 

This is a simple Java project, and it can be executed through any standard Java development environment IDE or via the command line.

**Requirements**

Java Development Kit (JDK) 8 or newer.

Run the Application

1. **Compile the Java files:**

  javac *.java

2. **Run the main class:**

  java HydroHubSystem

# Expected Outcome

The HydroHubSystem.main method executes two decision scenarios:

Scenario 1 (High Risk): Demonstrates flood mitigation where the AI recommends OPENING the flow.

Scenario 2 (Low Risk): Demonstrates optimization where the AI recommends CLOSING the flow to maintain water storage.

# Authorization Model

The system employs a simplified basin-level authorization model:

The AuthenticationService issues a SessionToken containing the user's riverBasinId (e.g., "Ganga" or "Narmada").

The SessionToken.canAccessBasin(String targetBasinId) method is used to ensure that a user can only view or manage stations that belong to their assigned river basin.

Users are initialized with their associated river basin ID.

**Output:**

![WhatsApp Image 2025-11-24 at 18 37 07_3ccf3b50](https://github.com/user-attachments/assets/e26a279a-9ab3-46a3-9b38-34769be8891f)

<img width="702" height="300" alt="image" src="https://github.com/user-attachments/assets/af9aaca2-51a8-4bf6-98cb-c5825e1fee4e" />

Github Repo Link: 
Project Report: https://docs.google.com/document/d/1MY5bs8D05L8t5yek_-4ZOXm1qzd4sCcAe1KkGG42jj4/edit?usp=sharing

