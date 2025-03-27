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

    public void heal() {
        Random r = new Random();
        int result = r.nextInt(-5,20);
        System.out.println(this.name + "이 체력이 "+ result + "만큼 회복되었습니다");
        this.hp += result;
    }

    public void attack(Unit u) {
        if (this.hp > 0) {
            if (move()) { // 회피 성공
                System.out.println(u.name + "이 " + this.name + "의 공격을 회피했습니다");
            } else {
                Random r = new Random();
                float result = (float) Math.round(r.nextFloat() * 1.5f * 10) / 10; // 0.0 ~ 1.5 사이 랜덤값을 가져옴.(추가데미지)
                float totalDmg = this.dmg - u.amr + result; // 방어력과 데미지 추가데미지를 계산
                u.hp = (float) Math.round(Math.max(0, u.hp - totalDmg) * 10) / 10; // HP가 0보다 작아지지않도록 보정 및 부동소수점 해결
                System.out.println(this.name + "이 " + u.name + "에게 " + totalDmg + "만큼의 피해를 입혔습니다(추가피해" + result + ")");
            }


        }

    }

    public boolean move () {
        Random r = new Random();
        float rand = r.nextFloat();
        boolean result;
        if (rand <= 0.3) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

}
