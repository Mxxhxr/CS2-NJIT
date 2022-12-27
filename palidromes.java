public class palidromes {
    public static void main(String[] args) {
        System.out.println(pal(args[0]));
    }
    
public static boolean pal(String s) {
    if (s.length() > 1) {
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return pal(s.substring(1, s.length()-1));
        }
        return false;
    }
    return true;
}
}
