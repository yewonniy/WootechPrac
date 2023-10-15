package Uteco.Problem1;
import java.util.Scanner;


public class Prob1_1 {
    public static void main(String[] args) {
        int res = solution();
        System.out.println(res);
    }

    static int solution() {
        int[] pobi = new int[2];
        int[] crong = new int[2];
        int max_pobi = 0;
        int max_crong = 0;
        int[] sum = {0, 0};
        int[] mul = {1, 1};
        int[] sum2 = {0, 0};
        int[] mul2 = {1, 1};

        Scanner sc = new Scanner(System.in);

        pobi[0] = sc.nextInt();
        pobi[1] = sc.nextInt();
        crong[0] = sc.nextInt();
        crong[1] = sc.nextInt();

        System.out.printf("%d, %d%n", pobi[0], pobi[1]);
        System.out.printf("%d, %d%n", crong[0], crong[1]);

        if (pobi[1] - pobi[0] != 1) return -1;
        else if (crong[1] - crong[0] != 1) return -1;
        else {
            for (int i=0; i<2; i++) {
                while (pobi[i] != 0) {
                    sum[i] += pobi[i] % 10;
                    mul[i] *= pobi[i] % 10;
                    pobi[i] = pobi[i] / 10;
                    max_pobi = Math.max(max_pobi, sum[i]);
                    max_pobi = Math.max(max_pobi, mul[i]);
                }
            }
            for (int j=0; j<2; j++) {
                while (crong[j] != 0) {
                    sum2[j] += crong[j] % 10;
                    mul2[j] *= crong[j] % 10;
                    crong[j] = crong[j] / 10;
                    max_crong = Math.max(max_crong, sum2[j]);
                    max_crong = Math.max(max_crong, mul2[j]);
                }
            }
            System.out.printf("%d %d%n", max_pobi, max_crong);
            if (max_pobi > max_crong) return 1;
            else if (max_pobi < max_crong) return 2;
            else return 0;
        }
    }
}
