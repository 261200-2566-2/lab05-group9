

import java.util.Scanner;


public class RPGcharacter implements Action,Sex {
    private static Clothing[] AllClothing = new Clothing[5];
    private static Ring[] AllRing = new Ring[5];
    private static Wrist[] AllWrist = new Wrist[5];
    private static Sword[] sword = new Sword[5];
    private static Shield[] shield = new Shield[5];
    private static int Csize, Rsize, Wsize;
    private static int Swsize, SHsize;
    protected String name, sex;
    protected String job;
    private int level, CurrentLevel;
    protected int MaxHp, MaxMana;
    protected double CurrentHp, CurrentMana;
    protected double damage, defense;
    protected double CurrentAtk, CurrentDef;
    protected double MaxSpeed;
    protected double baseSpeed;
    protected double dmg;
    private double CurrentExp;
    private int MaxExp;
    private Sword currentSword;
    private Shield currentShield;
    private Ring ring;
    private Wrist wrist;
    private Clothing clothing;
    private AllJob CurrentJob = new AllJob();

    RPGcharacter(String name) {
        this.name = name;
        level = 1;
        MaxHp = 100;
        CurrentHp = MaxHp;
        MaxMana = 100;
        CurrentMana = MaxMana;
        damage = 50;
        CurrentAtk = damage;
        defense = 10;
        CurrentDef = defense;
        MaxSpeed = 100;
        baseSpeed = MaxSpeed;
        CurrentExp = 0;
        MaxExp = 500;
    }

    public static void AddAccessories(Ring r, Clothing c, Wrist w) {
        AllRing[Rsize] = r;
        Rsize++;
        AllClothing[Csize] = c;
        Csize++;
        AllWrist[Wsize] = w;
        Wsize++;
        if (Rsize == 5 || Wsize == 5 || Csize == 5) {
            System.out.println("All accessories full");
        }
    }

    public static void AddSwordandShield(Sword sw, Shield sh) {
        sword[Swsize] = sw;
        Swsize++;
        shield[SHsize] = sh;
        SHsize++;
    }

    public static void Start() {
        System.out.println("+------------------------------------+");
        System.out.println("|     WELCOME TO CPE GROUP9 GAME     |");
        System.out.println("+------------------------------------+");
        System.out.println();
        Scanner sc = new Scanner((System.in));
        System.out.print("Enter player 1 name : ");
        String nameP1 = sc.nextLine();
        if (nameP1.isEmpty() || nameP1.equals(" ")) nameP1 = "Unknown player1";
        RPGcharacter p1 = new RPGcharacter(nameP1);
        System.out.print("Enter player 2 name : ");
        String nameP2 = sc.nextLine();
        if (nameP2.isEmpty() || nameP2.equals(" ")) nameP2 = "Unknown player2";
        RPGcharacter p2 = new RPGcharacter(nameP2);
        System.out.println();
        // Enter name

        System.out.println("+-- Choose your character's gender --+");
        System.out.println(" [1] Male  [2] Female [3] Other gender");
        System.out.print("[ " + p1.name + " ]" + " choose your gender : ");
        String gen1 = sc.nextLine();
        p1.SelectSex(gen1);
        System.out.print("[ " + p2.name + " ]" + " choose your gender : ");
        String gen2 = sc.nextLine();
        p2.SelectSex(gen2);
        System.out.println();
        // Enter gender

        System.out.println("+----- Choose character's career ----+");
        System.out.println(" [1] Swordsman  [2] Archer [3] Assassin");
        System.out.print("[ " + p1.name + " ]" + " choose your career : ");
        String Job1 = sc.nextLine();
        p1.SelectJob(Job1);
        System.out.print("[ " + p2.name + " ]" + " choose your career : ");
        String Job2 = sc.nextLine();
        p2.SelectJob(Job2);
        System.out.println();
        // Enter career

        System.out.println("+--- Enter EXP you want to increase ---+");
        System.out.print("[ " + p1.name + " ]" + " Enter your EXP : ");
        double exp1 = Double.parseDouble(sc.nextLine());
        p1.getEXP(exp1);
        System.out.print("[ " + p2.name + " ]" + " Enter your EXP : ");
        double exp2 = Double.parseDouble(sc.nextLine());
        p2.getEXP(exp2);
        System.out.println();
        System.out.println("+----- Choose character's sword ----+");
        System.out.println("[ " + p1.name + " ]" + " choose your sword");
        p1.SelectSword();
        System.out.println("[ " + p2.name + " ]" + " choose your sword");
        p2.SelectSword();
        System.out.println("+----- Choose character's shield ----+");
        System.out.println("[ " + p1.name + " ]" + " choose your shield");
        p1.SelectShield();
        System.out.println("[ " + p2.name + " ]" + " choose your shield");
        p2.SelectShield();

        p1.AccessoriesChoice();
        p2.AccessoriesChoice();

        p1.PrintStatus();
        p2.PrintStatus();

        System.out.println("+-------------- BATTLE -------------+" + "\n");
            p1.SelectBattle1(p1,p2);
    }

