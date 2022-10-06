package droids;

public class Assassin extends BaseDroid{
    public Assassin(String name){
        this.name = name;
        this.type = "A";
        this.health = 50;
        this.damage = 10;
        this.precision = 9;
        this.specialAbilityChance = 2;
    }

    @Override
    public boolean attack(BaseDroid enemy){
        boolean attackSuccess = false;

        int pAttack = (int) ( Math.random() * 11 );
        int SAC = (int) ( Math.random() * 11 );// special ability chance

        if(pAttack <= this.precision) {
            if (SAC <= specialAbilityChance) {
                System.out.printf("%s(%s) Activates a special ability and becomes stronger\n", this.name, this.type);
                enemy.health -= this.damage*2;
            }

            else{
                enemy.health -= this.damage;
            }
            attackSuccess = true;
        }

        return attackSuccess;

    }
}
