package droids;
public abstract class  BaseDroid {
    protected String type;
    protected String name;
    protected double health;//Здоров'я
    protected int precision ;//Точність(від неї залежить чи зможе дроїд атауквати за свій хід)
    protected double damage;// Шкода, яку дроїд може завдати при атаці
    protected int specialAbilityChance;// Шанс спеціальної здібності


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getDamage() {
        return damage;
    }


    public double getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }
    public boolean attack(BaseDroid enemy) {
        return false;
    }

}
