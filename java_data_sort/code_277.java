import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Marqeta {

	public static void main(String[] args) throws Exception {
        
        String input = "The quick brown fox jumped over the lazy brown dog's back";
        String[] output = analyze(input);
        
                System.out.println("Result: "+ Arrays.toString(output));
        
    }
        public static String[] analyze(String s) {
        
        if(s == null || s.isEmpty()) return null;
        
        Map<String, Integer> map = getFreqMap(s);
        List<String> list = sortByLengthThenLexographicalOrder(map.keySet());
        
        String[] res = new String[map.size()];
        int i = 0;
        for(String key : list) {
        	res[i++] = map.get(key) + " " + key;
        }
        
        return res;
    }
    
    public static List<String> sortByLengthThenLexographicalOrder(Set<String> set) {
    	List<String> list = new ArrayList<>(set);
    	Collections.sort(list, new Comparator<String>() {
    		@Override
    		public int compare(String s1, String s2) {
    			if(s1.length() != s2.length()) {
    				return s1.length() - s2.length();
    			} else {
    				return s1.compareTo(s2);
    			}
    		}
    	});
    	
    	return list;
    }
    
    private static Map<String, Integer> getFreqMap(String s) {
       Map<String, Integer> map = new HashMap<>();
       String[] sArr = s.split(" ");
        for(String str : sArr) {
            if(!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str)+1);
            }
        }
        return map; 
    } 
}