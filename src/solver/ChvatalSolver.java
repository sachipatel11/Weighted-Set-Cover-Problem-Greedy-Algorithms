package solver;

import util.ElementSet;

public class ChvatalSolver extends GreedySolver {
// TODO: you need add any instance variable and method (including overriding methods)
    public ChvatalSolver(){
        super("Chvatal");
    }
    
    
    @Override 
    public ElementSet nextBestSet(){ 
        ElementSet bestSet = null;  
        
        double currentCostCovRatio=0.0;  
        double bestCCR = Double.POSITIVE_INFINITY;  
        int elementsCovered=0; 
        
        for (ElementSet es: _model.getElementSetIterable()){
            
            currentCostCovRatio= es.getCost()/es.countElementsCovered(_elementsNotCovered);
            if(currentCostCovRatio < bestCCR){
                bestSet = es;
                bestCCR = currentCostCovRatio;
            }
            }
            return bestSet;
        } 
    
    

}
