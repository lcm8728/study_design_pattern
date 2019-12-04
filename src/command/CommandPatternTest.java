import commands.AbstractCommand;
import commands.ToKakaoTalk;
import commands.ToLine;
import commands.ToSms;

import java.util.ArrayList;
import java.util.List;

public class CommandPatternTest {
    public static void main(String[] args) {
        List<AbstractCommand> commands = new ArrayList<>();
        commands.add(new ToKakaoTalk());
        commands.add(new ToLine());
        commands.add(new ToSms());


        Client client = new Client(commands);

        System.out.println("Share Content A to Katalk And SMS");
        String[] types = {"kakaotalk", "sms"};
        client.doCommand(types);
        System.out.println();

        System.out.println("Share Content B to Line");
        String[] types2 = {"line"};
        client.doCommand(types2);
    }
}
