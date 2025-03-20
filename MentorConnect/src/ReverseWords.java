public class ReverseWords {
    public static void main(String[] args) {
        String res = reverseWords("Java is a beautiful programming language");
        System.out.println(res);
    }

    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        StringBuilder rev = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            rev.append(words[i]).append(" ");
        }
        return rev.toString();
    }
}
