import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
        Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
        Room oxford = new Room("Oxford", "Suite", 5, 225.0);
        Room oxford1 = new Room("Oxford", "Guest Room", 5, 225.0);
        Room victoria = new Room("Victoria", "Suite", 5, 225.0);

        List<Room> rooms = new ArrayList<>(List.of(piccadilly, oxford1, cambridge, victoria, oxford));
        rooms.sort(Room.RATE_COMPARATOR);



        /*
         we can invoke the binary search method. And you'll notice that there's two of them.
         The first, we'll use the natural sort order of the
         collection in order to perform the search. The other one will accept a comparator
         */
        //Returns integer that denotes the index where the object is found.
       //int result =  Collections.binarySearch(rooms, cambridge, Room.RATE_COMPARATOR);
        //Print to the console
        //System.out.println("Result: " + result );

        //Adding new room.
        Room newLondon = new Room("New London", "Suite", 5, 255.0);
        //do binary search(result = negative = obj not found, known as insertion point
        //-3 Indicates where the new room will be inserted.
        int result = Collections.binarySearch(rooms, newLondon, Room.RATE_COMPARATOR);
        //insert Oxford into the rooms list.Use overlaoded add method that accepts position
        //Get the absolute and increment by one
        rooms.add(Math.abs(++result), newLondon);
        System.out.println("Result: " + result);

        //MIN AND MAX VALUE METHODS.
        //will get the min value determine by rate comparator
        System.out.println("Min: " + Collections.min(rooms, Room.RATE_COMPARATOR).getName());
        //Max similar 
        System.out.println("Max: " + Collections.max(rooms, Room.RATE_COMPARATOR).getName());

        System.out.format("%n%n--List Contents--%n");
        rooms.stream()
                .forEach(r -> System.out.format("%-15s %-15s %-10f %n", r.getName(), r.getType(), r.getRate()));
    }

}
