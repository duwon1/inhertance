package packA;

import java.util.Random;

public abstract class Unit {
    private String name;
    private int maxHp;
    private float hp;
    private float dmg;
    private float amr;

    public void setAmr(float amr) {
        this.amr = amr;
    }
    public void setMaxHp(int maxHp) { this.maxHp = maxHp; }
    public int getMaxHp() { return this.maxHp; }
    public float getAmr() { return this.amr; }
    public float getHp() {
        return this.hp;
    }
    public void setHp(float hp) { this.hp = hp; }
    public void setDmg(float dmg) { this.dmg = dmg; }
    public float getDmg() { return this.dmg; }
    public String getName() {
        return this.name;
    }
    public abstract void upGrade(Unit u);

    public void showSpec() {
        System.out.println("이름 : " + this.name);
        System.out.println("체력 : " + this.maxHp);
        System.out.println("공격력 : " + this.dmg);
        System.out.println("방어력 : " + this.amr);
    }

    public Unit(String name, int hp, int dmg, int amr) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.dmg = dmg;
        this.amr = amr;
    }

    public void heal(int i) {
        System.out.println(this.name + "이 체력이 "+ i + "만큼 회복되었습니다");
        this.hp += i;
    }

    public void attack(Unit u) {
        if(this.hp > 0) {
            Random r = new Random();
            float result = (float) Math.round(r.nextFloat() * 1.5f * 10) / 10;
            float totalDmg = this.dmg - u.amr + result;
            u.hp =  (float) Math.round(Math.max(0, u.hp - totalDmg) * 10) / 10;
            System.out.println(this.name + "이 " + u.name + "에게 " + totalDmg + "만큼의 피해를 입혔습니다(추가피해" + result + ")");
        }

    }

}
