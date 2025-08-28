package practice.controller.thymeleaf;

import practice.dto_vo.AddressVO;

public class AddressVoEx {
    public static void main(String[] args) {
        AddressVO addr1 = new AddressVO("Seoul", "Gangnam-daero", "06236");
        AddressVO addr2 = new AddressVO("Seoul", "Gangnam-daero", "06236");
        AddressVO addr3 = new AddressVO("Seoul", "Mapo-daero", "06452");

        System.out.println(addr1);
        System.out.println(addr2);
        System.out.println();
        if(addr1.equals(addr2)){
            System.out.println("두 주소는 같습니다.");
        }

        System.out.println(addr2);
        System.out.println(addr3);
        if(addr2.equals(addr3)){
            System.out.println("두 주소는 다릅니다.");
        }
    }
}
