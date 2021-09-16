package com.gaming;

class Monster {
    private int Life;

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
}
