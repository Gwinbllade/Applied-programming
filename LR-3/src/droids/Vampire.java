package droids;

public class Vampire extends BaseDroid{
    public Vampire(String name){
        this.name = name;
        this.type = "Vampire";
        this.health = 80;
        this.damage = 4;
        this.precision = 5;
        this.specialAbilityChance = 10;
    }

    @Override
    public boolean attack(BaseDroid enemy){
        boolean attackSuccess = false;

        int pAttack = (int) ( Math.random() * 11 );

        if(pAttack <= this.precision) {
            System.out.printf("%s(%s) Being treated(+2) %n", this.name, this.type );
            enemy.health -= this.damage;
            this.health += 2;
            attackSuccess = true;
        }

        return attackSuccess;

    }
}
