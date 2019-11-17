package model;

import java.util.*;

import util.ElementSet;
import java.util.TreeSet;

// Holds all SCP model data
public class SCPModel {

    // TODO: add any instance variables needed to make this class work as expected
    // TODO: add any methods needed to complelte the expected functionality
    public TreeSet <ElementSet> _model;
    
    private TreeSet <Integer> _universe;
    
    
    public SCPModel() {
        // TODO: initialize instance variables correctly. 
        _model = new TreeSet<ElementSet>();
        _universe = new TreeSet <>();
    }

    public void addSetToCover(int id, double cost, Collection<Integer> elements) {
        // TODO: complete this method;
        ElementSet set1 = new ElementSet(id,cost,elements);
        _model.add(set1); 
        _universe.addAll(elements);
    }
    public int getNumOfElems (){
    
       return _universe.size();
        
    }

    public Iterable<ElementSet> getElementSetIterable() {
        // TODO: complete this method

        return new TreeSet <ElementSet>(_model);  // return null is not the correct behaviour; you need to fix this. 
    }
    
    public Iterable<Integer> getUniverse (){
        return new TreeSet <Integer>(_universe);
        
    }
    

    // print out model details
    @Override
    public String toString() {
        // TODO: complete this to string method
        StringBuilder sb = new StringBuilder ();
        sb.append("Weighted SCP model:\n");
        sb.append("---------------------");
        sb.append("\nNumber of elements (n): "+ this.getNumOfElems() + "\n");
        sb.append("Number of sets (m): " + this._model.size() +"\n\n" );
        sb.append("Set details:\n");
        sb.append("----------------------------------------------------------\n");
        
        for (ElementSet e: this.getElementSetIterable()){ //for each element set in model
            sb.append(e+ "\n");

        }
        return sb.toString(); // returning empty string is not the correct behavior; you neeed to fix this. 

    }
}
