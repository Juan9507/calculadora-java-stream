package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Potencia {
    private static final Logger logger = Logger.getLogger(Suma.class.getName());
    private List<Integer> myListOne = Arrays.asList(1, 5, 3, 6, 8);
    private List<Integer> myListTwo = Arrays.asList(1, 3, 8, 7);
    private AtomicInteger index = new AtomicInteger();

    public void ptencia() {
        if (myListTwo.size() > myListOne.size() || myListTwo.size() == myListOne.size()) {
            myListOne.stream()
                    .map(element -> Math.pow(element, myListTwo.get(index.getAndIncrement())))
                    .forEach(element -> logger.info(String.valueOf(element)));
        }
        if (myListTwo.size() < myListOne.size()) {
            myListTwo.stream()
                    .map(element -> Math.pow(myListTwo.get(index.getAndIncrement()), element))
                    .forEach(element -> logger.info(String.valueOf(element)));
        }

    }
}
