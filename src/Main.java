public class Main {

    public static int bossHeals = 600;
    public static int bossDamage = 20;
    public static int[] heroHeals = {120, 150, 200, 100};
    public static int[] heroDamage = {15, 15, 20, 0};
    public static String[] heroAttackType = {" Warrior", "Magick", "Telepan", " Medic"};

    public static void printStatistics() {
        System.out.println("STATISTIC");
        System.out.println("BOSS HEALS " + bossHeals + ";" + " damage " + bossDamage);
        for (int i = 0; i < heroAttackType.length; i++) {
            System.out.println(" Hero heals " + heroAttackType[i]
                    + " " + heroHeals[i] + "; damage " + heroDamage[i]);

        }
    }

    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            round();
        }
    }

    public static boolean isGameFinished() {
        boolean allHerosDead = true;
        if (bossHeals <= 0) {
            System.out.println("HERDOES WIN!!!!");
            return true;
        }
        for (int i = 0; i < heroHeals.length; i++) {
            if (heroHeals[i] > 0) {
                allHerosDead = false;
                break;
            }
        }
        if (allHerosDead) {
            System.out.println("Boss win");
        }
        return allHerosDead;
    }

    public static void bossHits() {
        for (int i = 0; i < heroAttackType.length; i++) {
            for (int j = 0; j < heroAttackType.length; j++) {
            }
            if (bossHeals > 0) {
                if (heroHeals[i] < bossDamage) {
                    bossHeals = 0;
                } else {
                    heroHeals[i] = heroHeals[i] - bossDamage;
                }
            }
        }
    }

    public static void heroHits() {
        for (int i = 0; i < heroAttackType.length; i++) {
            for (int j = 0; j < heroAttackType.length; j++) {
                if (heroHeals[i] > 0) {
                    if (bossHeals < heroDamage[i]) {
                        bossHeals = 0;
                    } else {
                        bossHeals = bossHeals - heroDamage[i];
                    }
                }
            }
        }
    }

    public static void medic() {
        boolean medicA = false;
        medicA = false;
        for (int i = 0; i < heroAttackType.length; i++) {
            if (heroHeals[i] > 0 && heroAttackType[i].equals("Medic")) {
                medicA = true;
            }
        }
        for (int i = 0; i < heroAttackType.length; i++) {
            if (heroHeals[i] < 100 && heroHeals[i] > 0) {
                heroHeals[i] = heroHeals[i] + 100;
                System.out.println("The medic cured " + heroAttackType[i]);
                break;
            }
        }
    }

    public static void round() {
        System.out.println("ROUND - +");
        bossHits();
        heroHits();
        medic();
        printStatistics();
    }
}