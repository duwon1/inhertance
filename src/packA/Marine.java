package packA;

import java.util.Random;
import java.util.Scanner;

public class Marine extends Unit {
    private boolean upGrade = false;

    public Marine() {
        super("마린", 40, 6, 0);
    }

    @Override
    public void upGrade(Unit u) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("=====================================");
        System.out.println("1. 공격력 증가 2. 체력증가 3. 방어력 증가 : " );
        int menu = sc.nextInt();

        if(r.nextInt(2) == 1 || upGrade) {
            int upW =  r.nextInt(3);
            System.out.println("당신의 능력이" + upW + "만큼 곱해져서 증가합니다!!");

            if(menu == 1) {
                u.setDmg(u.getDmg() + (1.5f * upW));
                System.out.println("공격력이" + (1.5f * upW) + "만큼 증가하였습니다");
            } else if(menu == 2) {
                u.setMaxHp(u.getMaxHp() + (10 * upW));
                System.out.println("체력이" + (10 * upW)  + "만큼 증가하였습니다");
            } else if(menu == 3) {
                u.setAmr(u.getAmr() + upW);
                System.out.println("방어력이" + (upW) + "만큼 증가하였습니다");
            }
            upGrade = false;
        } else {
            System.out.println("강화실패(다음강화는 100%확률로 성공합니다)");
            upGrade = true;
        }


    }

}
