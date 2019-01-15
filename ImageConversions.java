//Name: Brandon TOy
//Date: November 4th 2017
//ID: V00901130
//Assignment 6
//\csc110\ Assignment 6


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.PrintStream;
import javax.imageio.ImageIO;

public class ImageConversions {

  public static void main(String[] args) {

  //Variables

    String filename = args[0];
    String OutputName = args[1];
    String Parameter = args[2];


    int[][] toInt = readGrayScaleImage(filename);

    if(Parameter.equals("invert")) {

    int[][] invertimage = invert(toInt);
    writeGreyscaleImage(OutputName, invertimage);

  } else if (Parameter.equals("verticalFlip")) {

    int[][] vertical = verticalFlip(toInt);
    writeGreyscaleImage(OutputName, vertical);

  } else if (Parameter.equals("horizontalFlip")) {

    int[][] horizontal = hortizontalFlip(toInt);
    writeGreyscaleImage(OutputName, horizontal);

  } else if (Parameter.equals("makeAscii")) {

    makeAscii(toInt, OutputName);
  } else if (Parameter.equals("rotate")) {

    int[][] rotation = rotate(toInt);
    writeGreyscaleImage(OutputName,rotation);
  } else if (Parameter.equals("scale")) {
    String s = args[3];
    Double ScalingFactor = Double.parseDouble(s);
    int[][] scaling = scale(toInt, ScalingFactor);
    writeGreyscaleImage(OutputName, scaling);
  }
else {
  System.out.print("no");
}

}

  public static int[][] invert(int[][] image) {
//To get inverse of image 255 - the number that the greyscale thing is

//Variables
  int N = 255;
  int row = image.length;
  int col = image[0].length;
  int[][] answer = new int[row][col];

//for loop

    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++) {
        answer[i][j] = (N - image[i][j]);
      }
    }
    return answer;
  }

 public static int[][] hortizontalFlip(int[][] image) { //doesn't work

  //Variables

   int i = 0;
   int row = image.length;
   int col = image[0].length;
   int[][] answer = new int[row][col];

  //For loops

     for(i = 0; i < row; i++){
       for(int j = 0; j < col; j++) {
         answer[i][j] = image[i][image[i].length - 1 - j];
       }
     }
     return answer;
}

  public static int[][] verticalFlip(int[][] image) {

//Variables

    int row = image.length;
    int col = image[0].length;
    int[][] answer = new int[row][col];

//For loops

      for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++) {
          answer[i][j] = image[image.length - i - 1][j];
        }
      }
      return answer;

}
public static void makeAscii(int[][] image, String outName) {

  //Variables
  try { PrintStream output = new PrintStream(new File(outName));

  int row = image.length;
  int col = image[0].length;
  String letter = "";
  //For loops
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {

        if(0 <= image[i][j] && image[i][j] <= 20){
          letter = "M";
          output.print(letter);

      }  else if(21 >= image[i][j] && image[i][j] <= 40) {
          letter = "L";
          output.print(letter);
        } else if(41 >= image[i][j] && image[i][j] <= 60) {
        letter = "I";
        output.print(letter);
        } else if(61 >= image[i][j] && image[i][j] <= 80) {
          letter = "o";
          output.print(letter);
        } else if(81 >= image[i][j] && image[i][j] <= 100) {
          letter = "|";
          output.print(letter);
        } else if(101 >= image[i][j] && image[i][j] <= 120) {
        letter = "=";
        output.print(letter);
        } else if(121 >= image[i][j] && image[i][j] <= 140) {
        letter = "*";
        output.print(letter);
        } else if(141 >= image[i][j] && image[i][j] <= 160) {
        letter = ":";
        output.print(letter);
        } else if(161 >= image[i][j] && image[i][j] <= 180) {
        letter = "-";
        output.print(letter);
        } else if(181 >= image[i][j] && image[i][j] <= 200){
          letter = ",";
          output.print(letter);
        } else if(201 >= image[i][j] && image[i][j] <= 220) {
          letter = ".";
          output.print(letter);
        } else {
          letter = " ";
          output.print(letter);
      }
    }
    output.println();
  }
} catch (IOException ioe) {
  System.out.print("ERROR");
}
  }



  public static int[][] scale(int[][] image,double scalefactor) {

    double dblrow = image.length * scalefactor;
    double dblcol = image[0].length * scalefactor;

    int row = (int)dblrow;
    int col = (int)dblcol;
    int[][] answer = new int[row][col];
    int scale = 0;
    int y = 0;
    int x = 0;

    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if(scalefactor >= 1.0){
          scale = (int)scalefactor;
          answer[i][j] = image[i/scale][j/scale];
        } else{
        x = (int)(i / scalefactor);
        y = (int)(j / scalefactor);
        answer[i][j] = image[x][y];
      }
    }
  }
return answer;
}


  public static int[][] rotate(int[][] image) {
    int row = image.length;
    int col = image[0].length;
    int[][] rotatepls = new int[col][row];

    for (int i = 0; i < col; i++) {
        for (int j = 0; j < row; j++) {
            rotatepls[i][j] = image[row - j - 1][i];

        }
    }

    return rotatepls;

}

public static int[][] readGrayScaleImage(String filename) {

  int[][] result = null;
  File imageFile = new File(filename);
  BufferedImage image = null;
  try {
    image = ImageIO.read(imageFile);
  } catch (IOException ioe) {
    System.err.println("Problems reading file named " + filename);
    throw new RuntimeException("Please ensure the image file is saved in the same directory as your java file.");
  }
  int height = image.getHeight();
  int width  = image.getWidth();
  result = new int[height][width];
  int rgb;
  for (int x = 0; x < width; x++) {
    for (int y = 0; y < height; y++) {
      rgb = image.getRGB(x, y);
      result[y][x] = rgb & 0xff;
    }
  }
  return result;
}
public static void writeGreyscaleImage(String filename, int[][] array) {
      int width = array[0].length;
  		int height = array.length;
  		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);

  		int rgb;
  		for (int x = 0; x < width; x++) {
  			for (int y = 0; y < height; y++) {
  				rgb = array[y][x];
  				rgb |= rgb << 8;
  				rgb |= rgb << 16;
  				image.setRGB(x, y, rgb);
  			}
  		}
  		File imageFile = new File(filename);
  		try {
  			ImageIO.write(image, "jpg", imageFile);
  		} catch (IOException ioe) {
  			System.err.println("The file could not be created " + filename);
  			return;
  		}
}
}
