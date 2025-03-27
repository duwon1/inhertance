package packA;

import java.util.Random;
import java.util.Scanner;

public class GameManger {
    private static int winCount = 0;
    public int getWinCount() { return this.winCount; }
    public void gameStart() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Unit m = new Marine();
        Unit z = new Juggling();
        m.showSpec();
        z.showSpec();

        while(true) {
            System.out.println("=====================================");
            System.out.println("1. 공격 2. 회복 3. 아무것도 안하기 : ");
            int menu = sc.nextInt();
            if(menu == 1) {
                m.attack(z);
                z.attack(m);
            } else if(menu == 2) {
                m.heal(rand.nextInt(-5,20));
                z.attack(m);
            } else if(menu == 3) {
                z.attack(m);
            } else {
                System.out.println("끗");
                break;
            }
            System.out.println(m.getName() + "의 체력 : " + m.getHp() + " " + z.getName() + "의 체력 : " + z.getHp());
            hpChack(m, z);

        }
    }

    public void hpChack(Unit m, Unit z) {
        if(m.getHp() <= 0) {
            System.out.println(m.getName() + "이 죽었습니다");
            System.exit(0);
        } else if(z.getHp() <= 0) {
            System.out.println(z.getName() + "이 죽었습니다");
            System.out.println("현재까지" + ++winCount + "번 승리했습니다");
            z.upGrade(z);
            m.upGrade(m);

            m.setHp(m.getMaxHp()); // 마린 풀피로 채우기
            z.setHp(z.getMaxHp()); // 저글링 풀피로 채우기

            m.showSpec();
            z.showSpec();

        }
    }


}
