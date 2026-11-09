/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class Validation {

    private final Scanner sc = new Scanner(System.in);
    // Nhập chuỗi không rỗng

    public String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Không được để trống!");
        }
    }

    // Nhập số nguyên trong khoảng [min, max]
    public int getInt(String msg, int min, int max) {
        while (true) {
            String s = getString(msg);
            try {
                int n = Integer.parseInt(s);
                if (n >= min && n <= max) {
                    return n;
                }
                System.out.println("Input must be from " + min + " - " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public int getBirthDate(String msg) {
        return getInt(msg, 1900, Year.now().getValue());
    }

    public String getPhone(String msg) {
        while (true) {
            String phone = getString(msg);
            if (phone.matches("\\d{10,}")) {
                return phone;
            }
            System.out.println("Phone must be number and minimum 10 number !");
        }
    }

    public String getEmail(String msg) {
        while (true) {
            String s = getString(msg);
            if (s.matches("^[A-Za-z0-9._]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")) {
                return s;
            }
            System.out.println("Invalid format for email");
        }
    }

    public String getRank(String msg) {
        String[] ranks = {"Excellence", "Good", "Fair", "Poor"};
        while (true) {
            String s = getString(msg);
            for (String r : ranks) {
                if (r.equalsIgnoreCase(s)) {
                    return r;
                }
            }
            System.out.println("Rank should be Excellence, Good, Fair, Poor");
        }
    }
    
    public boolean getYesNo(String msg){
        while (true) {            
            String s = getString(msg);
            if(s.equalsIgnoreCase("Y"))
            {
                return true;
            }
            if(s.equalsIgnoreCase("N")){
                return false;                                         
            }
            System.out.println("Invalid input!");
        }
}
}