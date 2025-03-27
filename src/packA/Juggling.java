package packA;

public class Juggling extends Unit {

    public Juggling() {
        super("저글링", 35, 5, 0);
    }

    public void upGrade(Unit u) {
        GameManger g = new GameManger();
        u.setAmr(getAmr() + 0.5f); // 방어력 0.5 증가
        u.setDmg(getDmg() + 1); // 공격력 1 증가

        if(g.getWinCount() % 2 == 0) {
            u.setMaxHp(u.getMaxHp() + 5); // 체력 5 증가
        }
    }

}
