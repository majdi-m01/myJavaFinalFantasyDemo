package com.gaming;

class Player {
    private int Life;
    private int Mana;

    int addAttack(Attack a){
        int d = 0;
        return a.getDescription(d);
    }

    void addDamage(int damaged){
        setLife(getLife()-damaged);
    }

    int getLife() {
        return Life;
    }

    void setLife(int life) {
        Life = life;
    }

    int getMana() {
        return Mana;
    }

    void setMana(int mana) {
        Mana = mana;
    }
}
