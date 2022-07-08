package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Division {

    private static final Logger logger = Logger.getLogger(Division.class.getName());
    private List<Double> myListOne = Arrays.asList(1.0, 5.0, 3.0);
    private List<Double> myListTwo = Arrays.asList(1.0, 3.0, 8.0, 7.0);
    private AtomicInteger index = new AtomicInteger();
    private AtomicInteger indexTwo = new AtomicInteger();

    public void division() {
        if (myListOne.size() < myListTwo.size() || myListOne.size() == myListTwo.size()) {
            divisionListOneMaxOEqual();
        }

        if (myListTwo.size() < myListOne.size()) {
            divisionListTwoMax();
        }
    }

    public void divisionListOneMaxOEqual(){
        myListOne.stream()
                .map(element -> {
                    if (element == 0 || myListTwo.get(indexTwo.getAndIncrement()) == 0) {
                        return 0;
                    }
                    return element / myListTwo.get(index.getAndIncrement());
                })
                .forEach(element -> logger.info(String.valueOf(element)));
    }

    public void divisionListTwoMax(){
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
