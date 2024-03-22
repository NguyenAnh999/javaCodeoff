package bai6;

import java.util.Arrays;
import java.util.List;

public class ToUpPercase {
    public static void main(String[] args) {
        List<String> strArr = Arrays.asList("a","b","c","h","d","z","n","m","c","r","y","t","i","p","o","l");
        System.out.println(strArr.stream().map(String::toUpperCase).toList());
    }
}
