package DynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubstr {
    static class Cell {
        int value;
        String dir;

        Cell(int value, String dir) {
            this.value = value;
            this.dir = dir;
        }

        Cell() {
            value = 0;
            dir = "";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        System.out.println(findLCS(s1, s2));
    }

    private static int findLCS(String s1, String s2) {
        Cell[][] ara = new Cell[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                ara[i][j] = new Cell();
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    ara[i][j].value = ara[i - 1][j - 1].value + 1;
                    ara[i][j].dir = "\\";
                } else {
                    String temp;
                    int val;
                    if (ara[i - 1][j].value > ara[i][j - 1].value) {
                        temp = "↑";
                        val = ara[i - 1][j].value;
                    } else {
                        temp = "←";
                        val = ara[i][j - 1].value;
                    }
                    ara[i][j].value = val;
                    ara[i][j].dir = temp;
                }
            }
        }
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                System.out.printf("%2d%1s ", ara[i][j].value, ara[i][j].dir);
            }
            System.out.println();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length(), j = s2.length(); !(i == 0 || j == 0); ) {
            if (ara[i][j].dir.equals("\\")) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (ara[i][j].dir.equals("↑")) {
                i--;
            } else j--;
        }
        System.out.println(sb.reverse());
        return ara[s1.length()][s2.length()].value;
    }
}
