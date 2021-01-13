# CoreJava
Programs that covers  various libraries and it's interfaces and implementations like Collection, Multi-Threading,
Design patterns, Serialization, I/O , Lambda Expressions, Functional Interfaces, Java 8's Stream interface etc.

To know java language completely you need to encapsulate :
	1. Java Development Environment
	2. Language constructs and control flow
	3. Classes, inheritance and interfaces
	4. Exceptions and error handling 

	• Java is a combination of both a Programming language {Syntax, Control flow, Data types and Oops concepts} and a runtime environment {Configuration ,Threading, Security, Input/Output} as well, Here Java SE comprises of only the runtime environment which is very basic type of java
	• As a traditional approach, write any java code in a notepad/wordpad and name it as .java file , It needs a host environment to run(windows/linux/android), It needs JDK tools to finally create a java app that is platform independent. This is due to the JRE 
	• Now, platform is combination of processor and OS(operating system). In general i can say the hardware or software component in which programs run.
	• We can run NetBeans(<jdk8) , IntelliJ(Supports Android, JAVA SE) or Eclipse
	• Even though you're a developer, but an end-user, You still need a JRE to run java programs. If you go inside JRE folder/ bin folder you can find java.exe that runs java program directly, If you're using intelliJ ,You can find the compiled class file under out->production->.class files
	• Even without an IDE it is possible to run the java programs, Go to the .class file specified above and type cmd at the top search bar, Inside cmd type java -version and java <ClassName> will execute the output
 outside JRE will compile source code(.java) and converts to byte code, this is done by jdk and path setting.
	• Interpreter converts Bytecode(.class files) into machine language(Assembly), here interpreter is JVM

	• Here there is a clear distinction between compiler and interpreter, In C language, there is a source code and there is no interpreter as it directly becomes binary code(.exe file), This .exe is native code which are specific to platforms 
	• But Intermediate code is ByteCode which are generated after compilation and it requires a VM to execute in a machine ,So that it is not platform specific.
	• We can run NetBeans(<jdk8) , IntelliJ(Supports Android, JAVA SE) or Eclipse
	• Even though you're a developer, but an end-user, You still need a JRE to run java programs. If you go inside JRE folder/ bin folder you can find java.exe that runs java program directly, If you're using intelliJ ,You can find the compiled class file under out->production->.class files
	• Even without an IDE it is possible to run the java programs, Go to the .class file specified above and type cmd at the top search bar, Inside cmd type java -version and java <ClassName> will execute the output

1. Statement Structure

	• Java programs are made of statements, Each statement ends with a ;. Spaces, tab , 0 and new lines simply leaves a white space
	• Always use packages for organizing the folder structure and while running it ,use the fully qualified name to run the programs.

2. Variables/Data types/ Math objects

	• Java provides you the ability to store and manipulate the values using variables ->Named Data storage. In this sense java is a Strongly typed language which means that for instance , dataValue is compatible to store integer values and can assign 200 to it or can do it in a single line
				 int	dataValue;
				dataValue =	200;
				 int dataValue = 	200;
	• When it comes to naming conventions in java, we have a set of rules of following camel case, using _,$ etc ,
	 Local	When it is local to any method and used only within it 
	Global	
	Instance	
	• In Java, Object gets created in Runtime.

2.1.  Primitive DataTypes
	
	• These are the fundamental data types in java and they're built into the language : Integer, float, char, boolean
	• These integers are again classified into byte(8 bits), short(16), int(32) and long(64) the difference is the size of storage they take. Only when using long, you need to use L at the end of values.
	• Floating point is classified as float(32 bits) and double(64 bits). Ends with f and d
	• Char type stores a single Unicode character which is generally represented using '' or \u notation. Boolean types have 2 values 
	• These primitive types store by value so that it has a separate copy of the allocated variables.

2.2. Arithmetic Operations

	• Includes basic operations, along with prefix/postfix and assignment operators. Precedence is given to parenthesis , then to multiplicative and lastly to additive

2.3. Type Conversions

	• Here, Type conversions can be implicit(lower to higher) or can automatically be performed by the compiler and Explicit where you need to perform type casting(higher to lower)

	3. Conditional Logic/Looping/For-Each/Switch and Arrays

	• Conditional statements need relational operators such as >, <, <=, >=, == to compare two integer values or character Unicode.
	• Conditional Assignment operator assign a value to a variable based on result of condition, like for example
	 int a=20; int b=30; int result=a>b ? a:b;, It prints result as 30 as it is false.
	• If-Else and chained If-Else statements need a condition, It compares and prints result accordingly
	• Block Statements are used when you want to group a set of statements under a particular loop.

3.1. Looping

	• We have 3 loops in java, A while loop, Do-while loop and a for loop.
	• The simplest way to write a loop is a while loop , But a for loop is more convenient. 
	• For-Each loop is special. Here it behaves as a normal for loop by accessing each element of the array where we assign a variable to that array name with a colon(:) . Then we can print that variable. 
	• Refer examples in eclipse

