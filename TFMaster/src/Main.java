public class Main {
    public static int binlog(int bits) {
        int log = 0;
        if ((bits & 0xffff0000) != 0) {
            bits >>>= 16;
            log = 16;
        }
        if (bits >= 256) {
            bits >>>= 8;
            log += 8;
        }
        if (bits >= 16) {
            bits >>>= 4;
            log += 4;
        }
        if (bits >= 4) {
            bits >>>= 2;
            log += 2;
        }
        return log + (bits >>> 1);
    }

    public static void printHeap(int[] ara, int n) {
        if (n >= ara.length) return;
        if (n >= ara.length / 2) System.out.print(ara[n] + " ");

    }

    public static void main(String[] args) {
        int[] ara = new int[10];
        for (int i = 0; i < ara.length; i++) {
            ara[i] = i + 10;
        }
        int height = binlog(ara.length);
        int maxLf = 1 << height;
        int maxSp = maxLf * 2 + (maxLf - 2);
        for (int i = 0; i < maxSp / 2; i++) {
            System.out.print(" ");
        }

    }
}
