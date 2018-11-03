package Lesson_3.TelDirectory;

public class MainRequest {
    public static void main(String[] args) {
        TelephoneDirectory telBook=new TelephoneDirectory();
        telBook.add("250-50-75","Иванов");
        telBook.add("250-55-44","Петров");
        telBook.add("230-50-75","Сидоров");
        telBook.add("230-34-75","Иванов");
        telBook.info();
        telBook.add("230-34-75","Непомнящий");
        telBook.get("Иванов");
    }
}
