package command;

import lombok.SneakyThrows;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class MkFile extends Command{
    public MkFile(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        File file = new File(args.get(0) + File.separator + args.get(1));
        if (!file.exists()) {
            file.createNewFile();
        }
        return "File created";
    }
}
