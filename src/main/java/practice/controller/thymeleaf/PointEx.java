package practice.controller.thymeleaf;

import practice.dto_vo.Point;

public class PointEx {
    public static void main(String[] args) {
        // 포인트 클래스에서 toString을 안해서 객체의 주소값이 나옴
        Point p1 = new Point(0, 0);
        System.out.println("p1 = " + p1);
        Point p2 = new Point(3, 4);
        System.out.println("p2 = " + p2);


        Point p3 = new Point(3, 4);
        System.out.println("p1(0, 0) vs. p2(3, 4) = " + p1.equals(p2)); // false
        System.out.println("p2(3, 4) vs. p3(3, 4) = " + p2.equals(p3)); // false
        // false난 이유 equals와 hashCode를 오버라이드를 하지 않아서 에러남

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
    }
}
