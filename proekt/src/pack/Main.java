package pack;

import java.io.*;
import java.util.*;

public class Main {
    private static double wallet;

    public static void main(String[] args) {
        boolean isGamerunning = true;
        boolean first = true;

        ArrayList<String> bord = new ArrayList<String>(Arrays.asList("T|", "T|", "T|", "T|", "T|", "T|", "T|",
                "C|", "C|", "C|", "St|", "St|", "St|", "I|", "I|", "I|", "P|", "P|", "P|"));
        Collections.shuffle(bord);                                   //Разбърква елементите на дъската.
        bord.add(0, "|S|");                             //Служи за осигоряването на првия
        while (isGamerunning) {                                       //елемент винаги да бъде Старт.
            for (String i : bord) {
                System.out.print(i); }
            System.out.println();
            for (String j : bord) {                                    //Движение по дъската
                if (j.equals("|S|")) {
                    if (first) {
                        wallet = 1000;                              //Гарантира че ще се дадат 1000шп само веднаш
                        first = false;
                    }
                }
                if (j.equals("C|")) {                                       //Активира шанса
                    Channs();
                }
                if (wallet <= 0) {                                               // Осигорява
                    System.out.println("Вие загубихте!");                        //   край
                    isGamerunning = false;                                       // за играта
                    break;
                } else if (j.equals("P|")) {                                // Подразбира се :)
                    wallet -= 25;
                    System.out.println("====================================================================");
                    System.out.println("Партi без загуба не е Партi. Губите 25шп\n" + "Имате:" + wallet);
                    System.out.println("====================================================================");
                } else if (j.equals("I|")) {
                    Invest();

                }
            }

        }
    }

    public static void Invest() {
        File fileRef = new File("text/Business");                         //Чете текст от папката в която
        try {                                                                      //се намитар компаниите на злото
            FileReader fileRefRd = new FileReader(fileRef);
            BufferedReader buffRed = new BufferedReader(fileRefRd);
            String line;
            while ((line = buffRed.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Вие имате"+wallet);
        Random random = new Random();
        int odds;
        Scanner scn = new Scanner(System.in);
        Scanner Inv = new Scanner(System.in);                                   //Приема парите на героя
        double invest;
        int investin = scn.nextInt();                                           //Дава избор на играча в какви тъмни
        if (investin == 1 & wallet>50) {                                        //зделки да инвестира и дали може
            System.out.println("You chose to invested in Macrosoft");
            System.out.println("How much you will invest(min=50):");
            invest = Inv.nextInt();
            odds = random.nextInt(31);
            if (odds - 20 > 0) {                                                  //Проверява дали пецелиш или губиш.
                wallet = invest * 5;                                              //Печалба
            } else {                                                             //Загуба
                wallet -= invest;
            }
        }else if (investin == 2 & wallet>400) {
            System.out.println("You chose to invested in B.A");
            System.out.println("How much you will invest(min=400):");
            invest = Inv.nextInt();
            odds = random.nextInt(61);
            if (odds - 10 > 0) {
                wallet = investin * 0.5;
            } else {
                wallet -= invest;
            }
        }else if (investin == 3&wallet>300) {
            System.out.println("You chose to invested in C.W.O");
            System.out.println("How much you will invest(min=300):");
            invest = Inv.nextInt();
            odds = random.nextInt(46);
            if (odds - 15 > 0) {
                wallet = invest * 1.5;
            } else {
                wallet -= invest;
            }
        }else if(investin==4&wallet>500) {
            System.out.println("You chose to invested in E.C");
            System.out.println("How much you will invest(min=500):");
            invest = Inv.nextInt();
            odds = random.nextInt(106);
            if (odds - 10 > 0) {
                wallet = invest * 0.2;
            } else {
                wallet -= invest;
            }
        }else if (investin==0){
            System.out.println("Следващия път щте те оберем ");
        }
        System.out.println(wallet+"Имате");
    }






    private static void Channs() {
        boolean isluckgood;
        Random rand = new Random();                                  //Проверява дали
        int ra = rand.nextInt(100);                           //днес деня ни
        if (ra % 2 == 0) isluckgood = true;                            //ще върви или няма
        else isluckgood = false;
        if (isluckgood) {
            Random ch = new Random();
            int chans = ch.nextInt(100);
            if (chans <= 39) {
                wallet += 50;
                File fileRef = new File("text/Luck");
                try {
                    FileReader fileRefRd = new FileReader(fileRef);               //Чете дани от файл
                    BufferedReader buffRed = new BufferedReader(fileRefRd);      //мислех да го ползвам
                    String line;                                                //вместо System.out
                    while ((line = buffRed.readLine()) != null) {                 //но замеа повече място
                        System.out.println(line);                               //по този начин за това го има само на
                    }                                                           //няколко места а не всички
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (65 >= chans) {
                wallet += 150;
                System.out.println("Хващате си младо гадже, малка котка с големи възможности.\n" +
                        "Получавате вечното уважение на\n" +
                        "кварталните пичове, както и легендарен статус на\n" +
                        "вечен играч.Печелите 150шп");
            } else if (79 >= chans) {
                wallet += 200;
                System.out.println("Напускате университета и \n" +
                        "ставате милионер може да се казвате Дарси. Честито Печелите 200шп");
            } else if (94 >= chans) {
                wallet += 150;
                System.out.println("Тийнейджъри представят гениална идея за рационализиране на\n" +
                        "производствените мощности. Получавате стабилен бонус: Получихте 150шп");
            } else if (100 >= chans) {
                wallet += 250;
                File fileRef = new File("text/Luck2");
                try {
                    FileReader fileRefRd = new FileReader(fileRef);
                    BufferedReader buffRed = new BufferedReader(fileRefRd);
                    String line;
                    while ((line = buffRed.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            Random ch = new Random();
            int chans = ch.nextInt(100);
            if (chans <= 39) {
                wallet -= 50;
                File fileRef = new File("text/unLuck1");
                try {
                    FileReader fileRefRd = new FileReader(fileRef);
                    BufferedReader buffRed = new BufferedReader(fileRefRd);
                    String line;
                    while ((line = buffRed.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (65 >= chans) {
                wallet -= 150;
                System.out.println("Вие сте баща на три абитуриентки,\n" +
                        "бъдете готови за стабилни разходи. Губите 150шп");
            } else if (79 >= chans) {
                wallet -= 200;
                System.out.println("Най-добрият Ви служител\n" +
                        "получава повиквателна за\n" +
                        "казармата. Губите обучен персонал. Губите 200шп");
            } else if (94 >= chans) {
                wallet -= 150;
                File fileRef = new File("text/unLuck4");
                try {
                    FileReader fileRefRd = new FileReader(fileRef);
                    BufferedReader buffRed = new BufferedReader(fileRefRd);
                    String line;
                    while ((line = buffRed.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (100 >= chans) {
                wallet -= 250;
                System.out.println("Част от бизнесите Ви фалират, \n" +
                        "заради задаваща се епидемия от потна треска.Губите 250шп");
            }
        }
        System.out.println("====================================================================");
        System.out.println("Вие имате:" + wallet + "шп");                 //Показва ни с колко ШП разполагаме
        System.out.println();


    }
}
































