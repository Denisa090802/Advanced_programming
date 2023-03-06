Compulsory (1p)

Create an object-oriented model of the problem. You should have (at least) the following classes: Location, Road.
The location and road types will be implemented as enums.
Each class should have appropriate constructors, getters and setters.
Use the IDE features for code generation, such as generating getters and setters.
The toString method form the Object class must be properly overridden for all the classes.
Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
Create and print on the screen various objects of the two classes.


Homework (2p)
Create a class that describes an instance of the problem.
Override the Object.equals method for the Location and Road classes. The problem should not allow adding the same location or road twice.
Instead of using an enum, create dedicated classes either for locations: cities, air ports, gas stations etc. or roads: highway, express, country, etc. Each concrete location class may have additional specific propertes (population, number of terminals, gas price, etc.)
Implement a method that determines if a problem's instance is valid.
Implement an algorithm for determining if it is possible to go from one location to another using the given roads.
Write doc comments in your source code and generate the class documentation using javadoc.

Am creat clase corespunzatoare pentru drumuri si locatii si am creat liste corespunzatoare pentru ele in clasa Map. 
Drumurile puteau fi de 3 tipuri: Highway, Express, Country
Locatiile puteau fi de 3 tipuri: GasStation, Airport, City
Am creeat getterele si setterele corespunzatoare.
In clasa Map am construit functii de verificare a validitatii si de verificare a existentei unui drum intre doua locatii.