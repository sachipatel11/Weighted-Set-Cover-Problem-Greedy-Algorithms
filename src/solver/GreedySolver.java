package solver;

import model.SCPModel;
import util.ElementSet;
import java.util.SortedSet;
import java.util.TreeSet;

/** This is the main method that all solvers inherit from.  It is important
 *  to note how this solver calls nextBestSet() polymorphically!  Subclasses
 *  should *not* override solver(), they need only override nextBestSet().
 * 
 *  We'll assume models are well-defined here and do not specify Exceptions
 *  to throw.
 * 
 * @author ssanner@mie.utoronto.ca
 *
 */
public abstract class GreedySolver {
	
	protected String _name;		// name of algorithm type
	protected double _alpha;          // minimum required coverage level in range [0,1]
	protected SCPModel _model;        // the SCP model we're currently operating on
	protected double _objFn;          // objective function value (*total cost sum* of all sets used)
	protected double _coverage;       // actual coverage fraction achieved
	protected long _compTime;         // computation time (ms)

	protected TreeSet<ElementSet> _solnSets; // could use array instead
	protected SortedSet<Integer> _elementsNotCovered; // set of the elements currently not covered by solution
	protected boolean _solved;        // whether or not the model has been solved
	
	// Basic setter (only one needed)
	public void setMinCoverage(double alpha) { _alpha = alpha; }
	public void setModel(SCPModel model) { _model = model; }
	
	// Basic getters
	public double getMinCoverage() { return _alpha; }
	public double getObjFn() { return _objFn; }
	public double getCoverage() { return _coverage; }
	public long getCompTime() { return _compTime; }
	public String getName() { return _name; }
		
	// TODO: Add any helper methods you need
        // adding in the constructor to initalize everything 
      
      public GreedySolver(){
          
      }
      public GreedySolver(String name){
          this._name=name;
          _model= new SCPModel();
          
          
      }
	public void reset() {
        // TODO: you need to compelte this method to reset the class
        _objFn = 0.0;
        _coverage = 0.0;
        _compTime = 0;
        _solnSets = new TreeSet <ElementSet>();
        _elementsNotCovered = (TreeSet<Integer>) _model.getUniverse();
	}
	
	/** Run the simple greedy heuristic -- add the next best set until either
	 *  (1) The coverage level is reached, or 
	 *  (2) There is no set that can increase the coverage.
	 */
	public void solve() {
		
		// Reset the solver
		reset();
		
		// TODO: Preliminary initializations
                
                        
		// Begin the greedy selection loop
		long start = System.currentTimeMillis();
		System.out.println("Running '" + getName() + "'...");

		// TODO: Fill in the main loop, pseudocode given below
		//
		// NOTE: In order to match the solution, pay attention to the following
		//       calculations (where you have to replace ALL-CAPS parts)
		//
		int num_to_cover = (int)Math.ceil(_alpha * _model.getNumOfElems()); 
		int num_can_leave_uncovered = _model.getNumOfElems() - num_to_cover; //#of elems in universe - what u have to cover
                //boolean _solved = false;
		//
		 while ( _elementsNotCovered.size() > num_can_leave_uncovered 
		        && !(_elementsNotCovered.isEmpty())){
                     ElementSet best = nextBestSet();
                     if (nextBestSet() == null){
                         break;
                        
                     }else{
                        
                        _solnSets.add(best);
                        _objFn += best.getCost();
                        _elementsNotCovered.removeAll(best.getElem());
                        System.out.println("- Selected: " + best.toString());
                        
                     }
                     
                 }
		//
		//      Call nextBestSet() to get the next best ElementSet to add (if there is one)
		// 		Update solution and local members
                // deletes the next best set and leaves remaining one
				
		// Record final set coverage, compTime and print warning if applicable
		_coverage = (_model.getNumOfElems()- _elementsNotCovered.size())/(double)(_model.getNumOfElems()); // TODO: Correct this, should be coverage of solution found
		_solved=true;
                _compTime = System.currentTimeMillis() - start;
		if (_coverage < _alpha)
			System.out.format("\nWARNING: Impossible to reach %.2f%% coverage level.\n", 100*_alpha);
		System.out.println("Done."); 
	}
	
	/** Returns the next best set to add to the solution according to the heuristic being used.
	 * 
	 *  NOTE 1: This is the **only** method to be implemented in child classes.
	 *  
	 *  NOTE 2: If no set can improve the solution, returns null to allow the greedy algorithm to terminate.
	 *  
	 *  NOTE 3: This references an ElementSet class which is a tuple of (Set ID, Cost, Integer elements to cover)
	 *          which you must define.
	 * 
	 * @return
	 */
	public abstract ElementSet nextBestSet(); // Abstract b/c it must be implemented by subclasses
	
	/** Print the solution
	 * 
	 */
	public void print() {
		System.out.println("\n'" + getName() + "' results:");
		System.out.format("'" + getName() + "'   Time to solve: %dms\n", _compTime);
		System.out.format("'" + getName() + "'   Objective function value: %.2f\n", _objFn);
		System.out.format("'" + getName() + "'   Coverage level: %.2f%% (%.2f%% minimum)\n", 100*_coverage, 100*_alpha);
		System.out.format("'" + getName() + "'   Number of sets selected: %d\n", _solnSets.size());
		System.out.format("'" + getName() + "'   Sets selected: ");
		for (ElementSet s : _solnSets) {
			System.out.print(s.getId() + " ");
		}
		System.out.println("\n");
	}
	
	/** Print the solution performance metrics as a row
	 * 
	 */
	public void printRowMetrics() {
		System.out.format("%-25s%12d%15.4f%17.2f\n", getName(), _compTime, _objFn, 100*_coverage);
	}	
}
