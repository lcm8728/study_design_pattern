package decorator;

public class MainClass {
    public static void main(String[] args) {
        Weapon myAxe = new Axe();
        myAxe = new FireEnchant(myAxe);
        myAxe = new IceEnchant(myAxe);

        Weapon mySword = new Sword();
        mySword = new FireEnchant(mySword);
        mySword = new FireEnchant(mySword);
        mySword = new FireEnchant(mySword);
        mySword = new FireEnchant(mySword);
        mySword = new FireEnchant(mySword);
        mySword = new FireEnchant(mySword);



        // 도끼 + 불 강화 + 얼음 강화
        System.out.println(myAxe.damage());
        // 검 + 불 강화 * 6
        System.out.println(mySword.damage());
    }
}
