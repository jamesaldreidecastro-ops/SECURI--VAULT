## SECURI- VAULT: A SECURE CONSOLE PASSWORD BUILDER
**DESCRIPTION / OVERVIEW**



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SecuriVault is a console-based password management system built in Java to demonstrate all four pillars of Object-Oriented Programming: Encapsulation, Inheritance, Abstraction, and Polymorphism. Its purpose is to give users a secure, structured way to generate, store, update, and manage account passwords while showcasing clean OOP architecture. The system solves the common problem of weak or reused passwords by offering customizable password generation rules and a safe vault structure for CRUD operations. With features like intelligent password composition, entry validation, vault security checks, and a user-friendly menu interface, SecuriVault provides both educational value and practical password management functionality.

 **OOP CONCEPT APPLIED**


    This section explains how the four main Object-Oriented Programming (OOP) principles were implemented in the SecuriVault Password Manager System.

 *a. Encapsulation*

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Encapsulation in the SecuriVault system was implemented through the proper use of access modifiers, getters, and setters to protect sensitive data and ensure controlled access to class members. In the VaultEntry class, the accountName and password fields are declared as private, preventing direct external access and manipulation. Public getter methods such as getAccountName() and getPassword() provide read-only access to these fields, while setter methods include validation logic to maintain data integrity. For example, the setPassword() method validates that passwords are at least 5 characters long before allowing the value to be set, throwing an IllegalArgumentException if the validation fails. Similarly, the VaultManager class encapsulates the internal Map<String, VaultEntry> data structure that stores all password entries, exposing only necessary operations through public methods like createEntry(), readEntry(), updateEntry(), and deleteEntry(). This approach ensures that the internal implementation details remain hidden from external classes, and all interactions with the vault data must go through controlled, validated methods. The SecuriVaultSystem class also demonstrates encapsulation by keeping its vaultManager, generator, scanner, and exitFlag fields private, allowing users to interact with the system only through well-defined public methods like start(). This implementation of encapsulation protects the system's data from unauthorized access and modification while maintaining flexibility for future changes to internal implementations without affecting external code.

*b. Inheritance*

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Inheritance in the SecuriVault system establishes an "IS-A" relationship between password generators through a clear class hierarchy that promotes code reuse and specialization. The system features an abstract superclass called AbstractPasswordGenerator that serves as the parent class for three concrete subclasses: ComplexGenerator, LeetSpeakGenerator, and PhraseGenerator. The abstract superclass defines an abstract method generate(int length, int uppercaseCount, int numberCount, int symbolCount) that all subclasses must implement, as well as two protected helper methods—getCharacterPool(String type) and getRandomChar(List<Character> pool)—that provide shared functionality for character pool management and random character selection. Each subclass extends AbstractPasswordGenerator and inherits these helper methods, eliminating code duplication while implementing its own unique password generation algorithm in the overridden generate() method. The ComplexGenerator creates passwords with a balanced random distribution of all character types, the LeetSpeakGenerator converts letters to leet speak symbols (such as 'a' to '@' and 'e' to '3'), and the PhraseGenerator combines random words from a predefined word pool with numbers and symbols to create memorable passphrases. This inheritance structure allows all three generators to share common functionality while specializing in their specific password generation approaches, making it easy to add new generator types in the future by simply creating another subclass that extends AbstractPasswordGenerator and implements the generate() method according to its own algorithm.

*c. Polymorphism*

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Polymorphism in the SecuriVault system is achieved through method overriding and dynamic behavior using superclass references, allowing the system to treat different generator objects uniformly while exhibiting unique behaviors at runtime. Each of the three generator subclasses—ComplexGenerator, LeetSpeakGenerator, and PhraseGenerator—overrides the abstract generate() method from the AbstractPasswordGenerator superclass with its own specific implementation, creating different password generation behaviors from the same method signature. In the SecuriVaultSystem class, the generator is declared using a superclass reference as private AbstractPasswordGenerator generator, which can hold any of the three concrete generator objects through polymorphic assignment. When the user selects a generator in the changeGeneratorFlow() method, the system assigns the appropriate subclass object to the superclass reference (e.g., generator = new LeetSpeakGenerator()), demonstrating polymorphism in action. The key benefit of this polymorphic design becomes evident in the createEntryFlow() method, where the single line String generated = generator.generate(length, upper, num, sym) produces completely different password outputs depending on which generator object is currently assigned, with the actual method implementation determined at runtime rather than compile time. The system also uses runtime type checking with the instanceof operator in the getGeneratorName() method to identify the current generator type and display appropriate information to the user.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; This polymorphic approach provides remarkable flexibility, allowing users to switch between different password generation strategies seamlessly without requiring any changes to the calling code in SecuriVaultSystem, and making it simple to add new generator types in the future without modifying existing functionality.

