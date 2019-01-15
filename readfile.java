import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class readfile {

  public static void main(String[] args) {
    int row = image.length;
    int col = image[0].length;
    String letter = "";
    //For loops
      for(int i; i < row; i++) {
        for(int j; j < col; j++) {

          if(0 <= image[i][j] && image[i][j] <= 20){
            letter = "M";
            System.out.print(letter);

        }  else if(21 >= image[i][j] && image[i][j] <= 40) {
            letter = "L";
            System.out.print(letter);
          } else if(41 >= image[i][j] && image[i][j] <= 60) {
          letter = "I";
          System.out.print(letter);
        } else if(61 >= image[i][j] && image[i][j] <= 80) {
            letter = "o";
            System.out.print(letter);
          } else if(81 >= image[i][j] && image[i][j] <= 100) {
            letter = "|";
            System.out.print(letter);
          } else if(101 >= image[i][j] && image[i][j] <= 120) {
          letter = "=";
          System.out.print(letter);
          } else if(121 >= image[i][j] && image[i][j] <= 140) {
          letter = "*";
          System.out.print(letter);
          } else if(141 >= image[i][j] && image[i][j] <= 160) {
          letter = ":";
          System.out.print(letter);
    }    else if(161 >= image[i][j] && image[i][j] <= 180) {
          letter = "-";
          System.out.print(letter);
  }      else if(181 >= image[i][j] && image[i][j] <= 200){
        letter = "\'";
        System.out.print(letter);
      }else if(201 >= image[i][j] && image[i][j] <= 220) {
        letter = ".";
        System.out.print(letter);
      } else {
        letter = " ";
        System.out.print(letter);
      }
      }

  }
}
}
