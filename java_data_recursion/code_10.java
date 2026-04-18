import java.io.*;
import java.util.*;

class Main {
    static void recursion(int lo, int hi, List<Integer> array, StringBuilder output) {
        if (lo > hi) {
            return;
        }
        int mid = (lo + hi + 1) / 2; 
        output.append(array.get(mid)).append('\n');
        recursion(mid + 1, hi, array, output); 
        recursion(lo, mid - 1, array, output); 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> array = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            array.add(Integer.parseInt(line.trim()));
        }

        StringBuilder output = new StringBuilder();
        recursion(0, array.size() - 1, array, output);
        System.out.print(output.toString());
    }
}