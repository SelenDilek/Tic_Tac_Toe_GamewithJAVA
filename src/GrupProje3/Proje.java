package GrupProje3;

import java.util.Scanner;

public class Proje {
    public static void main(String[] args) {
        // Kullanıcıdan giriş alınacağı için scanner tanımladık
        Scanner okuInt = new Scanner(System.in);
        Scanner okuStr = new Scanner(System.in);

        // Oyuncuları tanımladık
        Player oyuncu1 = new Player("X");
        Player oyuncu2 = new Player("O");

        // Tekrar oyna seçeneği varsayılan değer atadık
        // kullanıcı tekrar oynamak istermisiniz sorusuna
        // hayır cevabı verince bu değeri true yaptık
        // oyunu başlatan while döngümüz kırılmış oldu böylelikle
        boolean tekraroyna = false;

        // 1. ve 2. oyuncu için galibiyet sayılarını tutmak için
        // 2 ayrı değişken atadık
        int galibiyet1=0;
        int galibiyet2=0;

        // oyun döngümüzü başlattık
        while (!tekraroyna) {
            System.out.println("Oyun başlıyor...");

            // kazananı tutacak değişkeni belirledik
            int kazanan = 0;

            // Boş oyun tahtasını gösterdik
            OyunTahtasi.TahtaGoster();

            // maksimum hamle sayısı kadar kullanıcı giriş yapabilir
            // döngü içinde istenen şart sağlanırsa bu foru bitirdik
            int maxhamle = 9;

            // oyun her yeniden başladığında tabloyu yeniden tanımladık
            String[][] tablo = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

            // maks hamle sayısı kadar döngü başlattık
            for (int i = 0; i < maxhamle; i++) {
                // satır ve sutun kontrolu için kontrol değişkeni oluşturduk
                boolean girilenDogrumu = false;

                // girilen sütun satır yanlış olduğu sürece döngüye soktuk
                while (!girilenDogrumu) {
                    // i tek sayı ise 1.oyuncu
                    // çift sayı ise 2.oyuncu hakkı için
                    // şart koyduk
                    if (i % 2 == 0) {
                        System.out.println("1.Oyuncu Hamle Sırası");
                    } else {
                        System.out.println("2.Oyuncu Hamle Sırası");
                    }

                    int satir = 0;
                    int sutun = 0;

                    // satır sutun kontrolü yaptık
                    boolean inputCorrect = false;

                    while (!inputCorrect) { //input Correct ture oldugu surece dongu donsun
                        System.out.print("Satır seçin: ");
                        satir = okuInt.nextInt();

                        switch (satir) {
                            case 0:
                            case 1:
                            case 2:
                                inputCorrect = true;//0,1,2 degerlerimiz dogru giris oldugu icin bu girisler girildigi surece  inputCorrect = true olsun yani dongu kirilmasin
                                break;
                            default:
                                System.out.println("Geçersiz giriş.");
                                break;
                        }
                    }

                    while (inputCorrect) { //input Correct false oldugu surece dongu donsun
                        System.out.print("Sutun seçin: ");
                        sutun = okuInt.nextInt();

                        switch (sutun) {
                            case 0:
                            case 1:
                            case 2:
                                inputCorrect = false;////0,1,2 degerlerimiz dogru giris oldugu icin bu girisler girildigi surece  inputCorrect = false olsun yani dongu kirilmasin,devam etsin
                                break;
                            default:
                                System.out.println("Geçersiz giriş.");
                                break;
                        }
                    }

                    // girilen satır ve sütüna daha önce değer atanıp
                    // atanmadığını kontrol ettik
                    if (tablo[satir][sutun].equals(" ")) {
                        if (i % 2 == 0) {
                            tablo[satir][sutun] = "X";
                            if (OyunTahtasi.oyunKontrolGoster(tablo, "X")) {
                                //if in ici true oldugu surece
                                kazanan = 1;
                                galibiyet1++;
                                i = maxhamle;
                            }
                        } else {
                            tablo[satir][sutun] = "O";
                            if (OyunTahtasi.oyunKontrolGoster(tablo, "O")) {
                                kazanan = 2;
                                galibiyet2++;
                                i = maxhamle;
                            }
                        }

                        girilenDogrumu = true;
                    }
                }

                // hamleden sonra oyun tahtasını gösterdik
                OyunTahtasi.TabloGoster(tablo);
            }


            // kazananı belirleyen şartlarımızı yazdık
            if (kazanan == 1) {
                System.out.println("1.Oyuncu Tebrikler!");
                System.out.println(galibiyet1+ " kez kazandınız.");
            }

            if (kazanan == 2) {
                System.out.println("2.Oyuncu Tebrikler!");
                System.out.println(galibiyet2+ " kez kazandınız.");
            }

            if (kazanan == 0) {
                System.out.println("Oyun berabere bitti.");
            }

            // oyunun tekrar oynanabilmesi için soru sorduk
            // bu değere göre super while döngümüzü tekrar başlatıyoruz
            // veya bitiriyoruz
            System.out.print("Tekrar oynamak istermisiniz (EVET/HAYIR): ");
            String cevap = okuStr.nextLine();

            if (cevap.equalsIgnoreCase("hayır")) {
                tekraroyna = true; //?????
            }
        }

        // program bittikten sonra hangi oyuncunun
        // toplamda kaç defa kazandığını gösterdik
        System.out.println("1.Oyuncu "+galibiyet1+" kez kazandınız.");
        System.out.println("2.Oyuncu "+galibiyet2+" kez kazandınız.");

        // en çok hangi oyuncu kazanmışsa
        // onu tebrik ettik
        if (galibiyet1>galibiyet2){
            System.out.println("1.Oyuncu Kralsın!");
        }else{
            System.out.println("2.Oyuncu Kralsın!");
        }

        // PROGRAM BİTTİ
        // Techno Study Batch 4 Grup 5
    }
}
