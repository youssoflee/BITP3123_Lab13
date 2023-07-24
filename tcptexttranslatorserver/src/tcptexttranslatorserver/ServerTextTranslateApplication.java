package tcptexttranslatorserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class launch the server side application using TCP.
 * The server will translate input English text from client server to target language selected.
 * Each connected client will receive the translated text from the server.
 * 
 * @author Youssof Lee
 *
 */
public class ServerTextTranslateApplication {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		// invoke method to create data for text translation
		TextForTranslated setup = new TextForTranslated();
		setup.createData();
		
		// create server socket object
		ServerSocket serverSocket = null;
		TextTranslator translate = new TextTranslator();
		
		ServerTextTranslateFrame frame = new ServerTextTranslateFrame();
		frame.setVisible(true);
		
		try
		{
			// Counter to keep track the number of requested connection
			int totalRequest = 0;
			
			// binding request to a port number, 2345
			int portNo = 2345;
			serverSocket = new ServerSocket(portNo);
			
			
			
			// 2. Listen continuously for request of connection
			// Server needs to be alive forever in unterminated while loop
			while(true)
			{
				// Message to indicate server is alive
				frame.updateServerStatus(false);
				
				// 3. Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				// update Connected status from server to client
				frame.updateServerStatus(clientSocket.isConnected());
				
				// Create input stream to read data on network
				DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
				
				// read the data
				String text = inputStream.readUTF();
				String language = inputStream.readUTF();
				String translated = "";
				
				// declare variable for determining which target language is selected
				String bm = "malay";
				String arb = "arab";
				String krn = "korean";
				
				// from client request
				// if target language is Malay
				if(language.equals(bm))
				{
					translated = translate.translateToBM(text);
				}
				
				// if target language is Arabic
				if(language.equals(arb))
				{
					translated = translate.translateToArb(text);
				}
				
				// if target language is Korean
				if(language.equals(krn))
				{
					translated = translate.translateToKrn(text);
				}
				

				//Create stream to write data on the network
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
				
				//send current text back to the client
				outputStream.writeUTF(translated);
				
				//clear the socket
				outputStream.flush();
				
				//close the socket
				outputStream.close();
				clientSocket.close();
				
				// update request status to the server frame
				frame.updateRequestStatus("Data sent to the client: " + text + " is translated to " + language);
				frame.updateRequestStatus("Accepted connection to from the " + "client. Total request = " + ++totalRequest);
				
				text = "";
				language = "";
			}
			
		}
		catch(IOException ioe)
		{
			if(serverSocket != null)
			{
				serverSocket.close();
			}
			
			ioe.printStackTrace();
		}

	}
}
