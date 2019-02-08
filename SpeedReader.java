// https://www.mkyong.com/java/java-convert-string-to-int/
// Nolan Schoenle pointed out that we needed to wipe our panel between words

import java.io.IOException;
import java.lang.String;
import java.awt.Font;
import java.lang.Thread;
import java.awt.Graphics;


public class SpeedReader {
  public static void main(String[] args) throws IOException, InterruptedException {
    if (args.length != 5) {
      System.out.println("Please input valid filename, width, height, font size, and wpm orderly!");
    } else {
      int width = Integer.parseInt(args[1]);
      int height = Integer.parseInt(args[2]);
      int fontsize = Integer.parseInt(args[3]);
      int wpm = Integer.parseInt(args[4]);
      
      WordGenerator file = new WordGenerator(args[0]);
      DrawingPanel panel = new DrawingPanel(width, height);
      Graphics g = panel.getGraphics();
      Font f = new Font("Courier", Font.BOLD, fontsize);
      g.setFont(f);
      
      while (file.hasNext()) {
        g.drawString(file.next(), width / 3, height / 2);
        Thread.sleep(wpm*6);
        panel.clear();
      }
    }
  }

}

