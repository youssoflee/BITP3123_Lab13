package tcptexttranslatorclient;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/** 
 * This client class will send request to server for text translation
 * by typing English text input.
 * The client will manage connection to server.
 * 
 * @author Youssof Lee
 */
public class ClientTextTranslateApplication {

	// declare static variable for client front-end GUI
	public static ClientTextTranslateFrame client = new ClientTextTranslateFrame();
	
	public static void main(String[] args) 
	{	
		
		client.setVisible(true);
	}
	
	// this method will send the request based on english text input to the client
	static public void btnPressed()
	{
		try
		{	
			// 1. Connect to the server / remote machine @ localhost, port 2345
			Socket socket = new Socket(InetAddress.getLocalHost(), 2345);
			
			// Update the status of the connection
			client.updateConnectionStatus(socket.isConnected());
			
			// 2. Send request to server, request is made by default
			// 3. Accept response from the server - read from network
			// Read from network
			DataInputStream datainputstream = new DataInputStream(socket.getInputStream());
			
			// Obtain input from the client front-end
			String textinput = client.getText();
			String language = client.getLanguage();
			
			// create stream to write data on network
			DataOutputStream dataoutputStream = new DataOutputStream(socket.getOutputStream());
			
			// if client press the button from front end for translation based on taret language
			if(client.ispressed() == true)
			{
				// write the data
				dataoutputStream.writeUTF(textinput);
				dataoutputStream.writeUTF(language);
				
				// read the translated text data
				String translated = datainputstream.readUTF();
				
				// parse back to front-end
				client.setAnsLbl(translated);
				client.updatebtn(false);
			}
			
			// clear the stream
			dataoutputStream.flush();
			
			// close the stream
			datainputstream.close();
			dataoutputStream.close();
			socket.close();
			
			textinput = "";
			language = "";
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		} 
	}
}
