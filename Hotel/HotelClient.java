//client program
import java.rmi.*;
import java.net.*;

public class HotelClient {
    

    public static void list_commands(){
        String commands;
        commands="The following commands can be used:\n";
        commands+="list <Server address>\n";
        commands+="book <server address> <room type> <guest name>\n";
        commands+="guests <server address>\n";
        commands+="revenue <server address>";
        System.out.println(commands);
        
    }

    public static void main(String[] args) {
        
        if(args.length<2)
        {
            list_commands();
            System.exit(0);
        }

        String host = args[1];
        String command = args[0];
       
        try{
            RoomManager remObj = (RoomManager)
            Naming.lookup("rmi://"+ host + "/RoomManager");

            switch(command){
                case "list":
                    System.out.println(remObj.list());
                break;
                case "book":
                    if(args.length<4)
                    {
                        list_commands();
                        System.exit(0);
                    }
                    int room_type = Integer.parseInt(args[2]);
                    String guest_name =args[3];
                    System.out.println(remObj.book(room_type, guest_name));
                break;

                case "guests":
                    System.out.println(remObj.guests());
                break;

                case "revenue":
                    System.out.println(remObj.revenue());
                break;

                default:
                    list_commands();

            }
           
           
        }catch(RemoteException re){
            re.printStackTrace();
        }catch(NotBoundException nbe){
            nbe.printStackTrace();
        }catch(MalformedURLException mfe){
            mfe.printStackTrace();
        }
    }


}
