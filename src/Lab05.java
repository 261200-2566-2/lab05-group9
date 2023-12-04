public class Lab05 {
    public static void main(String[] args) {
        Sword s1 = new Sword("ดาบไทย",20);
        Sword s2 = new Sword("Muramasa",18);
        Sword s3 = new Sword("Excalibur",600,11);
        Sword s4 = new Sword("Frostbite Edge",1050,25);
        Sword s5 = new Sword("Shadow Reaper",2000,30);

        Shield sh1 = new Shield("The Scutum",40);
        Shield sh2 = new Shield("Kite Shield",50);
        Shield sh3 = new Shield("The Aegis",90,5);
        Shield sh4 = new Shield("Emberguard Shield",470,25);
        Shield sh5 = new Shield("Viper's Shieldwall",1000,40);

        Wrist w1 = new Wrist("Seraph Wristblade");
        Wrist w2 = new Wrist("Thorne Wristlock");
        Wrist w3 = new Wrist("Nebula Wristnova",5);
        Wrist w4 = new Wrist("Zephyr Wristwhisper",8);
        Wrist w5 = new Wrist("Celestia Wristlight",10);

        Clothing c1 = new Clothing("Celestial Vestments");
        Clothing c2 = new Clothing("Lunar Veil Cloak");
        Clothing c3 = new Clothing("Obsidian Blackplate",5);
        Clothing c4 = new Clothing("Lunar Veil Cloak",8);
        Clothing c5 = new Clothing("Thunder Raiment",10);

        Ring r1 = new Ring("Arcane Whisper Band");
        Ring r2 = new Ring("Enigmatic Onyx Band");
        Ring r3 = new Ring("Verdant Vitality Ring",9);
        Ring r4 = new Ring("Resonance Ring",10);
        Ring r5 = new Ring("Frostbite Circlet",12);


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

        RPGcharacter.Start();
    }
}
