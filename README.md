# Java Design Patterns

 ## Concepts
   - Java is organized in multiple logical layers.
  
     ### Presentation Layer
      - Intercepting Filter
      - Front Controller 
      - MVC
      - Context Object

     ### Business Layer
      - Business Delegate
      - Transer Object
      - Session Face
      - Service Locator

     ### Data Access Layer
      - Data Access Object

     ### Integration Layer
      - Service Activator
      - Web Service Broker

 ## Singleton
  - Object **creation pattern** of one, and only one instance of a class.
  - E.g. Logger, Data Source.

     ### Singleton Steps
       - Declare the constructor of the class as private
       - Declare a static method
       - Declare a static member of the same class (type in the class)
