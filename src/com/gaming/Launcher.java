package com.gaming;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("Welcome to the Turn-Based-Battle-System App");
        Scanner input = new Scanner(System.in);

        //Player Input
        Player player = new Player();
        player.setLife(100);
        player.setMana(35);

        //Monster Input
        Monster monster = new Monster();
        monster.setLife(100);

        //Creating Spell
        SpellAttack spell = new SpellAttack();
        spell.setSpellName("Fire Ball");
        spell.setMinDamage(8);
        spell.setMaxDamage(18);
        spell.setManaCost(7);

        //Creating sword
        WeaponAttack sword = new WeaponAttack("Sword", 7, 11);

        //Creating melee
        MonsterAttack melee = new MonsterAttack("Melee", 7, 17);


        String ans;
        do {
            System.out.println("Do you wanna fight?) (y/n)");
            ans = input.nextLine();
            if ( ans.equals("n") || ans.equals("no") || ans.equals("No") || ans.equals("NO") ) {
                return;
            }
        } while ( !( ans.equals("y") || ans.equals("yes") || ans.equals("Y") || ans.equals("YES") || ans.equals("YE") || ans.equals("ye") ) );

        int round = -2;
        while (true) {
            if(round%3 == 0){
                player.setMana(player.getMana() + 5);
            }
            round++;
            System.out.println("######### New Round #########");
            System.out.println("Your Life: " + player.getLife());
            System.out.println("Your Mana: " + player.getMana());
            System.out.println("Monster Life: " + monster.getLife());
            System.out.println("-----------------------------");

            int a;
                do {
                    System.out.println("It is your turn. Which attack do you want to perform?\n" +
                            "Melee Attack with Sword. Deals " + sword.getMinDamage() + " to " + sword.getMaxDamage() + " ( 1 )\n" +
                            "Magic Spell called Fire Ball. Costs " + spell.getManaCost() + " Mana and deals " + spell.getMinDamage() + " to " + spell.getMaxDamage() + " ( 2 )");
                    a = input.nextInt();
                        if (a == 1) {
                            int SwordDamage = player.addAttack(sword);
                            monster.addDamage(SwordDamage);
                            int MeleeDamage = monster.addAttack(melee);
                            player.addDamage(MeleeDamage);
                        } else if( (a==2) && !(player.getMana()-spell.getManaCost() < 0) ) {
                            player.setMana(player.getMana() - spell.getManaCost());
                            int SpellDamage = player.addAttack(spell);
                            monster.addDamage(SpellDamage);
                            int MeleeDamage = monster.addAttack(melee);
                            player.addDamage(MeleeDamage);
                        } else if (a==2) System.out.println("Not Enough Mana!");
                } while ( !( (a == 1) || (a == 2) ) );

            if ( (player.getLife() <= 0) && (monster.getLife() <= 0) ) {
                monster.setLife(0);
                player.setLife(0);
                System.out.println("######### Game Ended #########");
                System.out.println("Your Life: " + player.getLife());
                System.out.println("Your Mana: " + player.getMana());
                System.out.println("Monster Life: " + monster.getLife());
                System.out.println("-----------------------------");
                System.out.println("You tie!");
                return;
            }
            else if (player.getLife() <= 0) {
                player.setLife(0);
                System.out.println("######### Game Ended #########");
                System.out.println("Your Life: " + player.getLife());
                System.out.println("Your Mana: " + player.getMana());
                System.out.println("Monster Life: " + monster.getLife());
                System.out.println("-----------------------------");
                System.out.println("You lost!");
                return;
            }
            else if (monster.getLife() <= 0) {
                monster.setLife(0);
                System.out.println("######### Game Ended #########");
                System.out.println("Your Life: " + player.getLife());
                System.out.println("Your Mana: " + player.getMana());
                System.out.println("Monster Life: " + monster.getLife());
                System.out.println("-----------------------------");
                System.out.println("You won!");
                return;
            }
        }
    }
}
