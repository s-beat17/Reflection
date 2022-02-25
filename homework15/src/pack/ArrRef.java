package pack;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Random;

public class ArrRef {
    public static void arrOut(Object arr) {
        if (arr.getClass().isArray()) {
            for (int i = 0; i < Array.getLength(arr); i++) {
                System.out.println("Array.get(arr, i) = " + Array.get(arr, i));
            }
        }
    }

    public static void arrFill(Object arr) throws Exception {
        Class clRand = Random.class;
        Random randObj = new Random();

        Method m = getMethodFromRandom(arr);
        String s = null;
        if (m != null) {
            s = m.getName();
        }
        else {
            System.err.println("Error array");
        }
        try {
            Method someMethod = clRand.getDeclaredMethod(s);
            String s2 = String.valueOf(arr.getClass()).toLowerCase();
            if (s2.indexOf("integer") > 0 || s2.indexOf("[i") > 0)
                arr = Array.newInstance(Integer.class, Array.getLength(arr));
            else if (s2.indexOf("double") > 0 || s2.indexOf("[d") > 0)
                arr = Array.newInstance(Double.class, Array.getLength(arr));
            else if (s2.indexOf("long") > 0 || s2.indexOf("[j") > 0)
                arr = Array.newInstance(Long.class, Array.getLength(arr));
            else if (s2.indexOf("float") > 0 || s2.indexOf("[f") > 0)
                arr = Array.newInstance(Float.class, Array.getLength(arr));
            else if (s2.indexOf("boolean") > 0 || s2.indexOf("[z") > 0)
                arr = Array.newInstance(Boolean.class, Array.getLength(arr));
            else {
                System.out.println("arr null");
            }
            //arr = Array.newInstance(Integer.class, Array.getLength(arr));
            for (int i = 0; i < Array.getLength(arr); i++) {
                Array.set(arr, i, someMethod.invoke(randObj));
                System.out.println("Array.get(arr, i) = " + Array.get(arr, i));
            }
        } catch (NullPointerException e) {
            System.err.println("Error array");
        }

    }

    public static Method getMethodFromRandom(Object arr) throws Exception {
        if (arr.getClass().isArray()) {
            Class cl = Random.class;
            String s1;
            String s = String.valueOf(arr.getClass()).toLowerCase();
            if (s.indexOf("integer") > 0 || s.indexOf("[i") > 0)
                s = "Int";
            else if (s.indexOf("double") > 0 || s.indexOf("[d") > 0)
                s = "Double";
            else if (s.indexOf("long") > 0 || s.indexOf("[j") > 0)
                s = "Long";
            else if (s.indexOf("float") > 0 || s.indexOf("[f") > 0)
                s = "Float";
            else if (s.indexOf("boolean") > 0 || s.indexOf("[z") > 0)
                s = "Boolean";
            else {
                System.err.println("Error array");
                return null;
            }

            for (Method declaredMethod : cl.getDeclaredMethods()) {
                s1 = String.valueOf(declaredMethod);

                if (s1.indexOf("next" + s) > 0) {
                    Method method = cl.getDeclaredMethod("next" + s);
                    return method;
                }
            }
        }
        System.out.println("Error");
        return null;
    }
}
