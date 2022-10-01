package command;

import java.util.List;

public class PWD extends Command {
    public PWD(Context context) {
        super(context);
    }

    /**
     * this method shows the current directory
     *
     * @param args ignore
     * @return current directory name
     */
    @Override
    public String execute(List<String> args) {
        return context.getCurrentDirectory().getAbsolutePath();
    }
}
