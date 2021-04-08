import java.io.*; import java.net.*; /**
*
* @author vasu */
public class UDPClientEcho {
/**
* @param args the command line arguments */
public static void main(String[] args) throws Exception {
BufferedReader inFromUser= new BufferedReader(new InputStreamReader(System.in)); DatagramSocket clientSocket= new DatagramSocket();
InetAddress IPAddress = InetAddress.getByName("localhost");
byte[] sendData = new byte[1024];
byte[] receiveData= new byte[1024];
String Sentence = inFromUser.readLine();
sendData = Sentence.getBytes();
DatagramPacket sendPacket= new DatagramPacket(sendData,sendData.length, IPAddress,
6000);
clientSocket.send(sendPacket);
DatagramPacket receivePacket= new DatagramPacket(receiveData,receiveData.length); clientSocket.receive(receivePacket);
String modifiedSentence= new String(receivePacket.getData()); System.out.println("From Server"+modifiedSentence);
clientSocket.close(); }
}

