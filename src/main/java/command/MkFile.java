package command;

import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

public class MkFile extends Command {
    public MkFile(Context context) {
        super(context);
    }

    /**
     * this method creates file
     *
     * @param args file's name
     * @return file creation message
     */
    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        if (context.getCurrentDirectory().isFile()) {
            return "Please back to directory";
        }
        if (args.size() == 0) {
            return "Enter file's name";
        }
        File file = new File(context.getCurrentDirectory(), args.get(0));
        if (!file.exists()) {
            file.createNewFile();
        }
        return "File created";
    }
}
