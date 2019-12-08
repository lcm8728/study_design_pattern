package commands;

public abstract class AbstractCommand implements Command {
    private String type;

    AbstractCommand(String type) {
        this.type = type;
    }

    abstract void process();

    public String getType() {
        return type;
    }

    public void execute() {
        before();
        process();
        after();
    }

    private void before() {
        System.out.println("Preparing to share to " + type);
    }

    private void after() {
        System.out.println("Done with " + type);
    }
}
