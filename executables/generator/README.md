# Change Log
### Version 0.1 -- THE BIRTH OF VOUCHER_GENERATOR
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
