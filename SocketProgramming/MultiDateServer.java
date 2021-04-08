import java.net.*;
import java.io.*;
import java.util.*;
import java.text.* ; 
/**
*
* @author vasu
*/
public class MultiDateServer implements Runnable {
/**
* @param args the command line arguments
*/
private Socket connection;
private String TimeStamp;
private int ID;
public static void main(String[] args) {
int port = 19999;
int count = 0;
try{
ServerSocket socket1 = new ServerSocket(port);
System.out.println("MultiDateServer Initialized");
while (true) {
Socket connection = socket1.accept();
Runnable runnable = new MultiDateServer(connection, ++count);
Thread thread = new Thread(runnable);
thread.start();
}
}
catch (Exception e) {}
}
MultiDateServer(Socket s, int i) {
this.connection = s;
this.ID = i;
}
@Override
public void run() {
try {
Date date = new Date();
DateFormat gmtFormat = new SimpleDateFormat(); 
TimeZone gmtTime = TimeZone.getTimeZone("GMT"); 
gmtFormat.setTimeZone(gmtTime);
DataOutputStream out=new DataOutputStream(connection.getOutputStream());
out.writeBytes("Server Date " + (new Date()).toString() + " GMT Time = " + gmtFormat.format(date) + "\n");

System.out.println("Client ID " + this.ID + " Connected");
try {
Thread.sleep(10000);
}
catch (Exception e){}
//System.out.println("Have a Nice day C");
out.writeBytes("Server : " + "Have a Nice day " + "\n");
out.close();
connection.close();
}

catch (Exception e) {
System.out.println(e);
}
}
}