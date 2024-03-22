package bai7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class autoCreate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "mời bạn nhập a:"
        );
        int from = sc.nextInt();
        System.out.println(
                "mời bạn nhập b:"
        );
        int to = sc.nextInt();
        List<Integer> arrNumber = new ArrayList<>();
        IntStream.range(from, to +1)
                .forEach(arrNumber::add);
        System.out.println(arrNumber);
    }
}
