package Uteco.Problem1;
import java.util.Arrays;
import java.util.Scanner;

public class prob1_2 {
    public static void main(String[] args) {
        String[] result = solution();
        System.out.println("결과" + Arrays.toString(result));
    }

    static int duplicatedNum(String[] array, int num) {
        // 중복되는 알파벳이 있는지 검사
        for (int i=0; i< array.length-1; i++) {
            if (array[i].equals(array[i+1]) && !"ㄱ".equals(array[i]) && !"ㄱ".equals(array[i+1])) {
                num++;
            }
        }

        return num;
    }

    static String[] duplicatedAlphabet(String[] array, int cnt, int l) {
        // 반복되는 알파벳 "ㄱ"으로 바꾸기
        for (int i=0; i< array.length-1; i++) {
            if (array[i].equals(array[i+1])) {
                array[i] = "ㄱ";
                array[i+1] = "ㄱ";
                cnt += 2;
            }
        }

        return array;
    }

    static String[] newArray(String[] array, int cnt, int l) {
        String[] arr = new String[array.length-cnt*2];
        int j = 0;

        for (int i=0; i< array.length; i++) {
            if (!"ㄱ".equals(array[i])) {
                arr[j] = array[i];
                j++;
            }
        }

        return arr;
    }

    static String[] solution() {
        Scanner sc = new Scanner(System.in);
        String encode = sc.next(); //암호문 받기

        int length = encode.length();
        int isThereDuplicated = 1;

        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = encode.substring(i, i + 1);
        }
        String[] newArr = array;

        while (isThereDuplicated > 0) {

            //반복되는 알파벳이 있는지
            isThereDuplicated = duplicatedNum(newArr, 0);

            if (isThereDuplicated > 0) {
                // 반복되는 알파벳 "ㄱ"으로 바꾸기
                array = duplicatedAlphabet(newArr, 0, length);

                // "ㄱ"을 제외한 새로운 배열 만들기
                newArr = newArray(array, isThereDuplicated, length);
            } else {
                return newArr;
            }
        }
        return newArr;
    }
}