    public void Battle1_2(int x , RPGcharacter p1 , RPGcharacter p2){
        if (x < 1 || x > 3) {
            System.out.println("Error!!! " + "[ " + p1.name + " ]" + " you enter wrong choice");
            SelectBattle1(p1,p2);
        }
        else if( x == 1){
            System.out.println("[ " + p1.name + " ] -->" +" attacks at " + "--> [ " +p2.name + " ]");
            Attack(p1,p2);
            if(p2.CurrentHp <= 0){
                System.out.println("+------------------------------------+");
                System.out.println( "[ " + p1.name + " ]" + "is the winner!!");
                System.out.println("+------------------------------------+");
            }else{
                SelectBattle2(p1, p2);
            }
        }
        else if( x == 2){
            System.out.println("[ " +p1.name + " ] -->" +" heal ++ ");
            p1.Heal();
            SelectBattle2(p1,p2);
        }
        else {
            System.out.println("[ " +p1.name + " ] don't do anything this turn" +"\n");
            SelectBattle2(p1,p2);
        }
    }
    public void Battle2_1(int x , RPGcharacter p1 , RPGcharacter p2){
        if (x < 1 || x > 3) {
            System.out.println("Error!!! " + "[ " + p2.name + " ]" + " you enter wrong choice");
            SelectBattle2(p1,p2);
        }
        else if( x == 1){
            System.out.println("[ " + p2.name + " ] -->" +" attacks at " + "--> [ " +p1.name + " ]");
            Attack(p2,p1);
            if(p1.CurrentHp <= 0){
                System.out.println("+------------------------------------+");
                System.out.println( "[ " + p2.name + " ]" + "is the winner!!");
                System.out.println("+------------------------------------+");
            }else {
                SelectBattle1(p1, p2);
            }
        }
        else if( x == 2){
            System.out.println("[ " +p2.name + " ] -->" +" Heal ++ ");
            p2.Heal();
            SelectBattle1(p1,p2);
        }
        else {
            System.out.println("[ " +p2.name + " ] don't do anything this turn"  +"\n");
            SelectBattle1(p1,p2);
        }
    }

    public void SelectBattle1(RPGcharacter p1 , RPGcharacter p2){
        System.out.println("[ " + p1.name + " ]" + " Choose your options ");
        System.out.println("[1] Attack [2] Heal [3] Don't do anything this turn ");
        Scanner bt = new Scanner(System.in);
        System.out.print("Select your options :");
        int scBattle = bt.nextInt();
        Battle1_2(scBattle,p1,p2);
    }
    public void SelectBattle2(RPGcharacter p1 , RPGcharacter p2){
        System.out.println("[ " + p2.name + " ]" + " Choose your options ");
        System.out.println("[1] Attack [2] Heal [3] Don't do anything this turn ");
        Scanner bt = new Scanner(System.in);
        System.out.print("Select your options :");
        int scBattle = bt.nextInt();
        Battle2_1(scBattle,p1,p2);
    }

