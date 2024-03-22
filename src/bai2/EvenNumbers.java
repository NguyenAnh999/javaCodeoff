package bai2;

import java.util.ArrayList;
import java.util.List;

public class EvenNumbers {
    public static void main(String[] args) {

    // tạo mảng số nguyên gồm 100 số ngẫu nhiên nhỏ hơn 1000
    List<Integer> arrNumber = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
        arrNumber.add((int) (Math.random()*1000));
    }
        // lọc ra các số chẵn và chuyen vào mảng mới
        List<Integer> evanNumber = arrNumber.stream().filter(number->number%2==0).toList();
        System.out.println(evanNumber);
    }
}
