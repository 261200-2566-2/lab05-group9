public class Clothing implements Accessories{
    private String name,type;
    private int level;
    private double bonus;
    private double healBonus;

    Clothing(String name,int level){
        this.name = name;
        this.level = level;
        type = "Clothing";
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
        bonus = 15 * (1+0.8*level);
        player.defense += bonus;
    }

    @Override
    public String getBonus() {
        return "Bonus from " + name + " [ " + type + " ] "+" : +"  + String.format("%.1f",bonus) + " def";
    }

    public double healBonus(){
        return 8*(1+0.02*level);
    }
}