3.2. Arrays

	• Ordered collection of elements 
	• We will normally declare as 
		 float[] x = new float[3];
	• Here [] represents an array and you will store x number of values of type float and new will allocate 3 distinct spaces for 3 float values.
	• These arrays are governed by indexes which are ranging from 0 to n-1. Here index is 0->2
	• For example, if I say x[0] = 10.0f; ,it means the space allocated for index[0] is filled with value of 10.0. We can wither assign values in this way or using {10.0 f , .. , ..} then perform operations
	
	4. Complex Types in java

4.1. Class

	• Classes provide a structure and objects are its contents , this provides existence to objects.
	• It encapsulates data, operations , separates "what" from "how" to be done and allows storage & manipulation details to be hidden 
	• Constructor is special method that is called when an object is instantiated
		○  It means that if you use new keyword(To create object & memory) , The constructor will initialize the
		objects/fields of the class
		○   It cannot be abstract, final , static or synchronized 
	• Normally you do Class object = new Class();. But if you get deeper, as soon as you create an object with a class name , only a reference is created and memory is not allocated. If you use new keyword, then it gets allocated to HEAP memory 
		○ An example is like , When you have a student in a class, He simply attended the class , So that he can refer to other people. But when you use a new keyword, then he is allotted a seat in that class and he is free to attend it anytime.
		○ Another example is normal and premium memberships in any account.

4.2. Encapsulation

	• In Java, We use objects and using methods we know what to do with em, But HOW TO DO? Needs encapsulation of it and Access modifiers are used to achieve this.
	• The internal representation of an object is hidden by encapsulation.
	• We have field encapsulation that helps to hide the implementation details , We can use an accessor/mutator pattern to control field access , as you know the getters and to modify the values we use setters.

4.3. Methods

	• Executable code that manipulates the state of an object  and performs the operations , It should be an action or a verb 
	• Should have return type if not void
	• Can have parameters passed as arguments.

4.4. This and Null reference

	• "this" reference will point to the current object , used for reducing ambiguity(duplicates). Pass a reference of an object as parameter. It has the ability to change or mutate the original values that are declared in the fields while defining a variable
		○ An example is , When I use this pointer in a parameterized constructor, and then in main class, I'm instantiating that class and passed some value. When I print the object it will refer to new value
	• "null" is a reference literal and default value for Strings and characters . 

5. Constructors & initializers

	• Fields have default values and its 0 by default for integer types, float, double types, boolean - false 
	• Field initializers 

5.1. Constructors

	• Even if Java doesn't have any explicit constructors , Java provides an implicit constructor if you didn't provide any but if you write a parameterized constructor it replaces the default constructor.
	• The order happens at "field initializer first and then by initialization block and then by a constructor".

Constructors are not inherited 
Super notation with arguments can call the constructor with arguments.
	
String Class
	
	• Stores a sequence of unicode characters using UTF-16 encoding
	• Literals are closed using "", can be concatenated using + , +=
	• String objects are immutable, can't be changed
	• Length() to get length of string, can create new string from existing like concat, replace, toLowercase, toupperCase, split, trim, can format using format(), can extract substrings using charAt , substring and compare strings using compareTo, isEmpty, equals , equalsIgnoreCase, compareToIgnorecase

	1. Lets say you define two strings with same values "I like Java" but with different objects s1 and s2 , Now 
		a. if you use == operator with two objects, It will be false as they are not pointing to same instance, 
		b. but equals() methods compares character values but it is expensive, 
		c. but if you use s1.intern() , and s2.intern to two another different instances and use == , it returns true
	2. We can convert No-string types to strings using String.valueOf method , toString() is used to get string representation of a class 

	StringBuilder Class
	
	• StringBuilder provides mutable String buffer for best performance pre-size buffer.
	• Most common methods are append() to add at end of string and insert() to add within body 

	Primitive Wrapper class
	
	• We can treat primitive types as objects, We can convert it using parse() and Valueof() methods

Error handling

For handling the checked exception or compile time exceptions, we are using Try catch finally block to structurely handle exception. Catch block has the error code catched. Finally block runs after try/catch , it surely runs

Exercise 1 :
Read a notepad file which has numbers and print the sum , throw an exception.  

Solution :
We need to use BufferedReader class from java.io which is used for reading the content , FileReader reads the details of the file which has contents. Create an object of bufferedReader and set as null, then initialize a total variable of type int to 0, now, 
	• create an instance of bufferedReader object with same type and inside the argument, pass the FileReader instance and provide file name.
	• If this is difficult for you, create another object with FileReader type and instantiate it , pass the filename with canonical address as parameter
	• Now, pass that instance object to BufferedReader parameter. 

Initialize string object to null, which is used to read the lines. Now, you can use while loop or for loop, In while loop , the condition must be to check whether the string object reads every line of the text file until it is null. Then the statements should print total with the help of WrapperClass.valueof(string object). Print the total outside loop
