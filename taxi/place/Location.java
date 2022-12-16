package taxi.place;

import java.util.HashMap;

import lombok.AllArgsConstructor;

public class Location {
    private HashMap<String, Integer> location;
    
    public Location(HashMap<String, Integer> location) {
    	this.location = location;
    }

}