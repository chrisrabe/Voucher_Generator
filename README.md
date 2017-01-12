# Voucher_Generator

### Description

This program was inspired by a friend's love for redeemable codes and the prizes which could be received from them. I created this program as a tool for creating files which is filled with a list of voucher descriptions. These files could be used by an external application which could analyse and redeem these vouchers.

Each voucher contains a code and a description and a flag which indicates whether it has been redeemed or not. The number of vouchers produced and the length of each code are specified by the user. Each code contains a combined string of uppercase, lowercase, and number characters. The program ensures that it produces as many vouchers as it can before it becomes difficult to generate a unique code. What I mean by this is if the user specifies that he/she wants 500 vouchers which has codes with the length of 1. The program would not reach the user specified amount because if the code length is 1 character, then it means that it can only produce 62 combinations. The algorithm used is smart enough to stop generating when necessary.

### Source Code and Executables

This project is completely open source. Feel free to put any improvements or create your own generator. 
I've also provided executable jar files if you just want to use the tool.

### Getting Started

Ensure that you have a java runtime environment installed. It is recommended that you [download jre-8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) or later.

Download the latest release either from the [releases page](https://github.com/chrisrabe/Voucher_Generator/releases) or the [executables page](https://github.com/chrisrabe/Voucher_Generator/tree/master/executables/generator).

The latest versions usually have a .bat file included inside the distributed .zip folder. However, if you are interested in running the older versions, you have to use the command line to execute it because some versions does not have a corresponding .bat file.

To run a .jar file, you open up the command prompt (windowsKey + r, then type "cmd" to open the shell). Navigate to where you have the .jar file, then type ``` java -jar Voucher_Generator_vN``` in the command prompt, where 'N' is the version number of the jar file.

Note: The easiest way to navigate to the folder with the .jar is to run 'cmd' via folder explorer, assuming that you are currently in the directory of the .jar file. 

For more information, please visit the [wiki page](https://github.com/chrisrabe/Voucher_Generator/wiki).
