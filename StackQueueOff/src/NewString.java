public class NewString {

    public static String convert(String old) {
        if (!old.matches("[a-z]+")) throw new IllegalArgumentException("Invalid input");
        LinkedQueue<Character> q = new LinkedQueue<>();
        char[] ara = old.toCharArray();
        int[] counter = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c : ara) {
            int freq = ++counter[c - 'a'];
            if (freq == 1) q.enqueue(c);
            while (!q.isEmpty() && counter[q.peek() - 'a'] > 1) q.dequeue();
            sb.append(q.isEmpty() ? '#' : q.peek());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] inputs = new String[]{
                "aaaaaaa",
                "abcabcabc",
                "aabbccaabbcc",
                "grapplehook",
                "aabbccddeeff",
                "ppiiaannoo",
                "bbuueettccssee"
        };
        for (String s : inputs) {
            System.out.printf("%s = %s\n", s, convert(s));
        }
    }
}
