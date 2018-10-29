package Lesson_2.Exclusions;

import Lesson_2.Exclusions.MyException.MyArrayDataException;
import Lesson_2.Exclusions.MyException.MyArraySizeException;

public class ForArraySumm {
    public static void main(String[] args){
      String[][]arrName={
              {"4","2","1","1"},
              {"2","1","1","1"},
              {"2","2","1","1"},
              {"1","1","1","2"}
      };
       try {
           System.out.println("Сумма элементов массива равна "+getArraySumm(arrName));
       } catch (MyArraySizeException e){
           e.printStackTrace();
       } catch (MyArrayDataException c){
           c.printStackTrace();
       }
    }

    public static int getArraySumm (String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) throw new MyArraySizeException("Количество строк не равно четырём");
        for (int i = 0; i < arr.length; i++) {//это для массивов переменной длины
            if (arr[i].length != 4) throw new MyArraySizeException("Количество столбцов не равно четырём");
        }
        int summ=0;
        Integer ordinary;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                try {
                    ordinary= Integer.valueOf(arr[i][j]);
                }catch (NumberFormatException c){
                    throw new MyArrayDataException("В ячейке ["+i+"]["+j+"] массива лежит не число");
                }
                summ=summ+ordinary;
            }
        }
        return summ;
    }
}
