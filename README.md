# cs56-languages-vocab-quiz

W16 ready! (Yessenia Valencia)

This is a foreign language quiz that currently tests German vocabulary. It is abstracted in such a way so that it could be adapted to other languages, but currently it only tests German -> English and English -> German.

![](http://i.imgur.com/mTfTOD6.png)

project history
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

* The code for reading in the file is located in the `FileRead` class. As you can see in the constructor, it is currently hard-coded for the one text file included.

```java
public FileRead()
{
	this.filename = "/text/vocabulary.txt";
	this.list = new ArrayList<String>();
}
```
* The `ForeignVocabWord` class stores a foreign word and its English translation as Strings.
* The `ForeignVocabQuiz` class contains the basic logic for running the quiz. It reads in the file and sets up the list of possible words to test the user on. Currently, the foreign words and English words are located on alternating lines in the text file, but this could be improved to possibly use JSON or XML format.

## How to run
To start the game, use `ant run`.
