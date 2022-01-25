package ru.zak.two;
import java.util.*;

public class Main {
    // очередь используется для хранения списка, так что мы получаем среднее
    private final Queue<Double> Dataset = new LinkedList<Double>();
    private final int period;
    private double sum;
    // конструктор для инициализации периода
    public Main(int period){
        this.period = period;
    }

    // функция для добавления новых данных в
    // перечислить и обновить сумму так, чтобы
    // мы получаем новое средне

    public void addData(double num){
        sum += num;
        Dataset.add(num);
        // Обновление размера так, чтобы длина
        // набора данных должен быть равен
        // период как нормальное среднее значение
        if (Dataset.size() > period) {
            sum -= Dataset.remove();
        }
    }

    // функция для вычисления среднего
    public double getMean(){
        return sum / period;
    }

    public static void main(String[] args) {
        double[] input_data = { 1, 3, 5, 6, 8,
                12, 18, 21, 22, 25 };
        int per = 3;
        Main obj = new Main(per);
        for (double x : input_data) {
            obj.addData(x);
            System.out.println("New number added is " +
                    x + ", SMA = " + obj.getMean());
        }
    }
}