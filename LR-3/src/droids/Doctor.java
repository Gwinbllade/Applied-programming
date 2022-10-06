package droids;

public class Doctor extends BaseDroid {
    public Doctor(String name){
        this.name = name;
        this.type = "D";
        this.health = 100;
        this.damage = 4;
        this.precision = 5;
        this.specialAbilityChance = 2;
    }

    @Override
    public boolean attack(BaseDroid enemy){
        boolean attackSuccess = false;

        int pAttack = (int) ( Math.random() * 11 );
        int SAC = (int) ( Math.random() * 11 );// special ability chance
        if(pAttack <= this.precision) {
            System.out.println("");
            enemy.health -= this.damage;
            attackSuccess = true;
        }

        if(SAC <= this.specialAbilityChance) {
            this.health += 5;
            System.out.printf("The %s (%s) was afraid (+5 health)\n", this.name,this.type );
        }
        return attackSuccess;

    }
}
