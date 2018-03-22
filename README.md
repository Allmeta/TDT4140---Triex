# Training app 2k18

Repository for group 36, TDT4140, Spring 2018.

This is an app where a user can register their workouts and get feedback from different coaches by their choosing. 
The app is compatible with different types of workouts and may be used by all age groups. 
The user will be able to track their progress in different types of exercise and see their workout history which is stored using Firebase.

Our project implements an MVC architecture with a model communicating with a database class which communicates with Firebase.

 * app.core contains our main model for communcating with the Firebase and managing our data objects
 * app.db contains code for direct communcation with the database
 * app.users and app.workouts contain helpers for managing data
 * app.ui contains our main code for managing the JavaFX application


## Getting Started

To get started download the project files from GitLab.

### Prerequisites

To run and/or test this program you should have Eclipse installed with the JavaFX extension plugin. You also need Maven to build the project, and Java installed to run the application.




## Running the tests

Simply run as Maven test. The core of the app is tested with some basic junit testing. The ui is tested with TestFX which goes through the scenes automatically, testing Button, Labels etc.



## Deployment

To deploy this on a live system you need to have Java installed, then run the FxApp as a java applet.

### Usage
When you first run the FxApp you will be greeted with a login, here you will either log in using an existing user or register a new user before logging in.
From here you can either view your previous workouts, add new workouts in form of a cardio or a strength workout or view a list of available Coaches. 

Coming soon:
Ability to choose a coach.
A coach interface where coaches can give feedback to their users.

## Built With

* [JavaFX](http://www.oracle.com/technetwork/java/javase/overview/javafx-overview-2158620.html) - The GUI building tool
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Erling Moen** - *Frontend - GUI*
* **Mathias Fagerland** - *Fullstack - Testing*
* **Thomas Almestad** - *Backend*
* **Robert Ledang** 
* **Marte Hoff Hagen** 
* **Daniel Cukrov Stupar** 
* **Gisle Steen** 





See also the list of [contributors](https://gitlab.stud.iie.ntnu.no/tdt4140-2018/36/graphs/master) who participated in this project.

## License

This project is open source.


