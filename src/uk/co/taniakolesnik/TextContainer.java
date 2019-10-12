package uk.co.taniakolesnik;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "/Users/taniakolesnik/Downloads/TEST.txt")
public class TextContainer {

  private String text = "Mars has seasons like Earth, but they last twice as long";

  @SaverMethod
  public void save(String path){
      File file = new File(path);
      try (FileWriter writer = new FileWriter(file)) {
          writer.write(text);
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}
