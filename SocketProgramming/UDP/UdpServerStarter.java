import java.net.SocketException;

public final class UdpServerStarter {

    public static void main(String[] args){
          try{
                UdpServer udpServer = new UdpServer();
                udpServer.start();
          }
          catch(SocketException e){
                e.printStackTrace();
          }
    }
} 
