package br.com.codenation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StatisticUtil {

   public static int average(int[] elements) {
        if (elements != null) {
            return (int) Arrays
                    .stream(elements)
                    .average()
                    .getAsDouble();
        }

        return 0;
    }

    public static int mode(int[] elements) {
        HashMap<Integer, Integer> quantity = new HashMap<>();

        for (int element : elements) {
            Integer quantityValue = quantity.getOrDefault(element, 0);
            quantity.put(element, quantityValue + 1);
        }

        return quantity.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .findFirst().get()
                .getKey();

    }

    public static int median(int[] elements) {
        if (elements != null) {
            Arrays.sort(elements);
            int middle = elements.length / 2;
            return elements.length % 2 == 0
                    ? (elements[middle] +elements[middle - 1]) / 2
                    : elements[middle];
        }

        return 0;
    }
}
