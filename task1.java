public class task1{
    public static void main(String args[]){
        int a = 2;
        int b = -2;

        System.out.println(powRecursion(a,b));
        System.out.println(powIter(a,b));
    }

    public static double powRecursion(int a, int b){
        if(b == 0) return 1;

        if(b < 0) {
            powRecursion(1/a, -b);
        }

    double res = powRecursion(a, b/2);
    return b % 2 == 0 ? res * res : res * res * a;
    }

    public static double powIter(int a, int b) {
        double a1 = a;
        if (a == 0 || a == 1) return a;
        if (b == 0) return 1;

        if (b < 0) {
            b = -b;
            a1 = 1.0/a;
        }

        double res = 1;
        while (b > 0) {
            if (b % 2 == 1)
                res = res * a1;
            a1 = a1 * a1;
            b = b / 2;
        }
        return res;
    }
}    