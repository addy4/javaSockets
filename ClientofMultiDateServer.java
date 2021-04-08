import java.io.*;
import java.net.*;
/**
*
* @author vasu
*/
public class ClientofMultiDateServer {
/**
* @param args the command line arguments
*/
public static void main(String args[]) throws Exception
{
Socket soc=new Socket(InetAddress.getLocalHost(),19999);
BufferedReader in=new BufferedReader(
new InputStreamReader(

soc.getInputStream()
)
);
System.out.println(in.readLine());
System.out.println(in.readLine());
}
}