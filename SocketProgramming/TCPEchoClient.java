//TCP Client
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package tcpechoclient;

/**
 *
 */
import java.net.*;
import java.io.*;
public class TCPEchoClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        String Sentence;
        String modifiedSentence;
        BufferedReader inFromUser= new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket= new Socket("localhost",60001);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("From Server:" + inFromServer.readLine()+ "\n");
        Sentence= inFromUser.readLine();
        outToServer.writeBytes(Sentence + "\n");
        modifiedSentence= inFromServer.readLine();
        System.out.println("From Server:" + modifiedSentence);
        clientSocket.close();
       
       
       
    }
   
}
