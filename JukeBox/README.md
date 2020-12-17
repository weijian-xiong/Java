# OOA / OOD / OOP / OOQA
Object Oriented Analysis / Object Oriented Design / Object Oriented Programming / Object Oriented Quality Assurance

## Description:
Design a Juke Box that allows customers to select songs they want played or to submit a play list that they have already created previously. If a request is made for song that is not contained by a local Juke Box, it will query for that song from other Jukeboxes elsewhere in the country - thus they are networked. Although reminiscent of Napster, like the original jukebox, we want to provide a mechanism for owners, record companies and artists to earn a profit. Therefore, for this Juke Box we want to provide not only a coin drop and cash feed mechanism, but also a card swipe mechanism and a cell dial payment capability.

## UML Diagrams
<details>
   <summary>Use Case Diagram</summary>
   <p><img src='Diagrams/Use Case Diagram.png' alt='Use Case Diagram'/></p>
</details>
<details>
   <summary>Class Diagram</summary>
   <p><img src='Diagrams/Class Diagram.png' alt='Class Diagram'/></p>
</details>
<details>
   <summary>Sequence Diagram</summary>
   <p><img src='Diagrams/Sequence Diagram.png' alt='Sequence Diagram'/></p>
</details>

## Unit Testing Structure
```
+-----------------------+   +-----------------------+  +---------------------+
|       Database        |   |          Song         |  |       Jukebox       |
+-----------------------+   +-----------------------+  +---------------------+
+-----------------------+   +-----------------------+  +---------------------+
|      DatabaseTest     |   |       SongTest        |  |     JukeboxTest     |
+-----------------------+   +-----------------------+  +---------------------+
           |____________________________|__________________________|
                                        |
                            +----------------------+
                            |   JUnit Test Suite   |
                            +----------------------+
                            +----------------------+
                            |     Test Runner      |
                            +----------------------+
```

## How to run
### Program

Download JLayer1.0.1 folder from [Here](http://www.javazoom.net/javalayer/sources.html), and put this folder into JukeBox folder.<br>
Run this command for using javazoom package in Song.java class:  
```
export CLASSPATH=$CLASSPATH:Path/to/JukeBox/JLayer1.0.1/jl1.0.1.jar  
```

### JUnit test
Run this command to export junit-4.10.jar for JUnit testing:   [Click here to download junit4-10.jar](https://github.com/downloads/junit-team/junit/junit-4.10.jar)
```
export CLASSPATH=$CLASSPATH:Path/to/JukeBox/JUnit/junit-4.10.jar  
```
Then run these commands to see testing output:
```
cd JUnit
export CLASSPATH=$CLASSPATH:"Path/to/JukeBox/Source Code/"
javac *.java
java TestRunner
```

## JUnit test Output
### Test succeed
<img width="1039" alt="Test Succeed" src="https://user-images.githubusercontent.com/24274444/100347761-7bed6280-2fab-11eb-9e21-256b8ff0a0a9.png">

### Test failed
<img width="710" alt="Test Failed" src="https://user-images.githubusercontent.com/24274444/100347757-7abc3580-2fab-11eb-8cea-40cc49dc2dd2.png">

