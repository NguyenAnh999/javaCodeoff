package bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class MaxNumber {
    public static void main(String[] args) {
        // tạo mảng số nguyên gồm 100 số ngẫu nhiên nhỏ hơn 1000
        List<Integer> arrNumber = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrNumber.add((int) (Math.random()*1000));
        }
        List<Integer> arrNumberRamdom = Stream.generate(()->new Random().nextInt(1000)).limit(100).sorted().toList();
        // biểu thức lambda

        System.out.println("số lớn nhất trong mảng là"+ arrNumber.stream().max((o1,o2)->o1-o2).orElse(0));

        // sử dụng method reference để tham chiếu tới từng phần tử của arrNumber

        System.out.println("số lớn nhất trong mảng là"+ arrNumber.stream().max(Integer::compareTo).orElse(0));

    }
}
