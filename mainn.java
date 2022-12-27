public class mainn {
    public static void main(String[] args) {
        System.out.println(pow(2,30));
    }

        public static int pow(int x, int n) {

            if (n==0) {
                return 1;
            }
            else if (n % 2 == 0) {
                return pow(x*x, n/2);
            }
            else {
                return x * pow(x*x, n/2);
            }
        
        }
    
}
