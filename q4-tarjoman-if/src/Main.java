import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (!(-99 <= number && number <= 99)) {
            System.out.println("عدد صحیح نمیباشد");
            return;
        }

        if (number == 0) {
            System.out.println("صفر");

        }

        String result = "";
        if (number < 0) {
            result = result + "منفی ";
        }
        number = Math.abs(number);

        if (10 <= number && number <= 19) {
            if (number == 10) {
                result += "ده";
            } else if (number == 11) {
                result += "یازده";
            } else if (number == 12) {
                result += "دوازده";
            } else if (number == 13) {
                result += "سیزده";
            } else if (number == 14) {
                result += "چهارده";
            } else if (number == 15) {
                result += "پانزده";
            } else if (number == 16) {
                result += "شانزده";
            } else if (number == 17) {
                result += "هفده";
            } else if (number == 18) {
                result += "هجده";
            } else {
                result += "نوزده";
            }
            System.out.println(result);
            return;
        }

        int first = number % 10;
        int second = number / 10;

        if (second == 2) {
            result += "بیست ";
        } else if (second == 3) {
            result += "سی ";
        } else if (second == 4) {
            result += "چهل ";
        } else if (second == 5) {
            result += "پنجاه ";
        } else if (second == 6) {
            result += "شصت ";
        } else if (second == 7) {
            result += "هفتاد ";
        } else if (second == 8) {
            result += "هشتاد ";
        } else if (second == 9) {
            result += "نود ";
        }

        if (!(second == 0)) {
            result += "و ";

        }

        if (first == 1) {
            result += "یک";
        } else if (first == 2) {
            result += "دو";
        } else if (first == 3) {
            result += "سه";
        } else if (first == 4) {
            result += "چهار";
        } else if (first == 5) {
            result += "پنج";
        } else if (first == 6) {
            result += "شش";
        } else if (first == 7) {
            result += "هفت";
        } else if (first == 8) {
            result += "هشت";
        } else if (first == 9) {
            result += "نه";
        }

        System.out.println(result);


    }
}
