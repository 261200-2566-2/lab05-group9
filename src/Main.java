
public class Main {
    public static void main(String[] args) {

        RPGcharacter p1 = new RPGcharacter("Lnwza007");
        RPGcharacter p2 = new RPGcharacter("Zoro");
        RPGcharacter p3 = new RPGcharacter("Thorfinn");
        RPGcharacter p4 = new RPGcharacter("Kirito");

        Sword s1 = new Sword("ดาบไทย",20);
        Sword s2 = new Sword("Muramasa",110,9);
        Sword s3 = new Sword("Excalibur",1000,25);
        Sword s4 = new Sword("Frostbite Edge",250,11);
        Sword s5 = new Sword("Shadow Reaper",85,4);

        Shield sh1 = new Shield("The Scutum",40,2);
        Shield sh2 = new Shield("Kite Shield",100,12);
        Shield sh3 = new Shield("The Aegis",450,25);
        Shield sh4 = new Shield("Emberguard Shield",70,5);
        Shield sh5 = new Shield("Viper's Shieldwall",30);

        Wrist w1 = new Wrist("Seraph Wristblade",4);
        Wrist w2 = new Wrist("Thorne Wristlock",2);
        Wrist w3 = new Wrist("Nebula Wristnova",5);
        Wrist w4 = new Wrist("Zephyr Wristwhisper",10);
        Wrist w5 = new Wrist("Celestia Wristlight",7);

        Clothing c1 = new Clothing("Celestial Vestments",3);
        Clothing c2 = new Clothing("Lunar Veil Cloak",4);
        Clothing c3 = new Clothing("Obsidian Blackplate",7);
        Clothing c4 = new Clothing("Lunar Veil Cloak",1);
        Clothing c5 = new Clothing("Thunder Raiment",8);

        Ring r1 = new Ring("Arcane Whisper Band",3);
        Ring r2 = new Ring("Enigmatic Onyx Band",5);
        Ring r3 = new Ring("Verdant Vitality Ring",9);
        Ring r4 = new Ring("Resonance Ring",6);
        Ring r5 = new Ring("Frostbite Circlet",8);


        RPGcharacter.AddAccessories(r1,c1,w1);
        RPGcharacter.AddAccessories(r2,c2,w2);
        RPGcharacter.AddAccessories(r3,c3,w3);
        RPGcharacter.AddAccessories(r4,c4,w4);
        RPGcharacter.AddAccessories(r5,c5,w5);

        RPGcharacter.AddSwordandShield(s1,sh1);
        RPGcharacter.AddSwordandShield(s2,sh2);
        RPGcharacter.AddSwordandShield(s3,sh3);
        RPGcharacter.AddSwordandShield(s4,sh4);
        RPGcharacter.AddSwordandShield(s5,sh5);
        //add all accessories in to global inventory

        //RPGcharacter.PrintSword();

        RPGcharacter.Start();
        RPGcharacter.PrintSword();


//        p1.AddItem(s1);
//        p1.AddItem(s2);
//        p1.AddItem(s3);
//        p1.AddItem(sh1);
//        p1.AddItem(sh2);
//        p1.AddItem(sh3);

//        p2.AddItem(s2);
//        p2.AddItem(s3);
//
//        p4.AddItem(s1);


        //p1.PrintStatus();
        //p2.PrintStatus();
        //p3.PrintStatus();
        //p4.PrintStatus();



//        //test p1 lv up to 25 and try to use Excalibur(lv 25)
//        p1.SelectJob();
//        p1.getEXP(3000);
//        //p1.Hold();
//        //p1.PrintStatus();
//         p1.PlayWith(p3);
//        //p1.SelectJob();
//
//        p2.Attack(p1);
//        p1.PrintStatus();
    //    p1.Heal();
//        p1.Heal();
//        p1.PrintStatus();
        //test p2 lv up to 2 and try to use Excalibur(lv 25) it can not use because lv lower than sword lv
//        p2.getEXP(1000);
//        p2.Hold();
//        p2.PrintStatus();

        //test p3 try to use item but Empty slot
        //p3.Hold();

        //test p4 have only sword but no shield
        //p4.Hold();
        //p4.PrintStatus();

    }
}