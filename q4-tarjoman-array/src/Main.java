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

        String[] betweenTenAndNineteen = {"ده", "یازده", "دوازده", "سیزده", "چهارده", "پانزده", "شانزده", "هفده", "هجده", "نوزده"};
        String[] first = {"", "یک", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه"};
        String[] second = {"", "", "بیست", "سی", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود"};

        int first = number % 10;
        int second = number / 10;

        if (10 <= number && number <= 19) {
            result += betweenTenAndNineteen[first]
        } else {
            if (!(second == 0)) {
                result += betweenTenAndNineteen[second]
            }
            if (!(first == 0)) {
                result += " و "
                result += betweenTenAndNineteen[first]
            }
        }


        System.out.println(result);


    }
}
