package Lesson_3;

import java.util.Scanner;

public class PassworVerification {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите ваш пароль, пожалуйста:");
        String inputPass= scanner.nextLine();
        System.out.println("результат проверки: "+verification(inputPass));
        scanner.close();
    }

    public static boolean verification(String pass){
        boolean verif=false;
        String pat = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}";
        //(?=.*[0-9]) - В пароле должно быть число
        //(?=.*[a-z]) - В пароле должна быть хотя бы 1 строчная буква
        //(?=.*[A-Z]) - В пароле должна быть хотя бы 1 заглавная буква
        //.{8,} - Пароль должен быть не менее 8ми символов
        if (pass.matches(pat)) verif=true;
        return verif;
    }
}
