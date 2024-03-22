package bài3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Sum {
    public static void main(String[] args) {
        // tạo mảng số nguyên gồm 100 số ngẫu nhiên nhỏ hơn 1000
        List<Integer> arrNumber = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrNumber.add((int) (Math.random()*1000));
        }
        // sử dụng ham sum có sãn: bằng cách chuyển kiểu dữ liệu từ stream về int ta có thể gọi vào phương thức sum()
        System.out.println(
                "tổng của các số trong mảng là: "+ arrNumber.stream().mapToInt(Integer::intValue).sum()
        );
        // reduce và biêu  thức lambda
        System.out.println( "tổng của các số trong mảng là: "+  arrNumber.stream().reduce(0,(a,b)->a+b));

        //reduce và method referent
        System.out.println( "tổng của các số trong mảng là: "+  arrNumber.stream().reduce(0, Integer::sum));

    }
}
