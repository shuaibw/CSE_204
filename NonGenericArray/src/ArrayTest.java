import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        /*Test #1: Constructors*/
        String[] data = new String[]{
                "nuance", "tango", "delta", "biscuits", "rover", "coffee"
        };
        System.out.println("-----Initiating Test #1-----\n");
        System.out.println("Testing no-args ctor");
        Array ara1 = new Array();
        testSimpleMethods(ara1);
        System.out.println("Testing int-arg ctor");
        Array ara2 = new Array(30);
        testSimpleMethods(ara2);
        System.out.println("Testing String[]-arg ctor");
        Array ara3 = new Array(data);
        testSimpleMethods(ara3);
        System.out.println("-----Test #1 completed-----");


        /*Test #2: Methods*/
        System.out.println("-----Initiating Test #2-----\n");
        Array ara = new Array();
        System.out.println("Method call: add()");
        ara.add("abacus");
        ara.add("talus");
        ara.add("cuboid");
        testSimpleMethods(ara);
        System.out.println("Method call: add(int idx, String element)");
        ara.add(1, "cuneiform");
        ara.add(1, "patella");
        testSimpleMethods(ara);
        System.out.println("Stress testing: add(int idx, String element)");
        for (int i = 0; i < 10; i++) ara.add(2, i % 2 == 0 ? "talus" : "cuneiform");
        testSimpleMethods(ara);
        System.out.println("Stress testing: getAnElement(int i)");
        for (int i = 0; i < ara.size(); i++) System.out.printf("%s ", ara.getAnElement(i));
        System.out.println("\n");
        System.out.println("Stress testing: findIndex(String element)");
        System.out.println("talus: " + Arrays.toString(ara.findIndex("talus")));
        System.out.println("cuneiform: " + Arrays.toString(ara.findIndex("cuneiform")));
        System.out.println("nebula: " + Arrays.toString(ara.findIndex("nebula")));
        System.out.println("patella: " + Arrays.toString(ara.findIndex("patella")) + "\n");
        System.out.println("Method call: subArray(int start, int end)");
        System.out.println("subArray(3, 6): " + Arrays.toString(ara.subArray(3, 6)));
        System.out.println("subArray(1, 1): " + Arrays.toString(ara.subArray(1, 1)));
        System.out.println("subArray(1, 2): " + Arrays.toString(ara.subArray(1, 2)));
        System.out.println("subArray(0, ara.size()): " + Arrays.toString(ara.subArray(0, ara.size())) + "\n");
        System.out.println("Method call: remove(String element)");
        ara.remove("talus");
        testSimpleMethods(ara);
        ara.remove("cuneiform");
        testSimpleMethods(ara);
        System.out.println("Method call: merge(String[] A1, String[] A2)");
        String[] A1 = new String[]{
                "phi", "beta", "kappa", "omega", "alpha"
        };
        String[] A2 = new String[]{
                "delta", "theta", "tau", "gamma", "zeta"
        };
        Arrays.sort(A1);
        Arrays.sort(A2);
        ara.merge(A1, A2);
        testSimpleMethods(ara);
        System.out.println("-----Test #2 completed-----");


        /*Test #3: Robustness*/
        System.out.println("-----Initiating Test #3-----\n");
        ara = new Array(new String[]{"alpha", "beta"});
        try {
            ara.getAnElement(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        A1 = new String[]{
                "phi", "beta", "kappa", "omega", "alpha"
        };
        try {
            Array invalid = new Array(-10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Array invalid = new Array(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ara.merge(A1, A2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ara.subArray(-1, 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ara.add(10, "this won't be added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ara.remove(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ara.subArray(1, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("gekko: " + Arrays.toString(ara.findIndex("gekko")));
        testSimpleMethods(ara);
        System.out.println("-----Test #3 completed-----");
    }

    private static void testSimpleMethods(Array ara) {
        System.out.printf("Array length: %d\n", ara.length());
        System.out.printf("Array size: %d\n", ara.size());
        System.out.println("Is empty: " + ara.isEmpty());
        System.out.println("Data: " + Arrays.toString(ara.getArray()) + "\n");
    }
}
