package GrupProje3;

public class OyunTahtasi {
    public static void TahtaGoster() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| ");
            }

            System.out.println("| ");
        }

        System.out.println("");
    }

    public static void TabloGoster(String[][] tablo) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|"+tablo[i][j]);

            }

            System.out.println("| ");
        }

        System.out.println("");
    }

    public static boolean oyunKontrolGoster(String[][] OyunTahtasi,String player) {
        for (int i = 0; i < 3; i++) {
            if (OyunTahtasi[0][i] == player && OyunTahtasi[1][i] == player && OyunTahtasi[2][i] == player) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (OyunTahtasi[i][0] == player && OyunTahtasi[i][1] == player && OyunTahtasi[i][2] == player) {
                return true;
            }
        }

        if (OyunTahtasi[0][0] == player && OyunTahtasi[1][1] == player && OyunTahtasi[2][2] == player) {
            return true;
        }

        if (OyunTahtasi[0][2] == player && OyunTahtasi[1][1] == player && OyunTahtasi[2][0] == player) {
            return true;
        }

        return false;
    }

}
