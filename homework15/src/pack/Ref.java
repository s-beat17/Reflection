package pack;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Ref {

    public static String analyzeClass(Object o) {
        Class clazz = o.getClass();
        return clazz.getSimpleName();
    }

    public static <M> void table(M... os) throws IllegalAccessException, ClassNotFoundException {

        String s = analyzeClass(os);
        s = s.replaceAll("\\[\\]", "");
        StringBuffer sb = new StringBuffer(s);
        sb.insert(0,"pack.");
        s = String.valueOf(sb);
        //System.out.println(s);
        Class c = Class.forName(s);
        System.out.println(c.getSimpleName());

        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            if (!Modifier.isStatic(f.getModifiers())) {
                System.out.print(f.getName() + "    ");
            }
        }
        System.out.println();
        for (int i = 0; i < os.length; i++) {
            M userObject = (M) os[i];
            for (Field f : fields) {
                f.setAccessible(true);
                if (!Modifier.isStatic(f.getModifiers()))
                    System.out.print(f.get(userObject) + "      ");
            }
            System.out.println();
        }
    }
}