    @Override
    public void SelectSex(String gender) {
        switch (gender) {
            case "1" -> {
                this.sex = "Male";
                System.out.println("Your gender : " + sex);
            }
            case "2" -> {
                this.sex = "Female";
                System.out.println("Your gender : " + sex);
            }
            case "3" -> {
                this.sex = "Other gender";
                System.out.println("Your gender : " + sex);
            }
            default -> {
                System.out.println("You didn't select choose 1 , 2 or 3! -> Set gender : Unknown gender");
                this.sex = "Unknown gender";
            }
        }
    }

    @Override
    public void Attack(RPGcharacter playerAT , RPGcharacter playerDF) {
        if (wrist != null) {
            dmg =  playerAT.damage + wrist.AtkBonus() - playerDF.defense;
        } else {
            dmg = playerAT.damage - playerDF.defense;
        }
        if (dmg <= 0) {
            dmg = 0;
        }
        playerDF.CurrentHp = playerDF.CurrentHp - dmg;
        if(wrist ==null){
            System.out.println("ATK : " + String.format("%.1f", dmg) + " dmg");
            System.out.println("[ " + playerDF.name + " ]" + " HP : "+ playerDF.CurrentHp + " / " + playerDF.MaxHp +"\n");
        }
        if (wrist != null) {
            System.out.println("ATK + ATK bonus : +"+ String.format("%.1f", dmg) +" + "+ wrist.AtkBonus() + " dmg");
            System.out.println("[ " + playerDF.name + " ]" + " HP : "+playerDF.CurrentHp + " / " + playerDF.MaxHp +"\n");
        }
    }

    @Override
    public void Heal() {
        double heal;
        if (clothing != null) {
            heal = 50 * (1.5 + 1.8 * level) + clothing.gethealBonus();
        } else {
            heal = 50 * (1.5 + 1.8 * level);
        }
        CurrentHp += heal;
        if (CurrentHp >= MaxHp) {
            CurrentHp = MaxHp;
            System.out.println("[ " + name + " ]" +" Healing +" + heal + " hp"+ " [Max Hp]"+"\n");
        }
        else if(clothing == null){
            System.out.println("[ " + name + " ]" +" Healing : " + heal + " hp"+ " --> HP : "+CurrentHp+"\n");
        }
        else if(clothing != null){
            System.out.println("[ " + name + " ]" +" Healing + Heal bonus : " + heal + "+" + clothing.gethealBonus() + " hp"+ " --> HP : "+CurrentHp+"\n");
        }
    }

    //set default player stat
    public void PrintStatus() {
        System.out.println("+-------------------------------------+");
        System.out.println("[ Status : " + name + " ]");
        System.out.println("+-------------------------------------+");
        System.out.println("Gender : " + sex);
        System.out.println("Career : " + job);
        System.out.println("Level : " + level);
        System.out.println("Max HP : " + MaxHp);
        System.out.println("Max Mana : " + MaxMana);
        System.out.println("Damage : " + (Math.floor(damage * 100) / 100));
        System.out.println("Defense : " + (Math.floor(defense * 100) / 100));
        System.out.println("CurrentSpeed" + " / " + "MaxSpeed : " + (Math.floor(baseSpeed * 100) / 100) + " / " + (Math.floor(MaxSpeed * 100) / 100));
        System.out.println("Exp / MaxEXP : " + CurrentExp + " / " + MaxExp);
        System.out.println("+-------------------------------------+");
        System.out.println("[ Current item ]");
        System.out.println("+-------------------------------------+");
        PrintCurrentItem();
        System.out.println("+-------------------------------------+");
        System.out.println();


    }

    public void SelectJob(String job) {
        switch (job) {
            case "1" -> {
                CurrentJob.UpdateStatus("Swordsman", this);
                System.out.println("Your career : Swordsman");
            }
            case "2" -> {
                CurrentJob.UpdateStatus("Archer", this);
                System.out.println("Your career : Archer");
            }
            case "3" -> {
                CurrentJob.UpdateStatus("Assassin", this);
                System.out.println("Your career : Assassin");
            }
            default -> {
                System.out.println("You didn't select choose a career! -> Set career : Villager");
                CurrentJob.UpdateStatus("Villager", this);
            }
        }
    }

