package solver;

import java.util.SortedSet;

import util.ElementSet;

public class GreedyCostSolver extends GreedySolver {
// TODO: you need add any instance variable and method (including overriding methods)
    
    public GreedyCostSolver(){
        super("Cost");
    }
    
    
    @Override 
    public ElementSet nextBestSet(){
        ElementSet bestSet = null;
        int count = 0;

        
        
       double lowCost= Double.MAX_VALUE;
       for (ElementSet es: _model.getElementSetIterable()){ //for each element set in the treeset of element sets
           count=0; 
        for(int e : es.getElementIterable()){ //for each element in the treeset of elements
            
           if (_elementsNotCovered.contains(e)){
               count ++; 
           }
       }
        //cost=es.getCost();
        if (count > 0 && es.getCost()<lowCost){
            lowCost=es.getCost();
            bestSet=es;
        } 
        
       }return bestSet;
    
    
} 
}