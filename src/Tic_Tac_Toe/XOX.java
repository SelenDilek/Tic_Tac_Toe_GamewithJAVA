package Tic_Tac_Toe;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Scanner;

public class XOX {

   static int  koordinatX1;
    static int koordinatX2;
    static  int koordinatO1;
    static  int koordinatO2;
    static ArrayList<String> kullanici1Bilgisi = new ArrayList<>(); //buraya kullanicin girdigi X leri attim ki yazdirabileym (XXX)
    //(ArrayList boyutu en az 2 olunca) en az 3 giris yapinca kazanma durumlari gelecek
    static ArrayList<String> kullanici2Bilgisi = new ArrayList<>(); //buraya kullanicin girdigi O lari attim ki yazdirabileym cunku
    //en az 3 tane giris yapacak(ArrayListe boyutu en az 2 olunca) ki kazanma durumu ortaya ciksin. (OOO) OLUNCA KAZANMA DURUMU ORTAYA CIKACAK.
    static int kullanici1HamleSayisi=0;
    static int kullanici2HamleSayisi=0;

    static int sayacX=0;
    static int sayacO=0;
    static String oyunTahtasi[][] = new String[3][3];
    static  String oyundanCikilsinMi;


    public static void main(String[] args) {

         //Oyun tahtasi //X ve O yazacak
        Scanner okuStrInt = new Scanner(System.in);
        boolean oyunDurumu = true;




        do{
            //Kullanicilar sirasi ile hamle yapacak ve dongu saglanana kadar devam edecek.

            // ----- KULLANICI BIR ----
           Kullanici1KoordinatIste(okuStrInt);

            if(((koordinatX1<3 && koordinatX2 <3) && (koordinatX1>=0 && koordinatX2 >=0)) || (! (koordinatX1==koordinatO1 && koordinatX2==koordinatO2))) {
                oyunTahtasi[koordinatX1][koordinatX2]="X" ; //OYUN TAHATASINA kullanicinin girdigi koordinata X EKLE (3.soru birinci kisim icin)
                kullanici1Bilgisi.add("X");
                kullanici1HamleSayisi++; //ekrana her "X" basildiginda hamle sayisi bir artacak
                System.out.println("Birinci kullanicin koordinat1'i ->" + "[" + koordinatX1 +"]" +" " + "Birinci kullanicin koordinat2'si ->"+"[" +  koordinatX2+ "]" );//HER HAMLEDEN SONRA OYUN TAHTASINI EKRANA BASIN
                System.out.println( oyunTahtasi[koordinatX1][koordinatX2]);



            }

            else {
                System.out.println("Yanlis koordinat girdiniz tekrar koordinatlari giriniz= ");
                Kullanici1KoordinatIste(okuStrInt);

            }


            //  ----- KULLANICI IKI ----

            Kullanici2KoordinatIste(okuStrInt);
            if(((koordinatO1<3 && koordinatO2 <3) && (koordinatO1>=0 && koordinatO2 >=0)) || (! (koordinatX1==koordinatO1 && koordinatX2==koordinatO2))) {
               //kullanici yanlis koordinat girmesin ve ayni girilmis koordinatlari girmesin.
                oyunTahtasi[koordinatO1][koordinatO2]="O" ; // //OYUN TAHATASINA 2.kullanicinin girdigi koordinata O EKLE
                kullanici2Bilgisi.add("O");
                kullanici2HamleSayisi++; //ekrana her "O" basildiginda hamle sayisi bir artacak
                System.out.println("Ikinci kullanicin koordinat1'i ->" + "[" + koordinatO1 + "]" +" " + "Ikinci kullanicin koordinat2'si ->" +"[" + koordinatO2+ "]" );//HER HAMLEDEN SONRA OYUN TAHTASINI EKRANA BASIN
                System.out.println( oyunTahtasi[koordinatO1][koordinatO2]);

            }

            else {
                System.out.println("Yanlis koordinat girdiniz tekrar koordinatlari giriniz= ");
                Kullanici2KoordinatIste(okuStrInt);
            }

            //iki kullanici oynadiktan sonra ekrana son durum ve kazanma durumlarinin yazilmasi.



            System.out.println("Oyundan cikmak ister misiniz? E/H");
            oyundanCikilsinMi=okuStrInt.next(); //kullanici oyunu birakmak isterse; Kullanici E girerse oyun tamamlanmamis bile olsa cikip son durumu yazdiracak.
            if(oyundanCikilsinMi.equalsIgnoreCase("H")){

                oyunDurumu=false; //oyun devam eder..
            }
            else if(oyundanCikilsinMi.equalsIgnoreCase("E")){

                oyunDurumu=true; //oyun biter..
            }

            //X veya O kullanicisi en az 3 hamle yapinca
                //bu dongu calisacak




            System.out.println("Oyun son durumu X oyuncusu = " + sayacX);
            System.out.println("Oyun son durumu O oyuncusu = " + sayacO);




        }while ((! oyunDurumu) || (kullanici1HamleSayisi+kullanici2HamleSayisi==9) ); //hamle sayisi dolunca oyun sona erecek ve kazanan belirlenecek.

        System.out.println("*********OYUN BITTI************");
        System.out.println("----KAZANAN OYUNCU---");
        System.out.println(kullanici1Bilgisi);
        System.out.println(kullanici2Bilgisi);




        if(sayacX>sayacO){
            System.out.println(" --X-- OYUNCUSU KAZANDI! TEBRIKLER...  SONUCUNUZ= " + sayacX);
        }
        else
        {
            System.out.println("--O-- OYUNCUSU KAZANDI! TEBRIKLER...  SONUCUNUZ= " + sayacO);
        }



        //sonuc ksiimlari

    }


