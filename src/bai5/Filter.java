package bai5;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    public static void main(String[] args) {


        // lọc ra số lớn hơn 1 và in

        // tạo mảng số nguyên gồm 100 số ngẫu nhiên nhỏ hơn 1000
        List<Integer> arrNumber = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrNumber.add((int) (Math.random() * 1000));
        }
        // lọc ra các số chẵn và chuyen vào mảng mới
        List<Integer> evanNumber = arrNumber.stream().filter(number -> number>1).toList();


        evanNumber.forEach(System.out::println);
    }
}
