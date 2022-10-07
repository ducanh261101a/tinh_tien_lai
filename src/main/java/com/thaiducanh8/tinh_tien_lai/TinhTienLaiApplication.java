package com.thaiducanh8.tinh_tien_lai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TinhTienLaiApplication {

    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        try {
            System.out.println("Nhap so tien can tinh");
            long money = number.nextLong();
            System.out.println("nhap thoi gian");
            int time = number.nextInt();
            System.out.println("nhap loai tien vay hay tien gui");
            boolean deposit_type = number.nextBoolean(); // true la gui tien, false la vay tien
            long response = tinh_tien_lai(money, time, deposit_type);
            System.out.println(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static long tinh_tien_lai(long money, int time, boolean deposit_type) throws Exception {
        if (money < 0 || money > 1000000000) {
            throw new Exception("so tien khong hop le");
        }
        if (time < 0 || time > 24) {
            throw new Exception("thoi gian khong hop le");
        }
        if (deposit_type) {
            if (time <= 3) {
                return (long) (money + money * 0.0034 * time);
            }
            if (time <= 6) {
                return (long) (money + money * 0.0042 * time);
            }
            if (time <= 12) {
                return (long) (money + money * 0.0056 * time);
            }
            if (time <= 24) {
                return (long) (money + money * 0.0062 * time);
            }
        } else {
            if (time <= 3) {
                return (long) (money + money * 0.003 * time);
            }
            if (time <= 6) {
                return (long) (money + money * 0.004 * time);
            }
            if (time <= 12) {
                return (long) (money + money * 0.005 * time);
            }
            return (long) (money + money * 0.006 * time);
        }
        return 0;
    }
}
