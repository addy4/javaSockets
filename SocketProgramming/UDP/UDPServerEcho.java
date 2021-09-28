import java.io.*; import java.net.*;
/** *
*/
public class UDPServerEcho {
/**
* @param args the command line arguments */
public static void main(String[] args) throws Exception{ DatagramSocket serverSocket = new DatagramSocket(6000); byte[] receiveData= new byte[1024];
byte [] sendData= new byte[1024];
while (true)
{DatagramPacket receivePacket= new DatagramPacket(receiveData, receiveData.length); serverSocket.receive(receivePacket);
String Sentence= new String(receivePacket.getData());
InetAddress IPAddress= receivePacket.getAddress();
int Port = receivePacket.getPort();
String CapitalSentence =Sentence.toUpperCase();
sendData=CapitalSentence.getBytes();
DatagramPacket sendPacket= new DatagramPacket(sendData,sendData.length,IPAddress, Port); serverSocket.send(sendPacket);
}
} } 
