//TCP Echo Server
//package tcpechoserver;

/**
 *
 * @author vasu
 */
import java.net.*;
import java.io.*;
public class TCPEchoServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        String clientSentence;
        String capSentence;
        ServerSocket WelcomeSoc= new ServerSocket(60001);
        System.out.println("Server Started");
        while (true){
            Socket ConSoc= WelcomeSoc.accept();
            BufferedReader inFromClient= new BufferedReader(new InputStreamReader(ConSoc.getInputStream()));
            DataOutputStream outToClient= new DataOutputStream(ConSoc.getOutputStream());
            System.out.println("Host-Server Connected");
            outToClient.writeBytes("You are Connected to Echo Server" + "\n");
            clientSentence= inFromClient.readLine();
            capSentence= clientSentence.toUpperCase();
            outToClient.writeBytes(capSentence + "\n");
        }
       
    }
   
}
