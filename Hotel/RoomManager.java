
//Define remote interface
import java.rmi.*;

public interface RoomManager extends Remote{

    public String list() throws RemoteException;

    public String book(int room_type, String guest_name) throws RemoteException;

    public String guests() throws RemoteException;

    public String revenue() throws RemoteException;
}