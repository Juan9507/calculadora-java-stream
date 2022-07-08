package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Calculadora {

    private static final Logger logger = Logger.getLogger(Calculadora.class.getName());
    List<Integer> myListOne = Arrays.asList(1, 5, 3, 6, 8);
    List<Integer> myListTwo = Arrays.asList(1, 3, 8, 7);
    AtomicInteger index = new AtomicInteger();

    public void suma() {
        if (myListTwo.size() > myListOne.size() || myListTwo.size() == myListOne.size()) {
            myListOne.stream()
                    .map(element -> element + myListTwo.get(index.getAndIncrement()))
                    .forEach(element -> logger.info(String.valueOf(element)));
        }
        if (myListTwo.size() < myListOne.size()) {
            myListTwo.stream()
                    .map(element -> myListOne.get(index.getAndIncrement()) + element)
                    .forEach(element -> logger.info(String.valueOf(element)));
        }

    }

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

    public void resta() {
        if (myListTwo.size() > myListOne.size() || myListTwo.size() == myListOne.size()) {
            myListOne.stream()
                    .map(element -> element - myListTwo.get(index.getAndIncrement()))
                    .forEach(element -> logger.info(String.valueOf(element)));
        }
        if (myListTwo.size() < myListOne.size()) {
            myListTwo.stream()
                    .map(element -> myListOne.get(index.getAndIncrement()) - element)
                    .forEach(element -> logger.info(String.valueOf(element)));
        }
    }

    public void division() {
        AtomicInteger indexTwo = new AtomicInteger();
        List<Double> myListOne = Arrays.asList(1.0, 2.0, 3.0, 6.0, 8.0);
        List<Double> myListTwo = Arrays.asList(1.0, 9.0, 0.0, 7.0);
        if (myListTwo.size() > myListOne.size() || myListTwo.size() == myListOne.size()) {
            myListOne.stream()
                    .map(element -> {
                        if (element == 0 || myListTwo.get(indexTwo.getAndIncrement()) == 0) {
                            return 0;
                        }
                        return element / myListTwo.get(index.getAndIncrement());
                    })
                    .forEach(element -> logger.info(String.valueOf(element)));
        }
        if (myListTwo.size() < myListOne.size()) {
            myListTwo.stream()
                    .map(element -> {
                        if (element == 0 || myListOne.get(indexTwo.getAndIncrement()) == 0) {
                            return 0;
                        }
                        return myListOne.get(index.getAndIncrement()) / element;
                    })
                    .forEach(element -> logger.info(String.valueOf(element)));
        }
    }


}
