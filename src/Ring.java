public class Ring implements Accessories{
    private String name,type;
    private int level;
    private double bonusMana;
    private double bonusSpeed;

    Ring(String name,int level){
        this.name = name;
        this.level = level;
        type = "Ring";
        bonusMana = 13 * (1+0.7*level);
        bonusSpeed = 0.7 * level;
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
        player.MaxMana += (int) bonusMana;
        player.MaxSpeed += (int) bonusSpeed;
        player.baseSpeed = player.MaxSpeed;
    }

    @Override
    public String getBonus() {
        return "Bonus from " + name + " [ " + type + " ] "+" : +"  + String.format("%.1f",bonusMana) + " MaxMana";
    }
    public int getSpeedbonus(){
        return (int)bonusSpeed;
    }

    public int getManabonus(){
        return  (int)bonusMana;
    }
}
