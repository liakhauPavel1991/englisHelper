package utils;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static Random RANDOM = new Random();

    public static int getRandomInt(int minValue, int maxValue) {
        return (int) (RANDOM.nextFloat() * (minValue - maxValue + 1)) + maxValue;
    }

    public static <E> E getRandomHashMapItem(HashMap<E,E> map) {
        Random random = new Random();
        return map.get(random.nextInt(map.size()));
    }

    public static <E> E getRandomItemFromList(List<E> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

}
