public class Wrist implements Accessories{
    private String name,type;
    private int level;
    private double bonus,AtkBonus;

    Wrist(String name,int level){
        this.name = name;
        this.level = level;
        type = "Wrist";
        bonus = 10 * (1+0.7*level);
        AtkBonus = (6 * (1+0.7*level));
    }
    Wrist(String name){
        this(name,1);
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
        player.damage += bonus;
    }

    @Override
    public String getBonus() {
        return "Bonus from " + name + " [ " + type + " ] "+" : +"  + String.format("%.1f",bonus) + " dmg";
    }

    public int AtkBonus(){
        return (int)AtkBonus;
    }
    public int getDamageBonus(){
        return (int)bonus;
    }
}
