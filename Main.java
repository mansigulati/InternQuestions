package intern;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
	static void generatePermutations(List<List<Character>> lists, List<String> result, int depth, String current) {
	    if (depth == lists.size()) {
	        result.add(current);
	        return;
	    }

	    for (int i = 0; i < lists.get(depth).size(); i++) {
	        generatePermutations(lists, result, depth + 1, current + lists.get(depth).get(i));
	    }
	  
	}
    public static void main(String[] args) {
       String file = "reportcard.csv";
       String delimiter = ",";
       String line;
       List<List<Character>> lines = new ArrayList();
       List<String> result = new ArrayList<String>();
        try (Scanner s =
                     new Scanner(new File(file))) {
            while(s.hasNext()){
                line = s.next();
                List values = Arrays.asList(line.split("\n"));
                lines.add(values);
            }
         
            generatePermutations(lines, result, 0, "");
            for (int i = 0; i < result.size(); i++)
            { 
            	System.out.print(result.get(i) + " "); 
              } 
              System.out.println(); 
          } 
         catch (Exception e){
            System.out.println(e);
        }
    }
}