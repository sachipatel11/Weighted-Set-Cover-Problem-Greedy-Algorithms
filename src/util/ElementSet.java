package util;

import java.lang.Comparable;
import java.util.Collection;
import java.util.Set;

public class ElementSet implements Comparable {

    // TODO: you need to add more instance variables to make this work
    // TODO: you also need to add additional public method according to the test class


    public ElementSet(int id, double cost, Collection<Integer> elements) {
        //TODO: complete this constructor and set instance variable to correct values
    }

    
    public int getId() {
        //TODO: complete getId method to return the id of the element set
        // RETURN -1 is not correct. you need to fix this.
        return -1;
    }

    
    public double getCost() {
        //TODO: complete getCost method to return the cost of this ElementSet
        // RETURN -1 is not correct. you need to fix this.
        return -1;
    }


    // TODO: Count the element covered by the set. 
    public int countElementsCovered(Set<Integer> elements_to_cover) {
        // TODO: Count the element covered by the set. 
        // Return -1 is not correct. you need to fix this. 
        return -1;
    }

    
    public Iterable<Integer> getElementIterable() {
        //TODO: 
        // With the following method, we can write
        //   for (Integer i : getElementIteratable()) {
        //      do something with i;
        //   }
        // so that we can iterate through the Integer elements in
        // this class without having any further ability to modify
        // the underlying instance.

        // Return null is not correct; you need to fix this. 
        return null;
    }

    @Override
    public String toString() {
        //TODO: override the toString methods
        // return empty string is not correct, you need to fix this. 
        return "";
    }

    @Override
    public int compareTo(Object o) {
        //TODO: override the compareTo methods
        // Return -1 is not correct. you need to fix this. 
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        //TODO: override the equal methods
        // Return false is not correct. you need to fix this. 
        return false;
    }
}
