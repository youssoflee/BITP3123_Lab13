package tcptextprocessingconsoleserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * This server class launch application using TCP
 * for text ranslation in console.
 * 
 * This claass will translate the text input from server to
 * target language (Malay, Arabic, Korean).
 * 
 * @author Youssof Lee
 */

public class ServerTextTranslationConsoleApp{

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main (String [] args) throws IOException
	{
		ServerSocket serverSocket = null;
		TextTranslator translate = new TextTranslator();
		
		// create data from TextTranslator.java using stream
		translate.createData();

				try
				{
					int totalRequest = 0;
					
					// 1. bind request to a port number, 6789
					int portNo = 6789;
					serverSocket = new ServerSocket(portNo);
					
					// 2. Listen continuously for request of connection
					// Server needs to be alive forever in unterminated while loop
					while (true) {
						
						// 3. Accept client request for connection
						Socket clientSocket = serverSocket.accept();
						
						// create input stream for read the text input from client request on network
						DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
						
						// read the text input, and the choice of target language from client
						String text = inputStream.readUTF();
						int languageChoice = inputStream.readInt();
						String language = "";
						String translated = "";
						
						// if client input target language is Malay
						if(languageChoice == 1)
						{
							// parse the text for Malay translation 
							language = "Malay";
							translated = translate.translateToBM(text);
						}
						// else if client input target language is Arabic
						else if(languageChoice == 2)
						{
							// parse the text for Arabic translation 
							language = "Arabic";
							translated = translate.translateToArb(text);
						}
						// else if client input target language is Korean
						else if(languageChoice == 3)
						{
							// parse the text for Korean translation 
							language = "Korean";
							translated = translate.translateToKrn(text);
						}
						
						//Create stream to write data on the network
						DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
						
						//send current text back to the client
						outputStream.writeUTF(translated);
						
						// update and display the request status
						System.out.println("Data sent to the client: " + text + " is translated to " + language);
						System.out.println("Accepted connection to from the " + "client. Total request = " + ++totalRequest);
						
						text = "";
						language = "";
						
						
						// Close the socket
						clientSocket.close();
						
					}
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
	}
			
}
