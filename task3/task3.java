
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class task3 {
   public static JSONObject parse(String fileName){
      JSONParser parser = new JSONParser();
      try(FileReader reader = new FileReader(fileName)) {
         JSONObject rootJsonObject = (JSONObject)parser.parse(reader);
         return rootJsonObject;
      } catch (Exception e) {
         System.out.println("parsing Error "+e.toString());
      }
      return null;
   }

   public static JSONArray fillValue(JSONArray tests, HashMap<Long,String> dictValues){
      for (int i = 0; i < tests.size(); i++) {
         if (((JSONObject)tests.get(i)).get("values") != null){
               fillValue((JSONArray) ((JSONObject)tests.get(i)).get("values") , dictValues);
         }
         else{
               ((JSONObject)tests.get(i)).put("value", dictValues.get(((JSONObject)tests.get(i)).get("id")));
         }
      }
      return tests;
   }

   public static void main(String[] args) {
      String fileName = args[0];
      String fileName1 = args[1];
      JSONObject tests = parse(fileName);
      JSONArray test = (JSONArray)tests.get("values");
      JSONObject values = parse(fileName1);
      HashMap<Long,String> dictValues = new HashMap<>();
      JSONArray valJsonArray = (JSONArray)values.get("values");
      for(Object ob : valJsonArray){
         JSONObject pair = (JSONObject)ob;
         long idVal = (Long) pair.get("id");
         String value = (String)pair.get("value");
         dictValues.put(idVal,value);
      }
      test =  fillValue(test,dictValues);
      tests.put("value", dictValues.get(tests.get("id")));
      tests.put("values",test);
      try(FileWriter writer = new FileWriter("report.json"))
      {
         writer.write(tests.toJSONString());
         writer.flush();
      }
      catch(IOException ex){
         System.out.println(ex.getMessage());
      }
   }
}