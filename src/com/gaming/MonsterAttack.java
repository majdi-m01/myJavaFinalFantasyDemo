package com.gaming;

public class MonsterAttack implements Attack {

    private int MinDamage;
    private int MaxDamage;
    private String WeaponName;

    MonsterAttack(String Name, int Min, int Max) {
        WeaponName = Name;
        MinDamage = Min;
        MaxDamage = Max;
    }

    @Override
    public String getWeaponName(){
        return WeaponName;
    }

    @Override
    public int getMinDamage() {
        return MinDamage;
    }

    @Override
    public int getMaxDamage() {
        return MaxDamage;
    }

    @Override
    public int getDamage() {
        return (int) (Math.random() * (getMaxDamage() - getMinDamage())) + getMinDamage();
    }

    @Override
    public int getDescription(int d) {
        d = getDamage();
        System.out.println("Monster attacks!\n" + "You got " + d + " Damage.");
        return d;
    }

    @Override
    public void setMinDamage(int min) {
        MinDamage = min;
    }

    @Override
    public void setMaxDamage(int max) {
        MaxDamage = max;
    }
}
