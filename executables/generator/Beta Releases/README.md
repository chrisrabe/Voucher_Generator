# Change Log
### Version 1.0.0 -- THE BIRTH OF BETA RELEASE

#### Additional Functionalities
- can now add new characters for the voucher code generation
- can now activate and deactivate some characters for the voucher code generation
- experimental themes feature added
- can now save and load the code to XML files

#### Graphical Improvement
- each button now has a 'glow' effect when the mouse is above it
- new navigation system implemented (the grid)
- each function now has an icon

#### Code changes (this is for people who want to use the code for their own version of the software)
- removed the component factory, I now have my own package which contains custom swing components instead
- properly implemented the MVC design pattern. In the previous version, each view is coupled with the 
controller because the controller is the parent component of each view. In this version, there is now a hierarchy
of controllers where the application controller is the main controller which contains and initialises its sub 
controllers called 'page controllers'. Each page controllers are related to a view and may or may not contain sub
controllers called 'display controllers'. Basically, each controller is related to some type of view and each view
are completely decoupled from everything else.
- renamed the 'code' field in the 'Code' object to 'id' because it's a bit more descriptive. 
- each main operation (voucher operations, theme operations, description operations) are now handled by their own managers
rather than having one 'overlord' generator class that handles everything. In other words, I implemented SRP.
- save and load operations are now handled by 'event handlers'. It is simply an interface which needs to be extended when
a new operation is needed. It allows me to add new functionalities to the system without changing other classes.
- codes and descriptions are now stored in their own custom storages. There is an interface for them, so if a more efficient
storage could be made, it's a lot easier to change.
- all the main classes (managers, storages, etc...) have their own interfaces and can be extended to create more efficient 
versions of those classes.
