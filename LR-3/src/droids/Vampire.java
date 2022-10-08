package droids;

import java.io.PrintWriter;

public class Vampire extends BaseDroid{
    public Vampire(String name){
        this.name = name;
        this.type = "V";
        this.health = 80;
        this.damage = 4;
        this.precision = 5;
        this.specialAbilityChance = 10;
    }

    @Override
    public boolean attack(BaseDroid enemy, PrintWriter fw){
        boolean attackSuccess = false;

        int pAttack = (int) ( Math.random() * 11 );

        if(pAttack <= this.precision) {
            System.out.printf("\u001B[33m"+"%s(%s) Being treated(+2) %n"+"\u001B[33m", this.name, this.type );
            fw.printf("\u001B[33m"+"%s(%s) Being treated(+2) %n"+"\u001B[33m", this.name, this.type );
            enemy.health -= this.damage;
            this.health += 2;
            attackSuccess = true;
        }

        return attackSuccess;

    }
}
