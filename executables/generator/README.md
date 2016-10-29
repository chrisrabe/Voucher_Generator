# Change Log
### Version 0.1 -- THE BIRTH OF VOUCHER_GENERATOR

#### Information
This is the very basic stages of this software. Very minimal functionalities.. maybe some bugs lurking in the code.
It's the birth of something good (in my opinion anyway).

#### Functionalities:  
- addDesc - adds description into the lsit of producible descriptions
- edit - edits description of a given code
- save - saves all the code
- list - lists all possible code or description
- generate - generates a number of codes with a given value of characters

### Version 0.2

#### Additional Functionalities:
- delDesc - removes the description from the generator
- load - reads all the codes in the file
- reduce - reduces the size of code stored in the generator
- show - shows details about the specified code
- distribute - distributes the descriptions to the codes generated

#### Back-End Changes
- restructured the code so that it follows MVC design pattern
- restructured saving algorithm 
- increased efficiency of the generate method
- can now generate code without the need of adding description first

### Version 0.3

#### Additional Functionalities
- addCode - adds a custom code to the generator
- delCode - removes a specific code from the generator
- clear - can clear code or description depending on the argument passed

### Version 0.4 -- GRAPHICAL USER INTERFACE MILESTONE

#### Information
No longer will we have to suffer typing WAY too many words in the command line and sometimes enter invalid values.
A graphical user interface is now implemented!!!

#### Bug Fixes
- fixed generate getting stuck in an infinite loop if incorrect values placed
- fixed reduce getting stuck in an infinite loop if incorrect values placed

#### Back-End Changes
- compacted the add and delete functions in the controller
- new controller is installed for the program
- removed some functionalities relating to text based controller (no more list and show functions)
- deleted "Controller" class - now using VControl (View Control) as the controller
