# Dictionary
Java application to get a word's synonyms, antonyms, rhymes, or approximate rhymes.

## Usage
![Screen capture](/img/screen-shot.png)
1) Enter a word into the search box
2) Select a category:
    * Synonym
    * Antonym
    * Rhyme
    * Approximate rhyme
3) Select max number of results (0-20)
4) Hit search button

## Dependencies
* I used the [Datamuse API](https://www.datamuse.com/api/) to get the data about a word.
* I used [Gson](https://github.com/google/gson) to process the JSON received from the Datamuse API.
