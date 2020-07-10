package local.kmcgeeka.newrepobank;

import local.kmcgeeka.newrepobank.models.Coin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class NewrepobankApplication
{

    public static void main(String[] args)
    {

        SpringApplication.run(NewrepobankApplication.class, args);
        System.out.println("Piggy Bank");
        List<Coin> bankVault = new ArrayList<>();

        System.out.println(bankVault.toString());
    }

}

 /*

******Explain how you took advantage of Java's Object Oriented approach to solve the sprint challenge.


The four principles of object oriented program are encapsulation, abstraction, inheritance, and polymorphism. I will explain how I saw these
principles working in this project.

1) encapsulation: the state of my Coin model is private and only accessed through getters and setters
2) abstraction: this extends encapsulation. By having methods inside the Coin class it hides internal implementation details.
The repositories for instance accesses these methods to be able to use it. I also think using the CRUD Repository could be an example
of abstraction because we are getting several methods for free (or without having to see all the implementation details) by extending this in our repository.
3) inheritance: By extending the CRUD repository we inherit methods from a parent class. We also have a Coin class from which the repository
uses to connect to Spring.
4) polymorphism: The Coin Repository is an interface and extends the Crud Repository, and we are able to implement methods from the
CRUD repository and implement our own version of these methods.

*******Explain the three steps needed to run a Java application (using the JDK) including what each step does and how those step correlate to running a JavaScript application.
We have to convert source code to byte code so we can execute it using the Java Virtual Machine and we do it in 3 steps in the JDK (Spring
does all 3 steps for us with one menu button).

1) Compile Java.
Go to a command / terminal prompt and change directories to the src directory you created. Run the following commands from the <work dir>/helloapp/src/ directory:

*****!!!!!         javac nameofcreatedfile/*.java

This created a series of *.class files in the hello directory; one *.class file for each *.java file. These *.class files contain the bytecode the will be run on the JVM.

2)   Create a jar file.
*****!!!!!         jar cvfe nameofcreatedfile.jar package.PackageName package/*.class

where cvfe are options meaning

c - create a new archive file with a given name
v - generate verbose output
f - specific the jar output file to be created, in our case nameofcreatedfile.jar
e - sets the main class also called the Entry point, in our case hello.HelloWord


3) execute the program
******!!!!!        java -jar nameofcreatedfile.jar
java launches the JVM
-jar says we are using a *.jar file, the most common type of Java archived file
nameofcreatedfile.jar is the name of application


//*******Explain how Java being a strongly typed language affected you solution.

By being a strongly typed language I had to declare every variable with a data type.
  */


//*******Can you explain the differences between Abstract Classes and Interfaces including how they are used in your application?
//  Main differences:

    //-Classes can inherit from multiple interfaces but only a single abstract class
    //-Abstract classes can contain fields; interfaces should not
    //-Abstract classes can implement methods that get shared across classes; interfaces give method headers but not actual implementations
    //-Java with the Spring Framework uses interfaces much more than abstract classes

//I do not use abstract classes in this application thus far, but I do use an interface. My CoinRepository is an interface and does not
//contain any fields (if it was abstract it could). My CoinRepository extends something called the CRUD Repository which gives a bunch of method headers
//but allows me to implement them which I do in the CoinController.
// */
