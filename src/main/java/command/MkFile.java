package command;

import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

public class MkFile extends Command{
    public MkFile(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        File file = new File(context.getCurrentDirectory() , args.get(0));
        if (!file.exists()) {
            file.createNewFile();
        }
        return "File created";
    }
}
