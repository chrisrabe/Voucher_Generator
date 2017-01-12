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
controller because the controller is the parent component
