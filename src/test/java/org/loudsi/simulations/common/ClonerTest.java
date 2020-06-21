package org.loudsi.simulations.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.loudsi.common.Cloner;

import java.util.Collection;
import java.util.List;

class ClonerTest {

    private static class Insider {
        private final double doubleValue;
        private final int intValue;

        public Insider(double doubleValue, int intValue) {
            this.doubleValue = doubleValue;
            this.intValue = intValue;
        }

        public double getDoubleValue() {
            return doubleValue;
        }

        public int getIntValue() {
            return intValue;
        }
    }

    private static class Pojo {
        private Collection<Insider> insiderList;
        private Insider insider;

        public Pojo(Collection<Insider> insiderList, Insider insider) {
            this.insiderList = insiderList;
            this.insider = insider;
        }

        public Collection<Insider> getInsiderList() {
            return insiderList;
        }

        public Insider getInsider() {
            return insider;
        }
    }

    @Test
    void deepClone() {
        final Pojo pojo = new Pojo(
                List.of(
                        new Insider(0.5, 2),
                        new Insider(1.5, 2)
                ),
                new Insider(0.3, 89)
        );

        Pojo copiedPojo = Cloner.deepClone(pojo);

        Assertions.assertNotEquals(pojo,copiedPojo);

    }
}