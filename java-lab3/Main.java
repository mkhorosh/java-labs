package com.company;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.DateTimeException;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
	    System.out.println("Hello Marina, Go to sleep");
	    System.out.println("Введите ФИО через пробел:");
	    String buffer = in.nextLine();
	    buffer = buffer.trim().replaceAll(" +", " ");  // remove leading ending and extra spaces
	    if (countChar(buffer,' ')!=2){
            throw new Exception("invalid input :(");
        }
	    String lastName = buffer.substring(0,buffer.indexOf(' '));
        buffer = buffer.substring(buffer.indexOf(' ')+1);
        String firstName = buffer.substring(0,buffer.indexOf(' '));
        buffer = buffer.substring(buffer.indexOf(' ')+1);
        String middleName = buffer;
        lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
        firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
        middleName = middleName.substring(0,1).toUpperCase() + middleName.substring(1).toLowerCase();
        String sex = middleName.charAt(middleName.length()-1) == 'а'? "женский" : "мужской";
        System.out.println("Введите дату рождения(дд.мм.гггг):");
        buffer = in.nextLine();
        buffer = buffer.replaceAll(" ", "");  // remove spaces
        if (countChar(buffer,'.')!=2){
            throw new Exception("invalid input :(");
        }
        int day = Integer.parseInt(buffer.substring(0,buffer.indexOf('.')));
        buffer = buffer.substring(buffer.indexOf('.')+1);
        int month = Integer.parseInt(buffer.substring(0,buffer.indexOf('.')));
        buffer = buffer.substring(buffer.indexOf('.')+1);
        int year = Integer.parseInt(buffer);
        LocalDate date;
        try {
            date = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new Exception("invalid date :(");
        }
        LocalDate today = LocalDate.now();
        if (today.isBefore(date)){
            throw new Exception("invalid date :(");
        }
        Period p = Period.between(date, today);
        int age = p.getYears();
        System.out.println(lastName + ' ' +firstName.charAt(0)+'.'+middleName.charAt(0)+'.');
        System.out.println("Пол: "+sex);
        String postfix = "лет";
        if (age % 10 == 1){
            postfix = "год";
        }else if (age % 10 > 1 && age % 10<5){
            postfix = "года";
        }
        System.out.println("Возраст: "+age+" "+postfix);
    }

    private static int countChar(String s, char c) {
        int ans = 0;
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == c)
                ans++;
        }
        return ans;
    }
}
