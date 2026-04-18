import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Pool {

    final static int FROM = 0;
    final static int TO = 1;
        final static int n = 600;      final static int n_stands = 50;     final static int MAX_IN_POOL = 4;      final static int MAX_WAIT_TIME = 3;     final static double max_loss = 1.01;     
    static int [][]cost  = new int[n_stands][n_stands];
    static int [][]demand= new int[n][2];     static int []pickup  = new int[MAX_IN_POOL];     static int []dropoff = new int[MAX_IN_POOL];     static int numb_cust = n;     static int count = 0;
    static int count_all = 0;
    static List<PoolEl> poolList = new ArrayList<PoolEl>();

    static void drop_customers(int level) {
        if (level == MAX_IN_POOL) {             count_all++;
            boolean happy = true;
            for (int d=0; d<MAX_IN_POOL; d++) {                 int pool_cost=0;
                                for (int ph=dropoff[d]; ph<MAX_IN_POOL-1; ph++)
                    pool_cost += cost[demand[pickup[ph]][FROM]][demand[pickup[ph+1]][FROM]];
                                pool_cost += cost[demand[pickup[MAX_IN_POOL-1]][FROM]][demand[pickup[dropoff[0]]][TO]];
                                for (int ph=0; ph<d; ph++)
                    pool_cost += cost[demand[pickup[dropoff[ph]]][TO]][demand[pickup[dropoff[ph+1]]][TO]];
                if (pool_cost >  cost[demand[pickup[dropoff[d]]][FROM]][demand[pickup[dropoff[d]]][TO]]*max_loss) {
                    happy = false;                     break;
                }
            }
            if (happy) {
                                PoolEl pool = new PoolEl();
                pool.cust = new int[MAX_IN_POOL + MAX_IN_POOL];

                for (int i=0; i<MAX_IN_POOL; i++) {
                    pool.cust[i] = pickup[i];
                    pool.cust[i+MAX_IN_POOL] = pickup[dropoff[i]];
                }
                int pool_cost = 0;
                for (int i=0; i<MAX_IN_POOL -1; i++)                     pool_cost += cost[demand[pickup[i]][FROM]][demand[pickup[i+1]][FROM]];
                pool_cost += cost[demand[pickup[MAX_IN_POOL-1]][FROM]][demand[pickup[dropoff[0]]][TO]];                 for (int i=0; i<MAX_IN_POOL -1; i++)                     pool_cost += cost[demand[pickup[dropoff[i]]][TO]][demand[pickup[dropoff[i+1]]][TO]];
                                pool.cost = pool_cost;
                poolList.add(pool);
                count++;
                if (count % 1000 == 0)
                    System.out.print(count + ", ");
            }
        } else for (int c=0; c<MAX_IN_POOL; c++) { 
                        boolean found = false;
            for (int l=0; l<level; l++) {
               if (dropoff[l] == c) {
                   found = true;
                   break;
               } 
            }
            if (found) continue;             dropoff[level] = c;
                        drop_customers(level+1);
        }
    }
    
    static void poolv2(int level) {         if (level == MAX_IN_POOL) {                         drop_customers(0);
        } else for (int c=0; c < numb_cust; c++) {
                        boolean found=false;
            for (int l=0; l<level; l++) {
               if (pickup[l] == c) {
                   found = true;
                   break;
               }; 
            }
            if (found) continue;             pickup[level] = c;
                        int p_cost = 0;
            for (int l = 0; l < level; l++) 
                p_cost += cost[demand[pickup[l]][FROM]][demand[pickup[l+1]][FROM]];
            if (p_cost > MAX_WAIT_TIME)
                continue;
                        poolv2(level+1);
        }
    }
 
    public static void main(String[] args) {
        for (int i=0; i<n_stands; i++)
            for (int j=i; j<n_stands; j++) {
                cost[j][i] = j-i;                 cost[i][j] = cost[j][i] ;
            }

        for (int i=0; i<numb_cust; i++) {
            demand[i][FROM] = ThreadLocalRandom.current().nextInt(0, n_stands); 
            demand[i][TO] = ThreadLocalRandom.current().nextInt(0, n_stands);
        }
                int length = numb_cust;         int i=0;
        while (i<length)
            if (demand[i][0]==demand[i][1]) {
                if (demand[i][0] == 0) {
                    demand[i][0] = 1;
                }
                else {
                    demand[i][0]--;
                }
            }
            else i++;
    
   
                        System.out.println("numb_cust: " +  numb_cust);
                poolv2(0);
                PoolEl[] arr = poolList.toArray(new PoolEl[poolList.size()]);
        Arrays.sort(arr);
                for (i = 0; i<arr.length; i++) {
            if (arr[i].cost == -1) continue;
            for (int j = i+1; j < arr.length; j++)
                if (arr[j].cost != -1) {                     boolean found = false;
                    for (int x=0; x<MAX_IN_POOL; x++) {
                        for (int y=0; y<MAX_IN_POOL; y++)
                            if (arr[j].cust[x] == arr[i].cust[y]) {   
                                found = true; 
                                break;
                            } 
                        if (found) break;
                    }
                    if (found) arr[j].cost = -1;                 }
        }
        int good_count=0;
        for (i=0; i<arr.length; i++) 
            if (arr[i].cost != -1) { 
                good_count++;
            }
        System.out.println("Not duplicated count2: " + good_count);
    }

    private static class PoolEl implements Comparable<PoolEl> {
	    public int [] cust;
	    public int cost;
	 
	    PoolEl () {}
	    
	    @Override
	    public int compareTo(PoolEl pool) {
	        return this.cost - pool.cost;
	    }
	}
}