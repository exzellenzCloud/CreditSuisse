## CreditSuisse Java Coding Exercise

### Pre Requisites

For execution of this project system should have Java 1.8 installed.


### Running The Program
To run the code you will need to either clone the repository locally or you can download the zip file into any directory and unzip it.


After this you simply need to cd into **<Chosen Directory>**/CreditSuisse and run the commands
``` For Compilation -> javac ServerLogsHandlerApplication.java  To Run the code -> java ServerLogsHandlerApplication logfile.txt``` which will build and run the program with the log file to be parsed being **logfile.txt** which is a sample file I created based on the given example in assignment.


Logging output from the program can be found in logData.data or we can see the insert queries of event in logdata.log file.

Also, if we want to run different log file for testing then we just need to replace logfile.txt from directory.

We can see the flag events in logs as well . As per assignment, I have logged the events which has time taken longer than 4 ms.
