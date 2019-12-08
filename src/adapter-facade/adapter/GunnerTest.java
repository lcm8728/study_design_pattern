package adapter;

public class GunnerTest {
    public static void main(String[] args) {
        Sword sword = new LongSword();
        Gunner gunner = new Gunner(new SwordAdapter(sword));

        gunner.shoot();
    }
}
