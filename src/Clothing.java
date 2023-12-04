public class Clothing implements Accessories{
    private String name,type;
    private int level;
    private double bonus;
    private double healBonus;

    Clothing(String name,int level){
        this.name = name;
        this.level = level;
        type = "Clothing";
        bonus = 15 * (1+0.8*level);
        healBonus =(8*(1+0.02*level));
    }
    Clothing(String name){
        this(name,1);
        //set level 1
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
        player.defense += bonus;
    }

    @Override
    public String getBonus() {
        return "Bonus from " + name + " [ " + type + " ] "+" : +"  + String.format("%.1f",bonus) + " def";
    }

    public int gethealBonus(){
        return (int)healBonus;
    }
    public int getDefBonus(){
        return (int)bonus;
    }
}