*d. Abstraction*

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Abstraction in the SecuriVault system is implemented through the AbstractPasswordGenerator abstract class, which defines a common interface for password generation while hiding the complex implementation details from users of the system. The abstract class declares an abstract method generate(int length, int uppercaseCount, int numberCount, int symbolCount) that specifies what all password generators must do—generate a password with specific character requirements—without dictating how they should accomplish this task, leaving the implementation details to the concrete subclasses. This abstract method cannot be instantiated directly, meaning users cannot create an AbstractPasswordGenerator object itself but must instead use one of the concrete subclasses like ComplexGenerator, LeetSpeakGenerator, or PhraseGenerator. The abstract class also provides two concrete helper methods, getCharacterPool(String type) and getRandomChar(List<Character> pool), which are implemented once in the superclass and shared by all subclasses, eliminating code duplication while providing commonly needed functionality. From the perspective of the SecuriVaultSystem class, the abstraction simplifies password generation to a single method call—generator.generate(12, 2, 3, 2)—without requiring knowledge of the underlying algorithms, character pool management, random selection logic, or string building processes that differ between each generator type.

 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The abstract class enforces a contract that all password generators must follow by requiring them to implement the generate() method, ensuring consistency and predictability across all generator types while allowing complete freedom in how each generator achieves its results. This abstraction layer provides a clean separation between the interface (what operations are available) and the implementation (how those operations work), allowing the SecuriVaultSystem to work with any password generator through a uniform interface, significantly simplifying the overall system design and making future modifications and extensions much easier to implement.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The SecuriVault Password Manager System successfully demonstrates the practical application of the four fundamental Object-Oriented Programming principles in creating a functional and maintainable software solution. The integration of these OOP principles results in a robust, scalable, and maintainable system. Future enhancements, such as adding new password generators or security features, can be implemented with minimal code changes, demonstrating the true power of object-oriented design. The SecuriVault system proves that proper application of OOP principles leads to software that is not only functional but also prepared for evolution and future requirements. This project reinforces the importance of object-oriented programming in modern software development and its effectiveness in solving real-world problems in password management and security.

 **PROGRAM STRUCTURE**

    Program Structure - description of the main class and their roles. A text-based class diagram or list of relationships may be included.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SecuriVault was developed under the strict rules of Object-Oriented Programming, with each class doing one highly focused job. The SecuriVaultSystem class is the console controller, which handles input from the user, displays the menu, and controls the flow of the program. It thus shows polymorphism through its dependency on the abstract type AbstractPasswordGenerator, making it work with additional implementations of password generators without changing the core logic of the module.

All password data is stored by the VaultManager class. Its main data member is a HashMap which contains multiple VaultEntry objects. It implements the basic four CRUD functionality: creating and updating entries, viewing the stored accounts and deleting existing entries. Each account record is an instance of the class VaultEntry, and the data is kept private using encapsulation principles, with an account name and password access-controlled by accessors and mutators, so values can only be retrieved or set.

