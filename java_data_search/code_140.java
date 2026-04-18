package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Collections;

public class 문서검색 {
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String want = br.readLine();

        search(0, want.length(), want, line);

        System.out.print(ans);
    }
    public static void search(int index, int wantIndex, String want, String line){
        if(wantIndex>line.length() || index>line.length()) return;

        if(line.substring(index, wantIndex).equals(want)){             ans++;
            index +=want.length();
            wantIndex +=want.length();             search(index, wantIndex, want, line);         }else{             index++;
            wantIndex++;
            search(index, wantIndex, want, line);
        }
    }
}