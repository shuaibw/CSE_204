package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ActivitySelection {
    private static class Activity {
        int start;
        int end;

        private Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return String.format("%d %d", start, end);
        }
    }

    private static ArrayList<Activity> activitySelectorIter(ArrayList<Activity> ara) {
        ara.sort(Comparator.comparingInt(o -> o.end - o.start));
        ArrayList<Activity> compatible = new ArrayList<>();
        int lastFinish = 0; //first fictitious
        int k = 0;
        for (int i = 0; i < ara.size(); i++) {
            Activity cur = ara.get(i);
            if (cur.start > lastFinish) {
                compatible.add(cur);
                lastFinish = cur.end;
            }
        }
        return compatible;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/Greedy/activityInput.txt"));
        int n = scanner.nextInt();
        ArrayList<Activity> activities = new ArrayList<>();
        while (n-- != 0) {
            Activity a = new Activity(scanner.nextInt(), scanner.nextInt());
            activities.add(a);
        }
        ArrayList<Activity> compatibles = activitySelectorIter(activities);
        for (Activity compatible : compatibles) {
            System.out.println(compatible);
        }
    }
}
