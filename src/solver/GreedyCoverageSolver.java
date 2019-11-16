package solver;

import util.ElementSet;


public class GreedyCoverageSolver extends GreedySolver {
// TODO: you need add any instance variable and method (including overriding methods)
    public GreedyCoverageSolver(){
        super("Coverage");
    }
    
    
    @Override 
    public ElementSet nextBestSet(){
     ElementSet bestSet = null;
     int count = 0 ;  
     
     int maxcount= Integer.MIN_VALUE; 
     for (ElementSet es: _model.getElementSetIterable()){ //for each element set in the treeset of element sets
       for(int e : es.getElementIterable()){ //for each element in the treeset of elements
           count = 0; 
           if (_elementsNotCovered.contains(e)){
               count++;  
           }
       }if (maxcount<count){
         maxcount=count;
         bestSet=es;  
        } 
     } 
     
    
    return bestSet;
}   
    
    
}


