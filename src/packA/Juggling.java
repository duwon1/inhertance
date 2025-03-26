package packA;

public class Juggling extends Unit {

    public Juggling() {
        super("저글링", 35, 5, 0);
    }

    public void amrUp() {
        setAmr(getAmr() + 1);
        System.out.println("저글링의 방어력이 1올랐습니다");
        System.out.println("저글링의 현재 방어력 : " + getAmr());
    }

}
