
## Welcome to ToDoList Application
A simple command line JAVA program to create and manage a personal Todo List.
## Author
[Janko Radakovic](https://github.com/janko101)
## Built with
* Java 15.0.1
## Testing framework
* JUnit 5.6.2
## Setup
To run this app
- Clone this repository.
##### Run the following command:
``` gradle run --console=plain```
## Basic features
* Models a task with:
    * Title
    * Due date
    * Status
    * project
  
    
* Display a collection of tasks that can be sorted
    * By date
    * By project
    

* Support the ability to
    * Add task
    * Edit task
    * Mark a task as done
    * Remove tasks
    

* Support a text-based user interface
* Load and save task list to data file`

## Class Diagram 
![Class Diagram](res/class-diagram.png)

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











