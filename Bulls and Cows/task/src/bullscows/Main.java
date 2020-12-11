package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        
        int[] secret = {9, 3, 0, 5};

        int[] digits = new int[secret.length];
        digits[0] = number / 1000;
        digits[1] = (number % 1000) / 100;
        digits[2] = (number % 100) / 10;
        digits[3] = number % 10;

        int countCow = 0;
        int countBull = 0;

        for (int i = 0; i < secret.length; i++) {
            if (secret[i] == digits[i]) {
                countBull++;
            }
        }

        for (int i = 0; i < secret.length; i++) {
            if (secret[i] != digits[i] && (secret[i] == digits[(i + 1) % 4] || secret[i] == digits[(i + 2) % 4] || secret[i] == digits[(i + 3) % 4])) {
                countCow++;
                continue;
            }
        }

        if (countBull > 0 && countCow > 0) {
            System.out.println("Grade: " + countBull + " bull(s) and " + countCow + " cow(s). The secret code is 9305.");
        } else if (countBull == 0 && countCow > 0) {
            System.out.println("Grade: " + countCow + " cow(s). The secret code is 9305.");
        } else if (countBull > 0 && countCow == 0) {
            System.out.println("Grade: " + countBull + " bull(s). The secret code is 9305.");
        } else {
            System.out.println("Grade: None. The secret code is 9305.");
        }
    }
}
