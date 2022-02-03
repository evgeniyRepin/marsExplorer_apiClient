package com.evgeniy_repin.projects.marsexplorer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Test {

    Boolean b;

    public Test(Boolean b) {
        this.b = b;
    }

    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Test test = new Test(true);

        Method method = null;

        try {
            method = test.getClass().getMethod("getB");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        if ((boolean) method.invoke(test)) {
            System.out.println("it works");
        }
    }
}
