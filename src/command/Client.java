import commands.AbstractCommand;
import commands.Command;

import java.util.Arrays;
import java.util.List;

public class Client {
    private List<AbstractCommand> commands;

    public Client(List<AbstractCommand> commands) {
        this.commands = commands;
    }

    void doCommand(String[] types) {
        commands.stream()
                .filter(command ->
                        Arrays.stream(types).anyMatch(type -> command.getType().equals(type)))
                .forEach(Command::execute);
    }
}
