import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task2 {
   public static void main(String[] args) throws FileNotFoundException {
      File fileCircle = new File(args[0]);
      File fileCoords = new File(args[1]);
      Scanner scannerCircle = new Scanner(fileCircle);
      Scanner scannerCoords = new Scanner(fileCoords);
      String[] coordsCircleStr = scannerCircle.nextLine().split(" ");
      float[] coordsCircle = new float[2];
      for (int i = 0; i < 2; i++) {
         coordsCircle[i] = Float.parseFloat(coordsCircleStr[i]);
      }
      float radius = Float.parseFloat(scannerCircle.nextLine());
      String coordsPointStr = "";
      while(scannerCoords.hasNextLine()){
         coordsPointStr += scannerCoords.nextLine()+"\t";
      }
      int countPoints = coordsPointStr.split("\t").length;
      String[] arrayCoordPointStr = coordsPointStr.split("\t");
      float[][] coordsPoint = new float[countPoints][2];
      for (int i = 0; i < countPoints; i++) {
         String[] point = arrayCoordPointStr[i].split(" ");
         coordsPoint[i] = new float[2];
         for (int j = 0; j < 2; j++) {
               coordsPoint[i][j] = Float.parseFloat(point[j]);
         }
      }
      for (int i = 0; i < countPoints; i++) {
         float result = (coordsCircle[0]-coordsPoint[i][0])*(coordsCircle[0]-coordsPoint[i][0])+(coordsCircle[1]-coordsPoint[i][1])*(coordsCircle[1]-coordsPoint[i][1]);
         if (result == radius*radius){
               System.out.println(0);
         }
         else if (result < radius*radius){
               System.out.println(1);
         }
         else if (result > radius*radius){
               System.out.println(2);
         }
      }
      scannerCircle.close();
      scannerCoords.close();
   }
}