    private void LevelUp() {
        CurrentLevel = level;
        level++;
        System.out.println(name + " Level Up!! " + "Level " + CurrentLevel + " --> " + "Level " + level);
        damage += 10 + (0.5 * level);
        defense += 5 + (0.2 * level);
        MaxHp += 100 + (10 * level);
        MaxMana += 50 + (2 * level);
        MaxSpeed += 1.5 * level;
        baseSpeed = MaxSpeed;
        CurrentJob.UpdateStatus(job, this);
    }

    public void getEXP(double exp) {
        CurrentExp = CurrentExp + exp;
        while (exp >= MaxExp) {
            if (CurrentExp >= MaxExp) {
                LevelUp();
                CurrentExp = CurrentExp - MaxExp;
                MaxExp = MaxExp + 500;
            } else {
                CurrentExp = CurrentExp + 0;
                return;
            }
        }
    }

    public int getLevel() {
        return level;
    }

    private void PrintCurrentItem() {
        if (currentShield != null && currentSword != null) {
            System.out.println("Sword: " + currentSword.getName() + " / " + "+" + String.format("%.1f", currentSword.getDamage()) + " Dmg" + " / " + "-" + String.format("%.1f", currentSword.DecreaseSped()) + " Sped");
            System.out.println("Shield: " + currentShield.getName() + " / " + "+" + String.format("%.1f", currentShield.getDefense()) + " Def" + " / " + "-" + String.format("%.1f", currentShield.DecreaseSped()) + " Sped");
        } else if (currentShield != null) {
            System.out.println("Shield: " + currentShield.getName() + " / " + "+" + String.format("%.1f", currentShield.getDefense()) + " Def" + " / " + "-" + String.format("%.1f", currentShield.DecreaseSped()) + " Sped");
        } else if (currentSword != null) {
            System.out.println("Sword: " + currentSword.getName() + " / " + "+" + String.format("%.1f", currentSword.getDamage()) + " Dmg" + " / " + "-" + String.format("%.1f", currentSword.DecreaseSped()) + " Sped");
        } else {
            System.out.println("No item using...");

        }
    }

