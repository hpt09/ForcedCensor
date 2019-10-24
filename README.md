# ForcedCensor
<pre>
Dependencies:
Ubuntu
Canetis
Java
Javafx
Python

To align, must have canetis installed in the Home directory.

To run GUI:

If Java 8 and below:
Package as javafx application
Run in same directory:
java -jar ForcedCensor.jar

New Java jdk (since Javafx is not included)
Download the javafx folder. Here is is expected javafx folder is in home directory
To run the GUI, pack it as a jar 
Run following commands in the same directory: 
export PATH_TO_FX=~/javafx-sdk-11.0.2/lib
java -jar --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.media ForcedCensor.jar
