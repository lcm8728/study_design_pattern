package commands;

import commands.AbstractCommand;

public class ToKakaoTalk extends AbstractCommand {

    public ToKakaoTalk() {
        super("kakaotalk");
    }

    public void process() {
        System.out.println("Sent to KakaoTalk");
    }
}
