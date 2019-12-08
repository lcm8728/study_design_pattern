package commands;

import commands.AbstractCommand;

public class ToLine extends AbstractCommand {

    public ToLine() {
        super("line");
    }

    public void process() {
        System.out.println("Sent to Line");
    }
}
