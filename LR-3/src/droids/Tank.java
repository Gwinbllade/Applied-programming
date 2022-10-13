package droids;

import java.io.PrintWriter;

public class Tank extends BaseDroid{
    public Tank(String name){
        this.name = name;
        this.type = "T";
        this.health = 200;
        this.damage = 4;
        this.precision = 5;
        this.specialAbilityChance = 0;
    }

    @Override
    public boolean attack(BaseDroid enemy, PrintWriter fw){
        boolean attackSuccess = false;
        int pAttack = (int) ( Math.random() * 11 );

        if(pAttack <= this.precision) {
            enemy.health -= this.damage;
            attackSuccess = true;
        }

        return attackSuccess;
    }
}
