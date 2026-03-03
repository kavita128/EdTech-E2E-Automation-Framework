EdTech E2E Automation Framework
📌 Project Overview

This project is a complete End-to-End Automation Testing Framework built using Selenium, Java, and TestNG.

It automates a real-world EdTech user journey:
👉 Registration → Login → Course Selection → Add to Learning Cart → Enrollment → Checkout

The framework follows the Page Object Model (POM) design pattern for scalability and maintainability.

🎯 Key Features

✅ End-to-End Automation Flow (Registration to Enrollment)

✅ Page Object Model (POM)

✅ Selenium WebDriver with Java

✅ TestNG Assertions

✅ Dynamic User Data (Unique Email)

✅ Explicit Wait Handling

✅ JavaScript Executor fallback

✅ Defect Handling without stopping execution

✅ Reusable Utility Classes

🧪 Test Scenarios Covered
📝 Registration Module

Register new learner with dynamic email

Validate successful account creation

🔐 Login Module

Login with valid credentials

Assert using "My Account" / Dashboard

📚 Course Module

Navigate to course categories

Select course (Claw Hammer → treated as Course)

Validate course listing page

🛒 Learning Cart Module

Add course to cart

Capture:

Quantity

Course Price

Line Price

Total Price

Validations:

❌ Line price mismatch (Defect detected)

✅ Total price correct

🎓 Enrollment Module

Proceed to checkout (Course Enrollment)

🐞 Defect Handling

Handles popup: "Oops! Something went wrong"

Detects incorrect course line price calculation

Continues execution even when defect appears

🏗️ Framework Structure
📦 EdTech-E2E-Automation-Framework
 ┣ 📂 objectRepoClasses   → POM Classes
 ┣ 📂 FrontEndAutomation  → Test Scripts
 ┣ 📂 GenericLibraries    → Utilities
 ┣ 📂 test-output         → Reports
 ┣ 📜 pom.xml
 ┗ 📜 README.md
🛠️ Tech Stack

Language: Java

Automation Tool: Selenium WebDriver

Framework: TestNG

Design Pattern: POM

Build Tool: Maven

▶️ How to Run
git clone https://github.com/your-username/EdTech-E2E-Automation-Framework.git

Run TestNG class from IDE

📊 Validations Implemented

✔ Registration success

✔ Login success

✔ Course navigation

❌ Course line price mismatch (BUG)

✔ Total price validation

✔ Enrollment navigation

🔥 Highlights

Real-world EdTech automation scenario

Includes Registration + Login (important for interviews)

Strong assertion strategy

Handles real-time bugs gracefully

Industry-level framework (POM + Utilities)

👩‍💻 Author

Kavita Gaddagi
Automation Testing | Selenium | Java | TestNG

⭐ Future Enhancements

Data-Driven Testing

Extent Reports

CI/CD Integration

API Testing
