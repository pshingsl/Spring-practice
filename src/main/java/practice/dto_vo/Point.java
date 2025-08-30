package practice.dto_vo;

import java.util.Objects;

public final class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // equals(): 객체를 동등성을 정의(두 객 체가 논리적으로 같은지 비교)
    @Override
    public boolean equals(Object o) {
        // 현재 객체 (this)와 비교대상 객체(매개변수 obj)가 같은 참조를 가르킨다면 (== 비교) true반환
        if(this == o) return true;

        // 비교대상(매개변수 o)가 null이거나 현재 객체와 다른 클래스 인스턴스면 false리턴
        if(o==null||getClass() != o.getClass()) return false;

        // 비교대상객체 형변환
        Point point =(Point)o;

        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
