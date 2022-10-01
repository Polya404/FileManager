package command;

import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

public class Mkdir extends Command {
    public Mkdir(Context context) {
        super(context);
    }

    /**
     * this method creates directories
     *
     * @param args directory's name
     * @return directory creation message
     */
    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        if (context.getCurrentDirectory().isFile()) {
            return "Please back to directory";
        }
        if (args.size() == 0) {
            return "Enter directory's name";
        }
        File folder = new File(context.getCurrentDirectory(), args.get(0));
        if (!folder.exists()) {
            folder.mkdir();
        }
        return "Directory created";
    }
}
