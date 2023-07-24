package tcptextprocessingconsoleclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;	

/**
 * This client class enables to send request by typing input
 * of text for translation in console.
 *  
 * Menu will be displayed for client to make choice of 
 * target language.
 * 
 * @author Youssof Lee
 */

public class ClientTextTranslationConsoleApp{

	
	public static void main(String[] args)  throws UnknownHostException, IOException
	{	
		// 1. Connect to the server / remote machine @ localhost, port 6789
		Socket socket = new Socket(InetAddress.getLocalHost(), 6789);
		
		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		
		// Validate status of connection
		boolean connStatus = true;
		if (connStatus)
			status = "Connection has established.";
		
		System.out.println(status);
		
		// Display console menu to enable input
		System.out.print("Enter the text: ");
		
		// receive input  in String
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		// display menu for language translation selection
		// Malay, Arabic and Korean
		System.out.println("");
		System.out.println("Please select target language for translation:");
		System.out.println("-----------------------------------------------------");
		System.out.println("[1] Malay");
		System.out.println("[2] Arabic");
		System.out.println("[3] Korean");
		
		// receive numeric input for choice
		System.out.print("\n" + "Your choice: ");
		int choice = sc.nextInt();
		
		// declare variable for storing translated text for later use
		String translatedText = "";
		
		// create input stream to read data based on the input on network
		DataInputStream datainputstream = new DataInputStream(socket.getInputStream());
		
		// create output stream to write data based on the input on network
		DataOutputStream dataoutputStream = new DataOutputStream(socket.getOutputStream());
		
		// if client wants to translate to Malay
		if(choice == 1)
		{
			  // write input for text to be translated and the choice of target language
			  // to the stream
			  dataoutputStream.writeUTF(line);
			  dataoutputStream.writeInt(choice);
			  
			  // read the Malay translated text from the stream after translation from server is done
			  String translated = datainputstream.readUTF();
			  
			  // display the original text and its Malay translated text
			  System.out.println("The text: " + line);
			  System.out.println("The text translated in Malay: " + translated);
		}
		// else if client wants to translate to Arabic
		else if(choice == 2)
		{
			  // write input for text to be translated and the choice of target language
			  // to the stream
			  dataoutputStream.writeUTF(line);
			  dataoutputStream.writeInt(choice);
			  
			  // read the Arabic translated text from the stream after translation from server is done
			  String translated = datainputstream.readUTF();
			  
			  // display the original text and its Arabic translated text
			  System.out.println("The text: " + line);
			  System.out.println("The text translated in Arabic: " + translated);
		}
		// else if client wants to translate to Korean
		else if(choice == 3)
		{
			  // write input for text to be translated and the choice of target language
			  // to the stream
			  dataoutputStream.writeUTF(line);
			  dataoutputStream.writeInt(choice);
			  
			  // read the Korean translated text from the stream after translation from server is done
			  String translated = datainputstream.readUTF();
			  
			  // display the original text and its Korean translated text
			  System.out.println("The text: " + line);
			  System.out.println("The text translated in Korean: " + translated);
		}
		// else the sentence is not exist in the source file (in server side)
		else
		{
			System.out.println("This text cannot be translated!");
		}
		
		// 2. Send request to server, request is made by default
		// 3. Accept response from the server - read from network
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display the translation
		String translated = bufferedReader.readLine();
		
		
	}
}
