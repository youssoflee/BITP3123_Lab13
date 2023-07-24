package tcptextprocessingserver;
import java.util.Date;

/**
 * This class generates word count in a text
 * 
 * @author Youssof Lee
 *
 */
public class WordCountGenerator {
	
	/*
	 * default constructor
	 */
	public WordCountGenerator()
	{
		
	}
	/**
	 * This method generates word count
	 * 
	 * @return word count in numeric
	 */
	public int getWordCount() {
		
		String input = "Hello I am Ng Wei Hen from BITS S1G1."; // The Input Words   
		
		 if (input == null || input.isEmpty()) {
		      return 0;
		    }

		 String[] words = input.split("\\s+");
		 return words.length;
		
	}
	
}
