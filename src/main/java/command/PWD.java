package command;

import java.util.List;

public class PWD extends Command {
    public PWD(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {
        return context.getCurrentDirectory().getAbsolutePath();
    }
}
