
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.String;

public class WordGenerator {
public Scanner text;

public WordGenerator(String filename) throws IOException {
 this.text = new Scanner(new File(filename));
}

public boolean hasNext() {
 if (this.text.equals(null))
  return false;
 else
  return true;
}

public String next() {
 if (this.text.hasNext()) {
  return this.text.next();
 } else
  return null;
}

public int getWordCount() {
 int counter = 0;

 while (this.text.hasNext()) {
  counter++;
  this.text.next();
 }
 return counter;
}


  public int getSentenceCount() {
    int counter = 0;
    String delimiters = "?!.";
    String s;
    
    while (this.text.hasNext()) {
      s = this.text.next();
      
      for (int i = 0; i < s.length(); i++) {
        if (delimiters.indexOf(s.charAt(i)) != -1) {
          counter++;
        }
      }
    }

    return counter;
  }

 
}