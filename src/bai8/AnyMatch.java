package bai8;

import java.util.ArrayList;
import java.util.List;

public class AnyMatch {
    public static void main(String[] args) {


        // tạo mảng số nguyên gồm 100 số ngẫu nhiên nhỏ hơn 1000
        List<Integer> arrNumber = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrNumber.add((int) (Math.random() * 1000));
        }
        System.out.println(arrNumber.stream().anyMatch(num->num%2==0));
        arrNumber.stream().filter(num->num%2==0).findFirst().orElseThrow(() -> new RuntimeException("errorrrr ..."));
    }
}
