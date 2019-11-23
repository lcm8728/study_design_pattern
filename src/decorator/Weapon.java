package decorator;

interface Weapon {

    int damage();
}

class Sword implements Weapon {

    @Override
    public int damage() {
        return 10;
    }
}

class Axe implements Weapon {

    @Override
    public int damage() {
        return 15;
    }
}

abstract class Enchantment implements Weapon{}
class FireEnchant extends Enchantment {

    private Weapon weapon;

    public FireEnchant(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int damage() {
        return weapon.damage() + 5;
    }
}

class IceEnchant extends Enchantment {

    private Weapon weapon;

    public IceEnchant(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int damage() {
        return weapon.damage() + 3;
    }
}