    public static  void Kullanici1KoordinatIste(Scanner scan){



        System.out.print("X kullanicisi ; Birinci koordinat bilgisini giriniz = ");
        koordinatX1 = scan.nextInt();
        System.out.print("X kullanicisi ; Ikinci koordinat bilgisini giriniz = ");
        koordinatX2 = scan.nextInt();

    }

    public static  void Kullanici2KoordinatIste(Scanner scan){



        System.out.print("O kullanicisi ; Birinci koordinat bilgisini giriniz = ");
         koordinatO1 = scan.nextInt();
        System.out.print("O kullanicisi ; Ikinci koordinat bilgisini giriniz = ");
        koordinatO2 = scan.nextInt();

    }

    public static void oyunSonDurum(){
        System.out.println();
        System.out.println("***Oyun Durumu***");

        //**********************************************************1.KULLANICI KAZANMA DURUMLARI****************************************************************************

       while (((kullanici1Bilgisi.size() >=2 ) || (kullanici2Bilgisi.size() >=2 ))){ //X veya O kullanicisi en az 3 hamle yapinca
            //bu dongu calisacak
            if(kullanici1Bilgisi.get(0).equalsIgnoreCase("X") && kullanici1Bilgisi.get(1).equalsIgnoreCase("X") && kullanici1Bilgisi.get(2).equalsIgnoreCase("X")) {
                //ilk if kullanicin 3 tane girmesi durumunda degerlendirme olacagini soyluyor ve asagida secenekler cikiyor kazanmasi icin
                if (((oyunTahtasi[0][0]).equalsIgnoreCase("X") && (oyunTahtasi[0][1]).equalsIgnoreCase("X") && (oyunTahtasi[0][2]).equalsIgnoreCase("X"))) {
                    sayacX++;
                    System.out.println("Kullanici X kazandiniz : --XXX --  " +
                            "Son durumunuz= " + sayacX);

                } else if (((oyunTahtasi[1][0]).equalsIgnoreCase("O") && (oyunTahtasi[1][1]).equalsIgnoreCase("O") && (oyunTahtasi[1][2]).equalsIgnoreCase("O"))) {

                    sayacX++;
                    System.out.println("Kullanici X kazandiniz : --XXX --  " +
                            "Son durumunuz= " + sayacX);

                } else if (((oyunTahtasi[2][0]).equalsIgnoreCase("O") && (oyunTahtasi[2][1]).equalsIgnoreCase("O") && (oyunTahtasi[2][2]).equalsIgnoreCase("O"))) {

                    sayacX++;
                    System.out.println("Kullanici X kazandiniz : --XXX --  " +
                            "Son durumunuz= " + sayacX);

                } else if (((oyunTahtasi[0][0]).equalsIgnoreCase("O") && (oyunTahtasi[1][1]).equalsIgnoreCase("O") && (oyunTahtasi[2][2]).equalsIgnoreCase("O"))) {

                    sayacX++;
                    System.out.println("Kullanici X kazandiniz : --XXX --  " +
                            "Son durumunuz= " + sayacX);

                } else if (((oyunTahtasi[0][0]).equalsIgnoreCase("O") && (oyunTahtasi[1][0]).equalsIgnoreCase("O") && (oyunTahtasi[2][0]).equalsIgnoreCase("O"))) {

                    sayacX++;
                    System.out.println("Kullanici X kazandiniz : --XXX --  " +
                            "Son durumunuz= " + sayacX);

                } else if (((oyunTahtasi[0][1]).equalsIgnoreCase("O") && (oyunTahtasi[1][1]).equalsIgnoreCase("O") && (oyunTahtasi[2][1]).equalsIgnoreCase("O"))) {

                    sayacX++;
                    System.out.println("Kullanici X kazandiniz : --XXX --  " +
                            "Son durumunuz= " + sayacX);

                } else if (((oyunTahtasi[0][2]).equalsIgnoreCase("O") && (oyunTahtasi[1][2]).equalsIgnoreCase("O") && (oyunTahtasi[2][2]).equalsIgnoreCase("O"))) {

                    sayacX++;
                    System.out.println("Kullanici X kazandiniz : --XXX--  " +
                            "Son durumunuz= " + sayacX);

                }
            }
                //**********************************************************2.KULLANICI KAZANMA DURUMLARI****************************************************************************


                else if (kullanici2Bilgisi.get(0).equalsIgnoreCase("O") &&kullanici2Bilgisi.get(1).equalsIgnoreCase("O")&&kullanici2Bilgisi.get(2).equalsIgnoreCase("O")){
                    //Bu else if kullanicin 3 tane  girmesi durumunda degerlendirme olacagini soyluyor ve asagida secenekler cikiyor kazanmasi icin

                    if(((oyunTahtasi[0][0]).equalsIgnoreCase("O") && (oyunTahtasi[0][1]).equalsIgnoreCase("O") &&(oyunTahtasi[0][2]).equalsIgnoreCase("O"))){
                        sayacO++;
                        System.out.println("Kullanici O kazandiniz : --OOO --  " +
                                "Son durumunuz= " + sayacO);

                    } else if (((oyunTahtasi[1][0]).equalsIgnoreCase("O") && (oyunTahtasi[1][1]).equalsIgnoreCase("O") &&(oyunTahtasi[1][2]).equalsIgnoreCase("O"))) {

                        sayacO++;
                        System.out.println("Kullanici O kazandiniz : --OOO --  " +
                                "Son durumunuz= " + sayacO);

                    }

                    else if (((oyunTahtasi[2][0]).equalsIgnoreCase("O") && (oyunTahtasi[2][1]).equalsIgnoreCase("O") &&(oyunTahtasi[2][2]).equalsIgnoreCase("O"))) {

                        sayacO++;
                        System.out.println("Kullanici O kazandiniz : --OOO --  " +
                                "Son durumunuz= " + sayacO);

                    }
                    else if (((oyunTahtasi[0][0]).equalsIgnoreCase("O") && (oyunTahtasi[1][1]).equalsIgnoreCase("O") &&(oyunTahtasi[2][2]).equalsIgnoreCase("O"))) {

                        sayacO++;
                        System.out.println("Kullanici O kazandiniz : --OOO --  " +
                                "Son durumunuz= " + sayacO);

                    }
                    else if (((oyunTahtasi[0][0]).equalsIgnoreCase("O") && (oyunTahtasi[1][0]).equalsIgnoreCase("O") &&(oyunTahtasi[2][0]).equalsIgnoreCase("O"))) {

                        sayacO++;
                        System.out.println("Kullanici O kazandiniz : --OOO --  " +
                                "Son durumunuz= " + sayacO);

                    }
                    else if (((oyunTahtasi[0][1]).equalsIgnoreCase("O") && (oyunTahtasi[1][1]).equalsIgnoreCase("O") &&(oyunTahtasi[2][1]).equalsIgnoreCase("O"))) {

                        sayacO++;
                        System.out.println("Kullanici O kazandiniz : --OOO --  " +
                                "Son durumunuz= " + sayacO);

                    }
                    else if (((oyunTahtasi[0][2]).equalsIgnoreCase("O") && (oyunTahtasi[1][2]).equalsIgnoreCase("O") &&(oyunTahtasi[2][2]).equalsIgnoreCase("O"))) {

                        sayacO++;
                        System.out.println("Kullanici O kazandiniz : --OOO --  " +
                                "Son durumunuz= " + sayacO);

                    }


               }



            }




        }



    }


    //public ..

