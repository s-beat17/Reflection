package pack;

import static pack.ArrRef.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Ref.<User>table(
                new User("n1", 10, true, "l1", "p1"),
                new User("n2", 20, false, "l2", "p2")
        );
        System.out.println();
        //
        Ref.<Student>table(
                new Student("s1", "n1", 18, "81"),
                new Student("s2", "n2", 20, "83")
        );
        System.out.println();
        //
        String arr[] = {"a", "b", "c"};
        arrOut(arr);
        System.out.println();
        //
        int[] myArrayInt = new int[5];
        arrFill(myArrayInt);
    }
}
