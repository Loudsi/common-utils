package org.loudsi.common;

public class Cloner {
    //https://github.com/kostaskougios/cloning
    private static final com.rits.cloning.Cloner cloner = new com.rits.cloning.Cloner();
    public static <T> T deepClone(T t) {
        return cloner.deepClone(t);
    }
}
