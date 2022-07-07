package org.example;

import java.util.logging.Logger;
import java.util.stream.DoubleStream;

public class Calculadora {

    private static final Logger logger = Logger.getLogger(Calculadora.class.getName());
    public void suma() {
        DoubleStream stream1 = DoubleStream.of(1,2,3);
        DoubleStream stream2 = DoubleStream.of(1,2,3);
        DoubleStream.concat(stream1,stream2)
                .reduce(Double::sum)
                .ifPresent(element -> logger.info("Suma "+ element));
    }

    public void multiplicacion() {
        DoubleStream stream1 = DoubleStream.of(1,2,3);
        DoubleStream stream2 = DoubleStream.of(1,2,3);
        DoubleStream.concat(stream1,stream2)
                .reduce((acumulador, numero)-> acumulador * numero)
                .ifPresent(element -> logger.info("Multiplicacion "+ element));
    }

    public void resta() {
        DoubleStream stream1 = DoubleStream.of(1,2,3);
        DoubleStream stream2 = DoubleStream.of(1,2,3);
        DoubleStream.concat(stream1,stream2)
                .reduce((acumulador, numero)-> acumulador - numero)
                .ifPresent(element -> logger.info("Resta "+ element));
    }

    public void division() {
        DoubleStream stream1 = DoubleStream.of(1,2,0);
        DoubleStream stream2 = DoubleStream.of(1,2,3);
        DoubleStream.concat(stream1,stream2)
                .filter(element -> element > 0)
                .reduce((acumulador, numero)-> acumulador / numero)
                .ifPresent(element -> logger.info("Division "+ element));
    }


}