ComplexGenerator, LeetSpeakGenerator, and PhraseGenerator are other classes for generating passwords. These classes (and others) extend from the same base class AbstractPasswordGenerator so that they share functionality through providing unique implementations of the password generation algorithm. This hierarchy cleanly shows the inheritance, abstraction, encapsulation, and polymorphism throughout the entire system.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The ComplexGenerator, LeetSpeakGenerator, and PhraseGenerator classes each inherit from the abstract base class AbstractPasswordGenerator, establishing an inheritance relationship that allows them to implement their own versions of the password generation method. The VaultEntry class encapsulates sensitive fields such as accountName and password, ensuring data hiding and validation through private access modifiers and controlled getters and setters. VaultManager manages a collection of VaultEntry objects, maintaining a one-to-many relationship using a Map to organize and provide controlled access to these entries. The SecuriVaultSystem class leverages polymorphism by using the AbstractPasswordGenerator type dynamically, allowing it to interact interchangeably with any of the concrete generator subclasses, such as ComplexGenerator, LeetSpeakGenerator, or PhraseGenerator, providing flexibility in password generation strategies within the system.




**A text-based Diagram**

<img width="696" height="751" alt="Image" src="https://github.com/user-attachments/assets/1612596b-1440-4479-a4db-91b264bf8eaa" />





       


*Legend:
uses        = one class calls another

contains    = composition (class owns/holds the other)

inherits    = child extends parent (OOP inheritance)

abstract    = class cannot be instantiated


 **HOW TO RUN THE PROGRAM**

     provide a step-by-step instruction on how to compile and run the program using the command line.


**Step 1:** Download Source Files
Ensure all Java files are in the same directory:

SecuriVaultSystem.java

VaultEntry.java

VaultManager.java

AbstractPasswordGenerator.java

ComplexGenerator.java

**Step 2:** Compile the Application
Open your terminal/command prompt and navigate to the source directory. Compile all Java files using:

javac *.java
This command will generate corresponding .class files for each Java source file.

**Step 3:** Launch the Application
Execute the main class to start the password management system:

java SecuriVaultSystem

Expected Output
Upon successful execution, you should see:


=== SecuriVault Password Management System ===

--- Main Menu ---
1. Create Entry
2. View Entries
3. Update Entry
4. Delete Entry
5. Exit
Choice:


 **SAMPLE OUTPUT**

    show what the program looks like when it runs. A short code block or screenshot may be included.

<img width="587" height="267" alt="Image" src="https://github.com/user-attachments/assets/c9c76adc-4433-4f23-820c-f1767b1b0173" />
<img width="581" height="381" alt="Image" src="https://github.com/user-attachments/assets/976e0f00-fabe-4968-b804-a44711e1ec68" />
<img width="589" height="466" alt="Image" src="https://github.com/user-attachments/assets/1cf95793-7844-4e2e-bca5-0de4a2c0dd1b" />
<img width="578" height="288" alt="Image" src="https://github.com/user-attachments/assets/9b784425-1564-4190-8f2b-c853d35dc50a" />
<img width="460" height="177" alt="Image" src="https://github.com/user-attachments/assets/d9297253-dce1-46c9-a65d-4d4b5307ffc0" />
<img width="584" height="280" alt="Image" src="https://github.com/user-attachments/assets/e3ad1cc4-3998-4d24-a5c5-fb4fdf4c43f2" />
<img width="582" height="213" alt="Image" src="https://github.com/user-attachments/assets/1bd0172f-ec81-4208-8f35-1c197c275382" />
    
## Acknowledgements

ACKNOWLEDGEMENT

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;We would like to express our deepest gratitude to our professor, Mr. Jayson Abretique, for his patient guidance and unwavering support throughout this project. His expertise, insightful feedback, and continuous encouragement have been crucial in shaping our work and leading it to successful completion. We sincerely appreciate the time and effort he dedicated to mentoring us and helping us overcome challenges along the way.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Our heartfelt thanks also go to our colleagues, whose significant help and collaborative spirit greatly contributed to the success of this project. Their willingness to share knowledge, engage in constructive discussions, and work together as a team made the entire project process valuable. We are grateful for their inspiration and friendship that uplifted our collective progress.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Additionally, we are deeply grateful to our families for their constant emotional support and motivation. Their understanding and unwavering encouragement have provided us with strength and resilience to maintain our focus on achieving our goals. Their presence has been an essential source of comfort throughout this journey.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Finally, words cannot express our gratitude to God for the strength, blessings, and courage throughout this journey.  It is through His grace that we have been sustained at every step, allowing us to overcome the challenges of this project with determination and hope.

 
## REFERENCE
