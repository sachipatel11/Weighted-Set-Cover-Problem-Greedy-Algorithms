 package util;

import java.lang.Comparable;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class ElementSet implements Comparable {

    // TODO: you need to add more instance variables to make this work
    // TODO: you also need to add additional public method according to the test class
    protected int _id;
    protected double _cost;
    protected Collection <Integer> _elements;
    protected TreeSet <Integer> _t;
    


    public ElementSet(int id, double cost, Collection<Integer> elements) {
        //TODO: complete this constructor and set instance variable to correct values
        _id=id;
        _cost=cost;
        _elements = elements; //this 
    
        
    }
    
    public ElementSet(){
        _id=0;
        _cost=0.0;
        TreeSet <Integer> e = new TreeSet();
    }
    
    public TreeSet<Integer> getElem (){
        TreeSet <Integer> t = new TreeSet();
        
        for (Integer e : _elements){
            t.add(e);
        }
        return t;
        
    }

    
    public int getId() {
        //TODO: complete getId method to return the id of the element set
        // RETURN -1 is not correct. you need to fix this.
        return this._id; // do we need this
    }

    
    public double getCost() {
        //TODO: complete getCost method to return the cost of this ElementSet
        // RETURN -1 is not correct. you need to fix this.
        return this._cost;
    }


    // TODO: Count the element covered by the set. 
    public int countElementsCovered(Set<Integer> elements_to_cover) {
        // TODO: Count the element covered by the set. 
        // Return -1 is not correct. you need to fix this. 
        int count =0;
        for (Integer elem : elements_to_cover){
            if (_elements.contains(elem)){
            count += 1;
            }
        }return count;
        
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
        return new TreeSet <Integer>(_elements);
        
    }

    
    @Override
    public String toString() {
        //TODO: override the toString methods
        // return empty string is not correct, you need to fix this. 
        StringBuilder sb = new StringBuilder ();
        sb.append(String.format("Set ID: %3d   Cost: %6.2f   Element IDs: %s", _id, _cost, _elements));
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        //TODO: override the compareTo methods
        // Return -1 is not correct. you need to fix this.
        if (o instanceof ElementSet){
            ElementSet e = (ElementSet)o;
            if (this._id < e._id){
                return -1; 
            }
            else if (this._id == e._id){
                return 0;
            }
            else if (this._id > e._id){
                return 1;
            }
        } 
        return -1;
        
    }

    @Override
    public boolean equals(Object o) {
        //TODO: override the equal methods
        // Return false is not correct. you need to fix this.
        if (o instanceof ElementSet){
            ElementSet e = (ElementSet)o;
            
        }
        return false;
    }
}
