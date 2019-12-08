package adapter;

public class Gunner {
    private Gun gun;

    Gunner(Gun gun) {
        this.gun = gun;
    }

    void shoot() {
        gun.shoot();
    }
}
