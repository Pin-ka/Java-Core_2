package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SetOfWords {
    public static void main(String[] args) {
        //создаём массив с набором слов, используем ArrayList, так как тут поиск быстрее, а изменений не будет
        ArrayList <String> arrWords=new ArrayList<>(20);//в принципе, можно было бы создать обычный массив, но я хочу поработать с итератором
        arrWords.add("стрела");
        arrWords.add("цветы");
        arrWords.add("вода");
        arrWords.add("коллекция");
        arrWords.add("стрела");
        arrWords.add("цветы");
        arrWords.add("стрела");
        arrWords.add("коллекция");
        arrWords.add("вода");
        arrWords.add("стрела");
        arrWords.add("раз");
        arrWords.add("цветы");
        arrWords.add("вода");
        arrWords.add("стрела");
        arrWords.add("коллекция");
        arrWords.add("стрела");
        arrWords.add("вода");
        arrWords.add("цветы");
        arrWords.add("коллекция");
        arrWords.add("вода");

        //Считаем уникальные слова и выводим кол-во повторений
        HashMap <String,Integer>arrUniWords=new HashMap<>();
        Iterator<String> iter=arrWords.iterator();
        while (iter.hasNext()){
            String arr=iter.next();
            if(arrUniWords.containsKey(arr)) {
                    arrUniWords.put(arr, arrUniWords.get(arr) + 1);
            }else {
                    arrUniWords.put(arr,1);
            }
        }

        System.out.println(arrUniWords);

    }

}
