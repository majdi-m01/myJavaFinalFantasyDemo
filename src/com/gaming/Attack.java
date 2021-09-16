package com.gaming;

public interface Attack {
    int getDescription(int d);
    int getDamage();
    int getMinDamage();
    int getMaxDamage();
    String getWeaponName();
    void setMinDamage(int min);
    void setMaxDamage(int max);

}
