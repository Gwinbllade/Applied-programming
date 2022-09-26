package droids;
public abstract class BaseDroid {
    private String name;
    private float health;
    private float precision;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public float getPrecision() {
        return precision;
    }


    public void setPrecision(float precision) {
        this.precision = precision;
    }


    public float getHealth() {
        return health;
    }


    public void setHealth(float health) {
        this.health = health;
    }


    public void attack(){

    }

}
