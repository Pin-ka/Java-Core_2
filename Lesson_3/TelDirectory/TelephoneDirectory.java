package Lesson_3.TelDirectory;

import java.util.HashMap;

public class TelephoneDirectory {
    //Используем HashMap с ключом по номеру телефона
    HashMap <String,String> telDir=new HashMap<>();

    public TelephoneDirectory() {
        this.telDir = telDir;
    }

    public void add (String tel,String fam){
        if (telDir.containsKey(tel)) {
            System.out.println("Этот телефон уже есть в базе");
        }else {
            telDir.put(tel,fam);
        }
    }

    public void get(String fam){
        System.out.println(fam+":");
        for (HashMap.Entry<String, String> o : telDir.entrySet()) {
           if (o.getValue().equalsIgnoreCase(fam))System.out.println(o.getKey());
        }
    }

    public void info(){
        System.out.println(telDir);
    }
}
