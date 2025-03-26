package packA;

import java.util.Random;
import java.util.Scanner;

public class GameManger {
    public void gameStart() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Unit m = new Marine();
        Unit z = new Juggling();
        m.showSpec();
        z.showSpec();

        while(true) {
            System.out.println("1. 공격 2. 회복 3. 뻘짓 : ");
            int menu = sc.nextInt();
            if(menu == 1) {
                m.attack(z);
                z.attack(m);
            } else if(menu == 2) {
                m.heal(rand.nextInt(11));
                z.attack(m);
            } else if(menu == 3) {
                z.attack(m);
            } else {
                System.out.println("끗");
                break;
            }
            System.out.println(m.getName() + "의 체력 : " + m.getHp() + " " + z.getName() + "의 체력 : " + z.getHp());
            dieCheck(m, z);



        }
    }

    public void dieCheck(Unit m, Unit z) {
        if(m.getHp() <= 0) {
            System.out.println(m.getName() + "이 죽었습니다");
            System.exit(0);
        } else if(z.getHp() <= 0) {
            System.out.println(z.getName() + "이 죽었습니다");

            ((Juggling)z).amrUp();
            m.setHp(40); // 체력초기화
            z.setHp(35); // 체력초기화

            m.showSpec();
            z.showSpec();
        }

    }

}
