package Lesson_5;

import static java.lang.Math.*;

public class ThreadSpeed {
    static final int size = 10000000;
    static final int N = 2;//Количество потоков

    public static void main(String[] args) {
        float[] arr = new float[size];
        for (int i=0;i<size;i++){
            arr[i]=1;
        }
        oneThread (arr);
        System.out.println();
        NThread(arr);
    }

    static void oneThread(float[] arr){
        long timeStart = System.currentTimeMillis();
        for (int i=0;i<size;i++){
            arr[i]=(float)(arr[i] * sin(0.2f + i / 5) * cos(0.2f + i / 5) * cos(0.4f + i / 2));
        }
        long timeEnd=System.currentTimeMillis();
        System.out.println("Если поток один, то время просчета массива: "+(timeEnd - timeStart));
    }

    static void NThread(float[]arr){
        long splitTimeStart=System.currentTimeMillis();
        float[][] splittedArray = new float[N][size/N];
        for(int i=0;i<N;i++){
            System.arraycopy(arr, i*(size/N),splittedArray[i],0,size/N);
        }
        long splitTimeEnd=System.currentTimeMillis();

        MyThread[]arrThread=new MyThread[N];
        for (int i=0;i<N;i++){
            arrThread[i]=new MyThread(splittedArray[i],i);
        }

        for (int i=0;i<N;i++){
            arrThread[i].start();
        }

        try {
            for (int i=0;i<N;i++){
                arrThread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long compoundTimeStart=System.currentTimeMillis();
        for(int i=0;i<N;i++){
            System.arraycopy(splittedArray[i],0,arr,i*(size/N),size/N);
        }
       long compoundTimeEnd=System.currentTimeMillis();
        System.out.println("Если количестко потоков = "+N+", то");
        System.out.println("- время разделения массивов: "+(splitTimeEnd-splitTimeStart)+";");
        for (int i=0;i<N;i++){
            arrThread[i].info();
        }
        System.out.println("- время склейки массивов: "+(compoundTimeEnd-compoundTimeStart)+".");
    }
}

class MyThread extends Thread{
    float[]array;
    int i;//номер потока
    long time;

    public MyThread(float[] array,int i) {
        this.array = array;
        this.i=i;
    }

    @Override
    public void run() {
        long timeStart=System.currentTimeMillis();
        for (int i=0;i<array.length;i++){
            array[i]=(float)(array[i] * sin(0.2f + i / 5) * cos(0.2f + i / 5) * cos(0.4f + i / 2));
        }
        long timeEnd=System.currentTimeMillis();
        time=timeEnd-timeStart;
    }

    public void info(){
        System.out.println("- время просчета массива в потоке "+(i+1)+": "+time);
    }
}


