package commands;

import commands.AbstractCommand;

public class ToSms extends AbstractCommand {

    public ToSms() {
        super("sms");
    }

    public void process() {
        System.out.println("Sent to sms");
    }
}
