package practice.controller.thymeleaf;

import practice.dto_vo.BookDTO;

public class BookEx {
    public static void main(String[] args) {
        BookDTO b1 = new BookDTO("Effective Java", "Joshua Bloch", 35000);
        BookDTO b2 = new BookDTO("Clean Code", "Robert C. Martin", 45000);
        System.out.println(b1.toString());
        System.out.println(b2.toString());
    }
}
