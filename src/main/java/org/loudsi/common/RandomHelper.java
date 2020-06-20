package org.loudsi.common;

import java.util.concurrent.ThreadLocalRandom;

public class RandomHelper {

    static public int randomIntInclusive(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    static public double randomDoubleInclusive(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    static public double randomDoubleInclusive(double interval) {
        return ThreadLocalRandom.current().nextDouble(-interval, interval);
    }

    static public int randomIntInclusive(int interval) {
        return ThreadLocalRandom.current().nextInt(-interval, interval);
    }

    static public boolean trueOneTimeOutOf(int number) {
        return randomIntInclusive(1, number) == 1;
    }
}
