package textAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * TextAnalyzer scans text from a file in order to count word occurrence.
 * Text is read from local file. JavaFX used to create GUI.
 * @author aznso
 */

public class TextAnalyzer extends Application
{
    public static void main(String[] args) throws FileNotFoundException {
    	
    	launch(args);
    }
  
    
    /**
     * 
     * 
     */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		  File file = new File("C:/Users/aznso/Documents/TheRaven.txt");
	        Scanner scan = new Scanner(file,"UTF-8");
	        
	        /**
	         * map to store key value pair
	         * key : word
	         * value: frequency of the word
	         */
	        
	        Map<String,Integer> map = new HashMap<String, Integer>(); 
	        while (scan.hasNext())
	        {
	        	
	        	/**
	        	 * val.replaceAll attempts to remove special characters from the text
	        	 */
	        	
	            String val = scan.next(); 
	            val = val.replaceAll("[,./\\!?\"-;:]", ""); 
	            
	            /**
	             * if.containsKey determines if the string already exists within the map
	             * If it does not, insert it into the map
	             * Otherwise, remove the entry, increment the value count, and insert it again
	             */
	            
	            if(map.containsKey(val) == false) 
	                map.put(val,1);
	            else 
	            {
	                int count = (int)(map.get(val)); 
	                map.remove(val);  
	                map.put(val,count+1); 
	            }
	        }
	        
	        /** map.entrySet retrieves the contents of the map
	         *  new ArrayList makes an array list of the contents
	         *  new Comparator sorts the array list
	         */ 
	       
	       Set<Map.Entry<String, Integer>> set = map.entrySet(); 
	        List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set); 
	        Collections.sort( sortedList, new Comparator<Map.Entry<String, Integer>>() 
	        {
	        	
	        	/** this function compares value for sorting
	        	 * the first return is for descending order
	        	 * the second return is for ascending order
	        	 */
	            public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b ) 
	            {
	                return (b.getValue()).compareTo( a.getValue() ); 
	              //return (a.getValue()).compareTo( b.getValue() ); 
	            }
	        } );
	        
	      
	    /**
	     * use JavaFX to create a GUI to display the program results
	     */
	       
		Label[] label = new Label[20];
		GridPane gridPane = new GridPane();
		
		primaryStage.setTitle("The Raven");
		
		int count = 0;
		
		  for(Map.Entry<String, Integer> i:sortedList){
	            System.out.println(i.getKey()+" -> "+i.getValue());
	            if(count<20) {
	            	label[count] = new Label(i.getKey()+" -> "+i.getValue());            
	            	gridPane.add(label[count],1,count);
	            }
	            count++;
	         
	        }
		
	  
		Scene scene = new Scene(gridPane, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		 scan.close();
		
	}
}