/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messaging;

import java.io.*;
import java.net.*;
/**
 *
 * @author Conor
 */
public class TCPHandler {
    
    public void sendTCPMessage(String sentence,String modifiedSentence)throws IOException{

BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
Socket clientSocket = new Socket("tcp://iot.eclipse.org", 1883);
DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
sentence = inFromUser.readLine();
outToServer.writeBytes(sentence + '\n');
modifiedSentence = inFromServer.readLine();
System.out.println("FROM SERVER: " + modifiedSentence);
clientSocket.close();
}
    
    public static String readTCPMessage(){
        
        return "";
    }
    }
    
