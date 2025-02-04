import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String pesel = scanner.nextLine();
        String pesel = "55030101193";
        if (isDigit(pesel)) {
            System.out.println("Suma kontrolna:");
            boolean isCorrect = checkControlSum(pesel);
            if (isCorrect) {
                System.out.println("Podany pesel jest prawidłowy - suma kontrolna się udała");
                char sex = checkSex(pesel);
                if (sex == 'K') {
                    System.out.println("Kobieta");
                } else {
                    System.out.println("Mężczyzna");
                }
            }else{
                System.out.println("Podany pesel jest nieprawidłowy - suma kontrolna się nie udała");
            }
        } else {
            System.out.println("Podano niewłasciwy pesel");
        }

    }

    public static char checkSex(String pesel) {
        if (isDigit(pesel)) {
            int digit = pesel.charAt(9);
            if (digit % 2 == 0) {
                return 'K';
            } else {
                return 'M';
            }
        }
        return 'o';
    }

    public static boolean checkControlSum(String pesel) {
        int[] weight = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int S = 0;
        for (int i = 0; i < 10; i++) {
            S += weight[i] * Integer.parseInt(String.valueOf(pesel.charAt(i)));
        }

        int M = S % 10;
        int R = 0;
        if (M == 0) {
            R = 0;
        } else {
            R = 10 - M;
        }

        if (R == Integer.parseInt(String.valueOf(pesel.charAt(10)))) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isDigit(String pesel) {
        if (pesel.length() == 11) {
            for (int i = 0; i < pesel.length(); i++) {
                if (!Character.isDigit(pesel.charAt(i))) return false;
            }
            return true;
        } else {
            return false;
        }
    }


}
