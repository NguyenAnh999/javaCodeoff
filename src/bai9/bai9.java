package bai9;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Locale;

public class bai9 {
    public static void main(String[] args) {

// lấy ngày
        LocalDate dateNow = LocalDate.now();
        String dateFormat = dateNow.format(DateTimeFormatter.ISO_DATE);
        System.out.println("ngày hiện tại của hệ thông là" + dateFormat);
        System.out.println(dateNow);

        LocalDate asiaTokyoDateNow = LocalDate.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(asiaTokyoDateNow);
        LocalDate asiaTokyoDateNow1 = LocalDate.now(ZoneId.of("Australia/Sydney"));
        System.out.println(asiaTokyoDateNow1);

// lấy thời gian

        LocalTime timeNow = LocalTime.now();
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatTime = timeNow.format(time);
        System.out.println("giờ hiện tại của hệ thông là" + formatTime);
        System.out.println(formatTime);
        // tính ngày
        String userDate = "1999-06-05";
        LocalDate localDate = LocalDate.parse(userDate);
           long dayOf = Duration.between(localDate. atStartOfDay(),dateNow.atStartOfDay()).toDays();
           long dayOf2 = ChronoUnit.DAYS.between(localDate, dateNow);
        System.out.println(dayOf2);
        // tinh so ngay trong thang hien tai
       Calendar cal = Calendar.getInstance();
       int dayOfMonth = cal.getMaximum(Calendar.DAY_OF_MONTH);

        System.out.println(dayOfMonth);
        int month = Year.now().length();
        System.out.println(month);
// chuyển localDate qua String
        LocalDate localDate1 =  LocalDate.of(2023,9,5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formaString = localDate1.format(formatter);
        System.out.println(formaString);

        String paser = localDate1.toString();
        System.out.println(paser);
// chuyển đối tượng date time qua chuoi ngay
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
        String a= localDateTime.format(formatter2);
        System.out.println(a);

        // so sánh ngày trả về int
        int lengtdDay = (int)(ChronoUnit.DAYS.between(LocalDate.now(),LocalDate.parse("2025-05-06")));
        System.out.println(lengtdDay);

        //so sanh thoi gian
        long lengtTime =  ChronoUnit.SECONDS.between(LocalTime.parse("12:30:20"),LocalTime.parse("12:30:59"));
        System.out.println(lengtTime);

        //them  ngay gio phút giay
        LocalDateTime updatedTime;
        LocalDateTime now = LocalDateTime.now();

        updatedTime = now.plusHours(2);
        updatedTime = now.plusMinutes(20);
        updatedTime = now.plusSeconds(300);
        updatedTime = now.plus(Duration.ofMillis(8000));
        updatedTime = now.plus(20, ChronoUnit.HOURS);
// bot ngay gio phút giay
        updatedTime = now.minusHours(2);
        updatedTime = now.minusMinutes(20);
        updatedTime = now.minusSeconds(300);
        updatedTime = now.minus(Duration.ofMillis(8000));
        updatedTime = now.minus(20, ChronoUnit.HOURS);
        //
        //tính ngày tiếp theo
        updatedTime = now.plusHours(1);// thêm 1 ngày
        updatedTime = now.minusHours(1);// bớt 1 ngày
    }
}
