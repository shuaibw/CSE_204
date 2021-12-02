package Greedy;

import java.util.Arrays;

public class JobSequence {
    private static class Job {
        int p, d;

        private Job(int p, int d) {

            this.p = p;
            this.d = d;
        }

        @Override
        public String toString() {
            return String.format("%d %d", p, d);
        }
    }

    public static Job[] solve(Job[] jobs) {
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o2.p, o1.p));
        int maxDeadline = Arrays.stream(jobs).min((o1, o2) -> Integer.compare(o2.d, o1.d)).get().d;
        Job[] compat = new Job[maxDeadline + 1];
        for (Job j : jobs) {
            int i = j.d;
            while (i >= 0 && compat[i] != null) i--;
            if (i == 0) continue;
            compat[i] = j;
        }
        return compat;
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[]{
                new Job(7, 5),
                new Job(6, 5),
                new Job(5, 2),
                new Job(4, 7),
                new Job(3, 7),
                new Job(3, 7),
                new Job(3, 6),
                new Job(2, 7),
                new Job(2, 1),
                new Job(2, 5),
                new Job(2, 3),
                new Job(2, 1),
                new Job(1, 1)
        };
        for (Job j : solve(jobs)) {
            System.out.println(j);
        }
    }
}
