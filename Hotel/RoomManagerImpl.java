//Implement the interface

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager {

    /** The code block below uses the Room class to construct Static Room objects which
     * maintain their internal state during the lifetime of the program
     */
    public static Room SingleRoom = new Room(0, 55000, 10, "Single Room", 10);
    public static Room DoubleRoom = new Room(1, 75000, 20, "Double Room", 20);
    public static Room TwinRoom = new Room(2, 80000, 5, "Twin Room", 5);
    public static Room TrippleRoom = new Room(3, 150000, 3, "Tripple Room", 3);
    public static Room QuadRoom = new Room(4, 230000, 2, "Quad Room", 2);

    /** To maintain the state of the guest list, we use a static property below */
    public static String GuestList;
    
    /* Stores the room type domain the user can input*/
    public int RoomTypeList[] ={0, 1, 2, 3, 4};



    public RoomManagerImpl() throws RemoteException {}

    /** Lists all available rooms and their respective prices */
    public String list() throws RemoteException {
        String result = SingleRoom.AvailableRooms + " room(s) of type "+ SingleRoom.RoomType + " are available for " + SingleRoom.RoomPrice + " UGX per night\n";
               result+= DoubleRoom.AvailableRooms + " room(s) of type "+ DoubleRoom.RoomType + " are available for " + DoubleRoom.RoomPrice + " UGX per night\n";
               result+= TwinRoom.AvailableRooms + " room(s) of type "+ TwinRoom.RoomType + " are available for " + TwinRoom.RoomPrice + " UGX per night\n";
               result+= TrippleRoom.AvailableRooms + " room(s) of type "+ TrippleRoom.RoomType + " are available for " + TrippleRoom.RoomPrice + " UGX per night\n";
               result+= QuadRoom.AvailableRooms + " room(s) of type "+ QuadRoom.RoomType + " are available for " + QuadRoom.RoomPrice + " UGX per night\n";

               return result;
    }

    public String book(int room_type, String guest_name) throws RemoteException {
        
        //check if room type exists
        for(int element : RoomTypeList){
            if(element==room_type)
            {
                switch(room_type)
                {
                    case 0:
                        SingleRoom.AvailableRooms--;
                    break;
                    case 1:
                        DoubleRoom.AvailableRooms--;
                    break;
                    case 2:
                        TwinRoom.AvailableRooms--;
                    break;
                    case 3:
                        TrippleRoom.AvailableRooms--;
                    break;
                    case 4:
                        QuadRoom.AvailableRooms--;
                    break;
                }

                add_guest(guest_name);
                return "Room type " + room_type + " booked successfully!";
            }
        }
        
        return "Invalid room type";
    }

    public String guests() throws RemoteException {
        String list="=============LIST OF GUESTS==========\n";
               list+=GuestList;
        return list;
    }

    public String revenue() throws RemoteException {
        String list="=============GENERATED REVENUE==========\n";
        int SingleRoomRevenue = (SingleRoom.TotalRooms-SingleRoom.AvailableRooms)*SingleRoom.RoomPrice;
        int DoubleRoomRevenue = (DoubleRoom.TotalRooms-DoubleRoom.AvailableRooms)*DoubleRoom.RoomPrice;
        int TwinRoomRevenue = (TwinRoom.TotalRooms-TwinRoom.AvailableRooms)*TwinRoom.RoomPrice;
        int TrippleRoomRevenue = (TrippleRoom.TotalRooms-TrippleRoom.AvailableRooms)*TrippleRoom.RoomPrice;
        int QuadRoomRevenue = (QuadRoom.TotalRooms-QuadRoom.AvailableRooms)*QuadRoom.RoomPrice;

        int total_revenue =(SingleRoomRevenue+DoubleRoomRevenue+TwinRoomRevenue+TrippleRoomRevenue+QuadRoomRevenue);

        list+=" Single Room Revenue (Type 0):  UGX. " + SingleRoomRevenue + "\n";
        list+=" Double Room Revenue (Type 1):  UGX. " + DoubleRoomRevenue + "\n";
        list+=" Twin Room Revenue (Type 2):    UGX. " + TwinRoomRevenue + "\n";
        list+=" Tripple Room Revenue (Type 3): UGX. " + TrippleRoomRevenue + "\n";
        list+=" Quad Room Revenue (Type 3):    UGX. " + QuadRoomRevenue + "\n";
        list+="TOTAL REVENUE: UGX. " + total_revenue;
        return list;
    }

    private void add_guest(String guest_name)
    {
        //Get the total guests n, and this will be the index of the new guest
        if(guest_name.length()>0){
            GuestList+=guest_name +"\n";
        }
       
    }

}
