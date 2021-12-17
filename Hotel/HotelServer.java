
//server program
import java.rmi.*;
import java.net.*;

public class HotelServer {
    
    public static void main(String[] args) {
        try{
            RoomManagerImpl locobj =new RoomManagerImpl();
            Naming.rebind("rmi:///RoomManager", locobj);
        }catch(RemoteException re){
            re.printStackTrace();
        }catch(MalformedURLException mfe)
        {
            mfe.printStackTrace();
        }
    }
}
