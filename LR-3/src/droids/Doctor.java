package droids;

import java.io.PrintWriter;

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
    public boolean attack(BaseDroid enemy, PrintWriter fw){
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
            System.out.printf("\u001B[33m"+"The %s (%s) was afraid (+5 health)\n"+"\033[0m", this.name,this.type );
            fw.printf("\u001B[33m"+"The %s (%s) was afraid (+5 health)\n"+"\033[0m", this.name,this.type );
        }
        return attackSuccess;

    }
}
