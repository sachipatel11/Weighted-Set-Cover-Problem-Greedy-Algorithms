package model;

import java.util.*;

import util.ElementSet;

// Holds all SCP model data
public class SCPModel {

    // TODO: you need to add more instance variable to make this class work
    // TODO: You need to create more method to complelte the expected functionality in the test clas

    public SCPModel() {
        // TODO: initialize instance variable correctly. 
    }

    public void addSetToCover(int id, double cost, Collection<Integer> elements) {
        // TODO: complete this method;
    }

    public Iterable<ElementSet> getElementSetIterable() {
        // TODO: complete this method
        // return null is not correct; you need to fix this. 
    
        // With the following method, we can write
        //   for (ElementSet e : getElementSetIterable()) {
        //      do something with e;
        //   }
        // so that we can iterate through the ElementSets in this
        // class without having any further ability to modify the
        // underlying instance.
        return  null;
    }

    // print out model details
    @Override
    public String toString() {
        // TODO: complete this to string method
        // returning empty string is not the correct behavior; you neeed to fix this. 
        return "";

    }
}