    public static void PrintSword() {
        System.out.println("                      Sword");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", " Order", " Name", " Level", " Damage", " Speed");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < sword.length; i++) {
            if (sword[i] == null) {
                System.out.printf(" %-5d %-20s %-10s %-10s %-10s \n", i + 1, "-", "-", "-", "-");
            } else {
                System.out.printf(" %-5d %-20s %-10d %-10s %-10s \n", i + 1, sword[i].getName(), sword[i].getLevel(), "+" + (int) sword[i].getDamage() + " dmg", "-" + (int) sword[i].DecreaseSped() + " sped");
            }
        }
    }

    private void PrintShield() {
        System.out.println("                      Shield");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", " Order", " Name", " Level", " Defense", " Speed");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < shield.length; i++) {
            if (shield[i] == null) {
                System.out.printf(" %-5d %-20s %-10s %-10s %-10s \n", i + 1, "-", "-", "-", "-");
            } else {
                System.out.printf(" %-5d %-20s %-10d %-10s %-10s \n", i + 1, shield[i].getName(), shield[i].getLevel(), "+" + (int) shield[i].getDefense() + " def", "-" + (int) shield[i].DecreaseSped() + " sped");
            }
        }
    }

    private void PrintRing() {
        System.out.println("                      Ring");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", " Order", " Name", " Level", " Mana", " Speed");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < AllRing.length; i++) {
            if (AllRing[i] == null) {
                System.out.printf(" %-5d %-20s %-10s %-10s %-10s \n", i + 1, "-", "-", "-", "-");
            } else {
                System.out.printf(" %-5d %-20s %-10d %-10s %-10s \n", i + 1, AllRing[i].getName(), AllRing[i].getLevel(), "+" + AllRing[i].getManabonus()+ " mana", "+" +  AllRing[i].getSpeedbonus() + " sped");
            }
        }
    }

    private void PrintClothing() {
        System.out.println("                      Clothing");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", " Order", " Name", " Level", " Defense", " Heal bonus");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < AllClothing.length; i++) {
            if (AllClothing[i] == null) {
                System.out.printf(" %-5d %-20s %-10s %-10s %-10s \n", i + 1, "-", "-", "-", "-");
            } else {
                System.out.printf(" %-5d %-20s %-10d %-10s %-10s \n", i + 1, AllClothing[i].getName(), AllClothing[i].getLevel(), "+" + AllClothing[i].getDefBonus() + " def", "+" + AllClothing[i].gethealBonus() + " Hp");
            }
        }
    }

    private void PrintWrist() {
        System.out.println("                      Wrist");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", " Order", " Name", " Level", " Damage", " Attack bonus");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < AllWrist.length; i++) {
            if (AllWrist[i] == null) {
                System.out.printf(" %-5d %-20s %-10s %-10s %-10s \n", i + 1, "-", "-", "-", "-");
            } else {
                System.out.printf(" %-5d %-20s %-10d %-10s %-10s \n", i + 1, AllWrist[i].getName(), AllWrist[i].getLevel(), "+" + AllWrist[i].getDamageBonus() + " dmg", "+" + AllWrist[i].AtkBonus() + " dmg");
            }
        }
    }
    private void CurrentSword(int i) {
        if (i < 1 || i > 6) {
            System.out.println("Error!!! " +"[ " + name + " ]" +" you enter wrong choice");
            SelectSword();
        } else if (i == 6) {
            System.out.println("[ " + name + " ]" +" Not using sword now"+"\n");
            return;
        }
        if (sword[i - 1] == null) {
            System.out.println("[ " + name + " ]" + " You can't select empty slot...");
            SelectSword();
        } else if (level < sword[i - 1].getLevel()) {
            System.out.println("[ " + name + " ]" +" Your level not enough to use this sword");
            SelectSword();
        } else {
            currentSword = sword[i - 1];
            sword[i - 1] = null;
            damage += currentSword.getDamage();
            baseSpeed -= currentSword.DecreaseSped();
            System.out.println("[ " + name + " ]" +" Using " + currentSword.name + " now"+"\n");
        }

    }


    private void CurrentShield(int i) {
        if (i < 1 || i > 6) {
            System.out.println("[ " + name + " ]" + " Error!!! you enter wrong choice");
            SelectShield();
        } else if (i == 6) {
            System.out.println("[ " + name + " ]" +" Not using shield now"+"\n");
            return;
        }
        if (shield[i - 1] == null) {
            System.out.println("[ " + name + " ]" +" You can't select empty slot...");
            SelectShield();
        } else if (level < shield[i - 1].getLevel()) {
            System.out.println("[ " + name + " ]" +" Your level not enough to use this shield");
            SelectShield();
        } else {
            currentShield = shield[i - 1];
            shield[i - 1] = null;
            defense += currentShield.getDefense();
            baseSpeed -= currentShield.DecreaseSped();
            System.out.println("[ " + name + " ]" +" Using " + currentShield.getName() + " now"+"\n");
        }

    }
    private void CurrentRing(int i) {
        if (i < 1 || i > 6) {
            System.out.println("[ " + name + " ]" +" Error!!! you enter wrong choice");
            SelectRing();
        } else if (i == 6) {
            System.out.println("[ " + name + " ]" +" Not using ring now"+"\n");
            return;
        }
        if (AllRing[i - 1] == null) {
            System.out.println("[ " + name + " ]" +" You can't select empty slot...");
            SelectRing();
        } else if (level < AllRing[i - 1].getLevel()) {
            System.out.println("[ " + name + " ]" +" Your level not enough to use this ring");
            SelectRing();
        } else {
            ring = AllRing[i - 1];
            AllRing[i - 1] = null;
            ring.AccUpdateStatus(this);
            System.out.println(ring.getBonus());
        }
    }
    private void CurrentClothing(int i) {
        if (i < 1 || i > 6) {
            System.out.println("[ " + name + " ]" +" Error!!! you enter wrong choice");
            SelectClothing();
        } else if (i == 6) {
            System.out.println("[ " + name + " ]"+" Not using clothing now"+"\n");
            return;
        }
        if (AllClothing[i - 1] == null) {
            System.out.println("[ " + name + " ]"+" You can't select empty slot...");
            SelectClothing();
        } else if (level < AllClothing[i - 1].getLevel()) {
            System.out.println("[ " + name + " ]" +" Your level not enough to use this clothing");
            SelectClothing();
        } else {
            clothing = AllClothing[i - 1];
            AllClothing[i - 1] = null;
            clothing.AccUpdateStatus(this);
            System.out.println(clothing.getBonus());
        }
    }
    private void CurrentWrist(int i) {
        if (i < 1 || i > 6) {
            System.out.println("[ " + name + " ]" +" Error!!! "+"you enter wrong choice");
            SelectWrist();
        } else if (i == 6) {
            System.out.println("[ " + name + " ]"+" Not using wrist now"+"\n");
            return;
        }
        if (AllWrist[i - 1] == null) {
            System.out.println("[ " + name + " ]" + " You can't select empty slot...");
            SelectWrist();
        } else if (level < AllWrist[i - 1].getLevel()) {
            System.out.println("[ " + name + " ]" + " Your level not enough to use this wrist");
            SelectWrist();
        } else {
            wrist = AllWrist[i - 1];
            AllWrist[i - 1] = null;
            wrist.AccUpdateStatus(this);
            System.out.println(wrist.getBonus());
        }
    }


    private void SelectSword() {
        Scanner sl = new Scanner(System.in);
        System.out.println("Select your sword");
        PrintSword();
        System.out.print("[ " + name + " ]" +" Choose sword 1-5 or 6 to not using sword : ");
        int as = sl.nextInt();
        CurrentSword(as);
    }

    private void SelectShield() {
        Scanner sl = new Scanner(System.in);
        System.out.println("Select your shield");
        PrintShield();
        System.out.print("[ " + name + " ]" +" Choose shield 1-5 or 6 to not using shield : ");
        int as2 = sl.nextInt();
        CurrentShield(as2);
    }

    private void SelectRing() {
        Scanner sl = new Scanner(System.in);
        System.out.println("[ " + name + " ]" +" Select your ring");
        PrintRing();
        System.out.print("[ " + name + " ]" +" Choose ring 1-5 or 6 to not using ring : ");
        int as2 = sl.nextInt();
        CurrentRing(as2);
    }
    private void SelectClothing(){
        Scanner sl = new Scanner(System.in);
        System.out.println("[ " + name + " ]"+" Select your clothing");
        PrintClothing();
        System.out.print("[ " + name + " ]" +" Choose ring 1-5 or 6 to not using clothing : ");
        int as2 = sl.nextInt();
        CurrentClothing(as2);
    }

    private void SelectWrist(){
        Scanner sl = new Scanner(System.in);
        System.out.println("[ " + name + " ]"+" Select your wrist");
        PrintWrist();
        System.out.print("[ " + name + " ]"+" Choose ring 1-5 or 6 to not using wrist : ");
        int as2 = sl.nextInt();
        CurrentWrist(as2);
    }
    private void AccessoriesChoice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("+----- Choose character's accessory ----+");
        System.out.println(" [1] Ring     [2] Clothing    [3] Wrist");
        System.out.println(" :+MaxMana    :+defense       :+damage ");
        System.out.println(" :+speed      :+bonus heal    :+bonus attack+");
        System.out.print("[ " + name + " ]" + " choose your accessory : ");
        int answer = sc.nextInt();
        if(answer == 1){
            SelectRing();
        }else if(answer == 2){
            SelectClothing();
        }else if(answer == 3){
            SelectWrist();
        }else{
            System.out.println("[ " + name + " ]"+" Error!!! you enter wrong choice");
            AccessoriesChoice();
        }
    }
}