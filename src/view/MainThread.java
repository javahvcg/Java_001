/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Customer;
import entity.DateTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author anhquan12
 */
public class MainThread {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter information customer :" + (i + 1));
            System.out.println("Enter id :");
            int id = Integer.parseInt(s.nextLine());
            System.out.println("Enter name :");
            String name = s.nextLine();
            System.out.println("Enter day :");
            int day = Integer.parseInt(s.nextLine());
            System.out.println("Enter month :");
            int month = Integer.parseInt(s.nextLine());
            System.out.println("Enter year :");
            int year = Integer.parseInt(s.nextLine());
            Customer cus = new Customer(id, name, new DateTime(day, month, year));
            listCustomer.add(cus);
        }
        compareCustomer(listCustomer.get(0), listCustomer.get(1));
    }

    public static void compareCustomer(Customer cus1, Customer cus2) {
        String dateFirst = cus1.getBirthday().getDay() + "/" + cus1.getBirthday().getMonth() + "/" + cus1.getBirthday().getYear();
        String dateSecond = cus2.getBirthday().getDay() + "/" + cus2.getBirthday().getMonth() + "/" + cus2.getBirthday().getYear();
        Date date1 = null;
        Date date2 = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date1 = format.parse(dateFirst);
            date2 = format.parse(dateSecond);



        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        if (date1.compareTo(date2) > 0) {
            System.out.println("Old customer :" + cus1.getName());
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Young customer :" + cus2.getName());
        } else {
            System.out.println(" Together age ! ");
        }

    }
}
