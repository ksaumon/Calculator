public class Test {
    public static void main(String[] args) {
        String s = "Java";
        char c = 'a';
        System.out.println(test1(s, c));
    }
    public static int test1(String s, char c) {
        char[] actions = s.toCharArray();
        int count = 0;
        int end = actions.length;
        for (int i = end - 1; i >= 0; i--) {
            if (actions[i] == c) {
                count++;
            }
        }

        return count;
    }
}
