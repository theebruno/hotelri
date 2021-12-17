
public class Room {
    //Eg. 0, 1, 2, 3 or 4
    public int RoomType;

    public int RoomPrice;
    
    /** Eg. Single Room, Double Room etc */
    public String RoomDescription;

    /** Stores the total/initial number of rooms */
    public int TotalRooms;

    /** This keeps track of the remaining number of rooms after each booking */
    public int AvailableRooms;

    /** This is a constructor method with paramters required to construct the hotel room */
    public Room(int room_type, int room_price, int total_rooms, String room_description, int available_rooms){
        //Assign values entered from the constructor to the room properties
        RoomType=room_type;
        RoomPrice=room_price;
        RoomDescription=room_description;
        TotalRooms=total_rooms;
        AvailableRooms=available_rooms;
    }   
}
