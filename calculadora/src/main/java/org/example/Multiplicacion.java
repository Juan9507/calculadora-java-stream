package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Multiplicacion {
    private static final Logger logger = Logger.getLogger(Multiplicacion.class.getName());
    private List<Integer> myListOne = Arrays.asList(1, 5, 3, 6, 8);
    private List<Integer> myListTwo = Arrays.asList(1, 3, 8, 7);
    private AtomicInteger index = new AtomicInteger();

    public void multiplicacion() {
        if (myListTwo.size() > myListOne.size() || myListTwo.size() == myListOne.size()) {
            myListOne.stream()
                    .map(element -> element * myListTwo.get(index.getAndIncrement()))
                    .forEach(element -> logger.info(String.valueOf(element)));
        }
        if (myListTwo.size() < myListOne.size()) {
            myListTwo.stream()
                    .map(element -> myListOne.get(index.getAndIncrement()) * element)
                    .forEach(element -> logger.info(String.valueOf(element)));
        }
    }
}
