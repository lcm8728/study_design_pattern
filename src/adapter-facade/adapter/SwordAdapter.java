package adapter;

class SwordAdapter implements Gun {
    private Sword sword;

    SwordAdapter(Sword sword) {
        this.sword = sword;
    }

    @Override
    public void shoot() {
        sword.cut();
    }
}
