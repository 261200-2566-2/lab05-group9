public class Sword {
    protected String name;
    private int SWlevel;
    private double damage;
    private double SItemSpeed;

    Sword(String name,int baseDmg,int level){
        this.name = name;
        SWlevel = level;
        damage = baseDmg*(1+0.1*SWlevel);
        SItemSpeed = 10*(1+0.5*SWlevel);
    }

    Sword(String name,int baseDmg){
        this(name,baseDmg,1);
        //set Default level to 1
    }
    public double DecreaseSped(){
        return SItemSpeed;
    }
    public String getName(){
        return name;
    }
    public double getDamage() {return  damage; }
    public int getLevel() {return SWlevel;}


}
