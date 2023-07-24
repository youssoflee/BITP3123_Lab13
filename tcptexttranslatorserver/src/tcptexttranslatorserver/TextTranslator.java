package tcptexttranslatorserver;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * This class will parse the translated text to the variable
 * where it will be sent back to client for display based on the input received
 * and the selected target language (Malay, Arabic and Korean) from client request.
 * 
 * @author Youssof Lee
 */

public class TextTranslator {

	/**
	 * This method retrieves Malay text for English-Malay translation used.
	 * 
	 * @param text: Text input to be translated
	 * @return translated Malay text
	 */
	public String translateToBM(String text)
	{
		
		String translated = "";
		
		// declare target storage to be read 
		String path = "Malay.txt";
		
		// variable for storing text input of translation
		String morning, night, howareyou, thank, bye, whatup = "";
		
		try
		{
			// create stream to read data from source file
			FileInputStream file = new FileInputStream(path);
			DataInputStream read = new DataInputStream(file);
			
			// read data
			morning = read.readUTF();
			night = read.readUTF();
			howareyou = read.readUTF();
			thank = read.readUTF();
			bye = read.readUTF();
			whatup = read.readUTF();
			
			// Conditions to parse the correspond text to the respective variable
			// based on English text input
			if(text.toUpperCase().equals("GOOD MORNING"))
			{
				translated = morning;
			}
			else if(text.toUpperCase().equals("GOOD NIGHT"))
			{
				translated = night;
			}
			else if(text.toUpperCase().equals("HOW ARE YOU") || text.toUpperCase().equals("HOW ARE YOU ?")
				|| text.toUpperCase().equals("HOW ARE YOU?"))
			{
				translated = howareyou;
			}
			else if(text.toUpperCase().equals("THANK YOU"))
			{
				translated = thank;
			}
			else if(text.toUpperCase().equals("GOODBYE"))
			{
				translated = bye;
			}
			else if(text.toUpperCase().equals("WHAT'S UP ?") || text.toUpperCase().equals("WHAT'S UP")
					|| text.toUpperCase().equals("WHAT'S UP?"))
			{
				translated = whatup;
			}
			else
			{
				translated = "Error No Related Word In Database";
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		return translated;
	}
	
	/**
	 * This method retrieves Arabic text for English-Arabic translation used.
	 * 
	 * @param text: Text input to be translated
	 * @return translated Arabic text
	 */
	public String translateToArb(String text)
	{
		String translated = "";
		
		// declare target storage to be read 
		String path = "Arabic.txt";
		
		// variable for storing text input of translation
		String morning, night, howareyou, thank, bye, whatup = "";
		
		try
		{
			// create stream to read data from source file
			FileInputStream file = new FileInputStream(path);
			DataInputStream read = new DataInputStream(file);
			
			// read data
			morning = read.readUTF();
			night = read.readUTF();
			howareyou = read.readUTF();
			thank = read.readUTF();
			bye = read.readUTF();
			whatup = read.readUTF();
			
			// Conditions to parse the correspond text to the respective variable
			// based on English text input
			if(text.toUpperCase().equals("GOOD MORNING"))
			{
				translated = morning;
			}
			else if(text.toUpperCase().equals("GOOD NIGHT"))
			{
				translated = night;
			}
			else if(text.toUpperCase().equals("HOW ARE YOU") || text.toUpperCase().equals("HOW ARE YOU ?")
					|| text.toUpperCase().equals("HOW ARE YOU?"))
			{
				translated = howareyou;
			}
			else if(text.toUpperCase().equals("THANK YOU"))
			{
				translated = thank;
			}
			else if(text.toUpperCase().equals("GOODBYE"))
			{
				translated = bye;
			}
			else if(text.toUpperCase().equals("WHAT'S UP ?") || text.toUpperCase().equals("WHAT'S UP"))
			{
				translated = whatup;
			}
			else
			{
				translated = "Error No Related Word In Database";
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		return translated;
	}
	
	
	/**
	 * This method retrieves Korean text for English-Korean translation used.
	 * 
	 * @param text: Text input to be translated
	 * @return translated Korean text
	 */
	public String translateToKrn(String text)
	{
		String translated = "";
		
		// declare target storage to be read 
		String path = "Korean.txt";
		
		// variable for storing text input of translation
		String morning, night, howareyou, thank, bye, whatup = "";
		
		try
		{
			// create stream to read data from source file
			FileInputStream file = new FileInputStream(path);
			DataInputStream read = new DataInputStream(file);
			
			// read data
			morning = read.readUTF();
			night = read.readUTF();
			howareyou = read.readUTF();
			thank = read.readUTF();
			bye = read.readUTF();
			whatup = read.readUTF();
			
			// Conditions to parse the correspond text to the respective variable
			// based on English text input
			if(text.toUpperCase().equals("GOOD MORNING"))
			{
				translated = morning;
			}
			else if(text.toUpperCase().equals("GOOD NIGHT"))
			{
				translated = night;
			}
			else if(text.toUpperCase().equals("HOW ARE YOU") || text.toUpperCase().equals("HOW ARE YOU ?")
					|| text.toUpperCase().equals("HOW ARE YOU?"))
			{
				translated = howareyou;
			}
			else if(text.toUpperCase().equals("THANK YOU"))
			{
				translated = thank;
			}
			else if(text.toUpperCase().equals("GOODBYE"))
			{
				translated = bye;
			}
			else if(text.toUpperCase().equals("WHAT'S UP ?") || text.toUpperCase().equals("WHAT'S UP"))
			{
				translated = whatup;
			}
			else
			{
				translated = "Error No Related Word In Database";
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		return translated;
	}
}
