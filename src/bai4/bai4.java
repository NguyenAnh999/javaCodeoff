package bai4;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class bai4 {
    public static void main(String[] args) {

        List<String> strArr = Arrays.asList("a","b","c","h","d","z","n","m","c","r","y","t","i","p","o","l");
        List<String> strArrSort = strArr.stream().sorted().toList();
  //      List<String> strArrSort = strArr.stream().sorted(Comparator.naturalOrder()).toList();

        System.out.println(strArrSort);
        System.out.println( strArr.stream().sorted().toList());
    }
}

