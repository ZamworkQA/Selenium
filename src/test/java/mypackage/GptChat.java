package mypackage;

import java.util.Random;

public class GptChat {
    public static class Main {
        public static void main(String[] args) {
            int raz = 0;
            Random rand = new Random();
            int num;
            do {
                num = rand.nextInt(10000) + 1;
                raz++;
                System.out.println("Попытка №: "+ raz + " Выпало число: " + num);
            } while (num != 1987);
            }
        }
    }

