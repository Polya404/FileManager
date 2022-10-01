package command;

import java.util.List;
import java.util.Map;

public class Help extends Command {
    public Help(Context context) {
        super(context);
    }

    /**
     * this method shows all available commands
     *
     * @param args ignore
     * @return available commands
     */
    @Override
    public String execute(List<String> args) {
        Map<String, Command> commands = context.getCommandMap();

        StringBuilder result = new StringBuilder("Available commands:\n");
        if (commands != null) {
            for (String each : commands.keySet()) {
                result.append(each).append("\n");
            }
        }
        return result.toString();
    }
}
