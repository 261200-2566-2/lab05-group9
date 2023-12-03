public class Wrist implements Accessories{
    private String name,type;
    private int level;
    private double bonus;

    Wrist(String name,int level){
        this.name = name;
        this.level = level;
        type = "Wrist";
    }
    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void AccUpdateStatus(RPGcharacter player) {
        bonus = 10 * (1+0.7*level);
        player.damage += bonus;
    }

    @Override
    public String getBonus() {
        return "Bonus from " + name + " [ " + type + " ] "+" : +"  + String.format("%.1f",bonus) + " dmg";
    }

    public double AtkBonus(){
        return 6 * (1+0.7*level);
    }
}
