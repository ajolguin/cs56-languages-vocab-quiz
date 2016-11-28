# cs56-languages-vocab-quiz

F16 ready! (Adrian Olguin, Cristobal Caballero)

This is a foreign language quiz that has now been updated to test German, Spanish, French, Italian, and Japanese vocabulary. It is abstracted in such a way so that it could be adapted to other languages, but currently it only tests from any one of those languages to English and from English to that chosen language.

![](http://i.imgur.com/mTfTOD6.png)

Project History
===============
```
YES | mastergberry | TBD | A quiz that is designed to test the user's knowledge on foreign vocabulary
```
```
 W14 | bkiefer13 | TBD | A quiz that is designed to test the user's knowledge on foreign vocabulary
```
```
W16 | yvalencia | TBD | A quiz that is designed to test the user's knowledge on foreign vocabulary
```

## Documentation

* The code for reading in the file is located in the `FileRead` class. As you can see in the constructor, it is currently hard-coded for the one text file included. (W16 update!) It is no longer hardcorded to a single language but accept a range of different lists that are stored in the package under the .txt extension. The updated constructor is shown below.

```java
public FileRead(String language)
{      
       	this.filename = "" + language + ".txt";
        this.list = new ArrayList<String>();
        this.fileURL = getClass().getResource(filename);
        this.fileFile = new File(fileURL.getFile());
}
```



* The `ForeignVocabWord` class stores a foreign word and its English translation as Strings.
* The `ForeignVocabQuiz` class contains the basic logic for running the quiz. It reads in the file and sets up the list of possible words to test the user on. Currently, the foreign words and English words are located on alternating lines in the text file, but this could be improved to possibly use JSON or XML format.

## How To Run
To start the game, use `ant run`.

## Usable Ant Targets
* clean:    deletes unneccessary files and directories
* compile:  compiles my code 
* jar:      jar my code
* javadoc:  create javadoc
* jws:      publish java web start
* output:   output from different classes
* run:      run the Main Class program
* test:     tests my Main Class


## W16 Last Remarks

* One of the reason the JWS would not show up or run on your device is because of Java permissions in your browser that are set on High or Very High (which is common in current browsers to prevent unwanted activity) so those could be adjusted.
* The language is no longer hardcoded to a specific file but the set of text files that could be found in the class path.
* The toolbar elements do not have any functionality at the moment so clicking would not initiate anything
* ForeignVocabOutput was added to show output of the file being read in FileRead to make sure all the terms are present and being added to ArrayList
* There is an images folder of .gif files that I was not able to add to GUI, disregard these at your discretion. 

## F16 Final Remarks

* The toolbar elements still do not have any functionality and images have yet to be incorporated into the GUI
* More words have been added to each language .txt file, however there is a bug in which it does not read in all of the new words. Additionally, the output of ForeignVocabOuput used by 'ant ouput' does not print out all words in these .txt files/ 
* The program itself now runs well, difficulties have been added after selecting a language but consider applhying this option to the main page of the GUI so that the user can choose the language and difficulty of their preference simultaneously.
* Lots of refactoring can be done to ForeignVocabQuizGUI in the go() method, the while loops and if statements in lines 192-243 seem to only execute once then become unneccessary afterwards. This can be refactored, comments can now be removed, and consider creating a helper method to be used in the actionListeners that gets a new word and its counterpart so that code isn't repeated.
