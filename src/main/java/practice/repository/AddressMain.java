package practice.repository;

public class AddressMain {
    public static void main(String[] args) {
        AddressVO a1 = new AddressVO("Seoul", "Gangnam-daero", "(06236)");
        AddressVO a2 = new AddressVO("Seoul", "Gangnam-daero", "(06236)");
        AddressVO a3 = new AddressVO("Seoul", "Mapo-daero", "(06452)");

        System.out.println(a1);
        System.out.println(a2);

        if (a1.equals(a2)) {
            System.out.println("두 주소는 같습니다.");
        } else {
            System.out.println("두 주소는 다릅니다.");
        }

        System.out.println();
        System.out.println(a2);
        System.out.println(a3);
        if (a2.equals(a3)) {
            System.out.println("두 주소는 같습니다.");
        } else {
            System.out.println("두 주소는 다릅니다.");
        }
    }
}
