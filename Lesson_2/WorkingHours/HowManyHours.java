package Lesson_2.WorkingHours;

import java.util.Scanner;

public class HowManyHours {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Какой сегодня день?");
        String inputday= scanner.nextLine().toLowerCase();
        System.out.println(getStringOfWorkHours(inputday));
        scanner.close();
    }

    private static String getStringOfWorkHours(String inday){
        int sumHours=0;
        boolean ifYesRusName=false;

        String aboutWorkHours;

        for (Weekday day:Weekday.values()) {
            if (inday.equals(day.getRusName())){
                ifYesRusName=true;
            }
            if(ifYesRusName)sumHours+=day.getHours();
        }
        if (!ifYesRusName) {
            aboutWorkHours="Ошибка при вводе дня недели";
        }else if (sumHours==0) {
            aboutWorkHours="Сегодня выходной";
        }else {
            aboutWorkHours="До конца недели осталось: "+sumHours+" рабочих часов";
        }
        return aboutWorkHours;
    }
}
