
## Welcome to ToDoList Application
A simple command line JAVA program to create and manage a personal Todo List.
## Author
[Janko Radakovic](https://github.com/janko101)
## Built with
* Java 15.0.1
## Testing framework
* JUnit 5.6.2
## Setup
Before running the app make sure you have the latest Gradle ([Installation instructions](https://gradle.org/install/)) and Java JDK ([Installation instructions](https://adoptopenjdk.net/releases.html?variant=openjdk15&jvmVariant=hotspot)) versions installed on your computer.

To run this app
- Clone this repository
  
- cd into cloned folder
##### Run the following command:
```$ gradle run --console=plain```

## Basic features
* Models a task with:
    * Name
    * Due date
    * Status
    * Project
  
    
* Display a list of tasks that can be sorted
    * By Due date
    * By Project
    

* Support the ability to
    * Add task
    * Edit task (Name, Project and Due Date)
    * Mark task as done
    * Remove task
    

* Support a text-based user interface
* Load and save task list to data file

## Class Diagram
![Class Diagram](res/class-diagram.png)

## User Manual
When user runs the application, welcome message will be displayed on a screen and any saved todo list will be loaded, application will notify a user on how many completed and not completed tasks are there on a list. Finally, main menu will be displayed. (Picture below).

![Main Menu](res/mainmenu.png)

### Add a new task
If user types number [2] and presses ENTER, the application will
prompt the user to enter the required fields of a task to add to the
ToDo list (Picture below).

![Add Task](res/addTask.png)

After adding a task user sees a success message and can see the whole list before the main menu is again displayed.

![Add Task Success](res/addedSuccess.png)

### Show List Menu
If user selects option [1], the applications first displays the whole list. After, it displays a menu with options to see all the task's under same project, or to see all the tasks with same due date. (Picture below).

![Add Task Success](res/showlistmenu.png)

#### Tasks Sorted by Due Date
If user chooses to see all the tasks with same due date, he will then type [1] and the application will then prompt the user to enter a due date he would like to see the tasks for. After entering a date, tasks with that due date are displayed and user is returned to main menu. (Picture below).

![Sort Task By Due Date](res/sortdate.png)

#### Tasks Sorted by Project
If user chooses to see all the tasks under same project, he will then type [2] and the application will then prompt the user to enter a project he would like to see the tasks for. After entering a project, all the tasks under that project are displayed and user is returned to main menu. (Picture below).

![Sort Task By Project](res/sortproject.png)

### Mark Task As Done
If user selects option [4] from the main menu, the application will display the whole todo list and prompt the user to enter the name of a task he would like to mark as done. After entering the name, success message is displayed. (Picture below).

![Mark Task As Done](res/MarkDone1.png)

After that, the list is again displayed and user is back to main menu where he can see that task is now in the completed category. (Picture below).

![Mark Task As Done](res/markDone2.png)

### Remove A Task
If user selects option [3] from the main menu, application will display the whole todo list and prompt the user to enter a name of the task he would like to remove. After entering the name, success message is displayed. (Picture below).

![Remove Task](res/remove1.png)

After removing the task, first the whole list is displayed, so the user can see that the task is no longer on the list, user is then returned to main menu. (Picture below).

![Remove Task](res/remove2.png)

### Edit Task
If user selects option [5] from the main menu, the application will first display the whole list and after the menu with options for editing tasks will be displayed. User can there choose to either edit task's name, project or due date. (Picture below).

![Edit Task](res/editTaskMenu.png)

#### Edit Task's Name
In Edit Task Menu, if user wishes to edit task's name, he'll choose the option [1], application will then prompt the user to enter a name of the task he wants to edit. After which, user will be prompted to enter a new name for the task. User gets a success message, and the list is then again displayed, so the user can see the new name of the task. (Picture below).

![Edit Task](res/editName.png)

#### Edit Task's Project
In Edit Task Menu, if user wishes to edit task's project, he'll choose the option [2], application will then prompt the user to enter a name of the task he wants to edit. After which, user will be prompted to enter a new project for the task. User gets a success message, and the list is then again displayed, so the user can see the new project of the task. (Picture below).

![Edit Task](res/editProject.png)

#### Edit Task's Due Date
In Edit Task Menu, if user wishes to edit task's due date, he'll choose the option [3], application will then prompt the user to enter a name of the task he wants to edit. After which, user will be prompted to enter a new due date for the task. User gets a success message, and the list is then again displayed, so the user can see the new due date of the task. (Picture below).

![Edit Task](res/editDate.png)

### Save and Quit
If user selects option [6] from the main menu, the application will save todo list to a file and print out a Goodbye message to a user. (Picture below).

![Save and Quit](res/save.png)

## User Stories
```
As a user
In order to have a functional ToDo List
I have to be able to create a task and add it to my list
```
```
As a User
In order to keep my ToDo List up to date
I should be able to remove tasks from it.
```
```
As a user
In order to see all the tasks belonging to a specific project
I have to be able to sort the tasks by project
```
```
As a user
In order to see all the tasks with the same due date
I have to be able to sort the tasks by the due date
```
```
As a user
In order to update my tasks on the list
I have to be able to edit all the tasks fields
```
```
As a user
In order to keep track of completed and not completed tasks
I have to be able to find the task and mark it as done and see the count of completed and not completed tasks
```
```
As a user
In order to navigate the application
I need to have an interface
```
```
As a user
In order to keep my data when exiting the app
I should be able to write data to the file and load it from the file when starting the app
```
```
As a user
In order for my list to be viable
I shouldn't be able to set a due date in the past or have a task without a name
```

## License
MIT-license
## Acknowledgements
##### Kungliga Tekniska högskolan (KTH), Stockholm 
  - for giving out this assignment.
##### Nour AlHuda Almajni TA at KTH 
  - for the mentorship, directions regarding refactoring and video on writing to file.
##### Kai Böhrnsen TA at KTH
  - for reviewing and providing guidelines to improve.
##### Kwabena Asante-Poku at KTH 
  - for demos on testing with JUnit.







