import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class task4 {
   public static void main(String[] args) throws FileNotFoundException {
      File file = new File(args[0]);
      Scanner scanner = new Scanner(file);
      ArrayList<Integer> list = new ArrayList<>();
      int middle = 0;
      int result = 0;
      while(scanner.hasNextLine()){
            list.add(Integer.parseInt(scanner.nextLine()));
      }
      list.sort(Comparator.naturalOrder());
      middle = (int)Math.floor(list.size()/2);
      int middleElement = list.get(middle);
      if (list.size() % 2 == 0){
            middleElement = (int)Math.ceil((list.get(middle-1)+list.get(middle)) /2);
      }
      for (int i : list){
            result+= Math.abs(i-middleElement);
      }
      System.out.println(result);
      scanner.close();
   }
}