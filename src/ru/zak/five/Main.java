package ru.zak.five;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Random r = new Random();
        Elevator elevator = new Elevator();
        elevator.setState(new DownState(elevator));
        int man = user();
        int[] floor = new int[3];
        floor[0] = 1;
        int[] att;

        for (int i = 1; i < floor.length; i++) {
            floor[i] = r.nextInt(9) + 1;
        }
        for (int i : floor) {
            System.out.print(i);
        }
        System.out.println();

        if (man!=1){
            elevator.up();
            att = elevatorUp(floor, man);
            for (int j : att) {
                System.out.print(j);
            }
        } else {
            elevator.down();
            int pokemon = elevatorDown(floor, man);
            floorOne(man, floor, pokemon);
            for (int i : floor) {
                System.out.print(i);
            }
        }


    }

    /**
     * На каком этаже
     * (тут нужно будет раскидать че да как по касту призыва пакемонов.
     * Для начало получить данные о их местоположении и куда нужно кастануть призыв.
     * Чтобы рассчитать ближайший лифт над к текущему положению прибавить количество этаже и минимальное число будет кратчайшим путём.
     * Ну там далее кастуем призывчик.Если расстояние до ближайшего лифта развно 10 то нужно найти 2е минимальное расстояние
     * и кастануть этот лифт а потом отправить мужика)
     * Тут покемоны узнают где они находятся и куда им надо
     */
    public static int[] elevatorUp(int[] floor, int man) {
        int[] arr = new int[4];
                for (int i = 1; i < floor.length; i++) {
                    arr[i] = Math.abs(man - floor[i]);
                    if (arr[i]<arr[i-1]){
                        floor[i] = man;
                        System.out.println(floor[i]);
                    }
                }
        return floor;
    }
    public static int elevatorDown(int[] floor, int man) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите нужный этаж");
        int max = sc.nextInt();
        int pokemon = 0;
        for (int i = 0; i < floor.length; i++) {
            //если там доделать покемонов тут будет работать
            if (floor[i] == man) {
                floor[i] = max;
                pokemon = i;
                break;
            }
        }
    return pokemon;
    }
    /**
    * На каком этаже
    *  (в этом классе мужик клацает на кнопку. После клаца на кнопку данные о местоположении мужика перекидываются дольше)
     */
    public static int user() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите этаж");
        int man = sc.nextInt();
        return man;
    }

    /**
     * 	На каком этаже находится
     * 	(принимаем данные из класса main о местоположении мужика. Получем данные о местоположении лифтов.
     * 	Кастуем призыв лифта(если лифт и мужик находятся на одном и том же этаже необходимо
     * 	мужик заходит в этот лифт но прежде чем он кудато телепортнется нужно вызвать другой ближайший лифт на 1 этаж хотя это уже и не важно
     *
     */
    public static int[] floorOne(int man, int[] floor, int pokemon) {
        //Сравниваем всех покемонов ищем следующий кто не первый отправляем на первый
        int[] arr = new int[4];
        for (int i = 0; i < floor.length; i++) {
            arr[i] = Math.abs(man - floor[i]);
        }
        for (int j = 1;j < floor.length; j++ ){
            if (arr[j] < arr[j - 1] & j != pokemon) {
                floor[j] = 1;

            }
        }
        return floor;
    }


}
