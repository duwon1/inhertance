package packA;

public class Unit {
    private String name;
    private int hp;
    private int dmg;
    private int amr;

    public void setAmr(int amr) {
        this.amr = amr;
    }

    public int getAmr() {
        return this.amr;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return this.name;
    }

    public void showSpec() {
        System.out.println("이름 : " + this.name);
        System.out.println("체력 : " + this.hp);
        System.out.println("공격력 : " + this.dmg);
        System.out.println("방어력 : " + this.amr);
    }

    public Unit(String name, int hp, int dmg, int amr) {
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
        this.amr = amr;
    }

    public void heal(int i) {
        System.out.println(this.name + "이 체력이 "+ i + "만큼 회복되었습니다");
        this.hp += i;
    }

    public void attack(Unit u) {
        if(u.hp >= 0) {
            u.hp = Math.max(0, u.hp - (this.dmg - u.amr));
            System.out.println(this.name + "이 " + u.name + "에게 " + (this.dmg - u.amr) + "만큼의 피해를 입혔습니다");
        }
    }

}
