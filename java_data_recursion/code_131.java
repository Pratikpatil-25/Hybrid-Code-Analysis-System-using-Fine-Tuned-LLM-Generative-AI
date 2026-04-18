package recursion_1;

import java.util.*;


public class ChangePi {
  public String changePi(String str) {
    if (str.isEmpty()) return str;
    else if (str.startsWith("pi")) return "3.14" + changePi(str.substring(2));
    else return str.substring(0, 1) + changePi(str.substring(1));
  }
}