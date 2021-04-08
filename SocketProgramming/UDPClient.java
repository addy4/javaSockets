// Java program to illustrate Client side 
// Implementation using DatagramSocket 
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException; 
import java.util.Scanner;  
  
public class UDPClient 
{ 
    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in); 
  
        // Step 1:Create the socket object for 
        // carrying the data. 
        DatagramSocket ds = new DatagramSocket(1235); 
  
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
        DatagramPacket DpReceive = null; 
        // loop while user not enters "bye" 
        while (true) 
        { 
            String inp = sc.nextLine(); 
  
            // convert the String input into the byte array. 
            buf = inp.getBytes(); 
  
            // Step 2 : Create the datagramPacket for sending 
            // the data. 
            DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, ip, 1234); 
  
            // Step 3 : invoke the send call to actually send 
            // the data. 
            ds.send(DpSend); 
            byte[] receive = new byte[65535];
            DpReceive = new DatagramPacket(receive, receive.length); 
            ds.receive(DpReceive);  
            //String s = new String(recieve, StandardCharsets.UTF_8);
            System.out.println("Server:-" + data(receive));   
            // break the loop if user enters "bye" 
            if (inp.equals("end Chat")) 
                break; 
        } 
    }
    
    public static StringBuilder data(byte[] a) 
    { 
        if (a == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (a[i] != 0) 
        { 
            ret.append((char) a[i]); 
            i++; 
        } 
        return ret; 
    }

} 
