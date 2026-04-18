import java.util.ArrayList;
import java.util.HashSet;


public class Thing {
    String label;
	public final ArrayList<Thing> things;
    
	
	public Thing(String label){
		this.label = label;
		things = new ArrayList<Thing>();
	}
	
		public void addReachableNode(Thing aThing){
		things.add(aThing);
	}
	
    
    
        public Thing deepCopy() {
                return deepCopyHelper(new HashSet<Thing>());
    }
        private Thing deepCopyHelper(HashSet<Thing> set) {
        set.add(this);                  			        Thing newThing = new Thing(this.label);   	                for (Thing aThing: things){
            if (!set.contains(aThing)){       					                Thing childThing = aThing.deepCopyHelper(set);                  newThing.things.add(childThing);                            }
        }
        return newThing;
    }
    
        public void dfs_label(){
    	dfs_label(new HashSet<Thing>());
    }
    public void dfs_label(HashSet<Thing> set){
    	set.add(this);
    	System.out.print(label + " ");
    	for (Thing aThing: things)
    		if (!set.contains(aThing))
    			aThing.dfs_label(set);
    }
    
        public void dfs_ref(){
    	dfs_ref(new HashSet<Thing>());
    }
    public void dfs_ref(HashSet<Thing> set){
    	set.add(this);
    	System.out.print(this + " ");
    	for (Thing aThing: things)
    		if (!set.contains(aThing))
    			aThing.dfs_ref(set);
    }
    public static void main(String[] args) {
 

    	Thing thingA = new Thing("A");
    	Thing thingB = new Thing("B");
    	Thing thingC = new Thing("C");
    	Thing thingD = new Thing("D");
    	Thing thingE = new Thing("E");
    	Thing thingF = new Thing("F");
    	Thing thingG = new Thing("G");
    	Thing thingH = new Thing("H");
    	
    	thingA.addReachableNode(thingB);	    	thingB.addReachableNode(thingC);	    	thingC.addReachableNode(thingD);	    	thingD.addReachableNode(thingA);	    	thingB.addReachableNode(thingE);	    	thingE.addReachableNode(thingF);	    	thingF.addReachableNode(thingC);	    	thingF.addReachableNode(thingG);	    	thingE.addReachableNode(thingH);	    	
    	
    	System.out.println("thingA labels:");
    	thingA.dfs_label();
    	System.out.println();
    	
    	System.out.println("deep-copied thingA labels:");
    	Thing thingACopied = thingA.deepCopy();
    	thingACopied.dfs_label();
    	System.out.println();
    	
    	System.out.println("thingA references:");
    	thingA.dfs_ref();
    	System.out.println();
    	
    	System.out.println("deep-copied thingA references:");
    	thingACopied = thingA.deepCopy();
    	thingACopied.dfs_ref();
    }
}