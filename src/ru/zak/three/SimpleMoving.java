package ru.zak.three;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class SimpleMoving {
    private static final String IN_FILE_TXT = "src\\ru\\zak\\three\\inFile.txt";
    private static final String IN_URL = "file:///C:/Users/anast/IdeaProjects/One/src/ru/zak/three/inFile.html";
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер окна");
        int window = sc.nextInt();
        String st = reader();
        Double[] array1 = arr(st, window);
        String st2 = internet();
        Double[] array2 = arr(st2, window);
        double mov1 = moving(window, array1);
        double mov2 = moving(window, array2);
        double media = median(array1);
        System.out.println("Простое скользящее среднее:" + mov1);
        System.out.println("Простое скользящее среднее:" + mov2);
        System.out.println("Медианный фильтр:" + media);
    }


    public static Double moving(int window, Double[] arr){
        double simpleMovingAverage = 0;
        for (Double array : arr){
            simpleMovingAverage+=array;
        }
        simpleMovingAverage = simpleMovingAverage/window;
        return simpleMovingAverage;
    }

    public static String internet() throws IOException {
        URL oracle = new URL(IN_URL);
        BufferedReader reader = new BufferedReader(new InputStreamReader(oracle.openStream()));
        String inputLine;
        inputLine = reader.readLine();
        reader.close();
        return inputLine;
    }


    public static String reader() throws IOException {
        String st;
        BufferedReader reader = new BufferedReader(new FileReader(IN_FILE_TXT));
        st = reader.readLine();
        reader.close();
        return st;
    }

    public static Double[] arr(String st, int window){
        String[] words = st.split(", ");
        String[] mini = new String[window];
        System.arraycopy(words, 0, mini, 0, window);
        Double[] array = Stream.of(mini).mapToDouble(Double::parseDouble).boxed().toArray(Double[]::new);
        return array;
    }
    public static double median(Double[] array){
        Arrays.sort(array);
        double media = 0;
        array[0] = 0.0;
        array[array.length-1] = 0.0;
        for (Double aDouble : array) {
            media = media + aDouble;
        }
        return media/array.length;
    }

}
