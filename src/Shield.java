public class Shield {
    private String name;
    private int SHlevel;
    private double defense;
    private double SHItemSpeed;


    Shield(String name,int baseDef,int level){
        this.name = name;
        SHlevel = level;
        defense = baseDef*(1+0.05*SHlevel);
        SHItemSpeed = 10*(1+0.7*SHlevel);
    }


    Shield(String name,int baseDef){
        this(name,baseDef,1);
        //set Default level to 1
    }

    public double DecreaseSped(){
        return SHItemSpeed;
    }
    public String getName(){
        return name;
    }
    public double getDefense() {return defense; }
    public int getLevel() {return SHlevel;}
}
