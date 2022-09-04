package command;

import lombok.SneakyThrows;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Mkdir extends Command {
    public Mkdir(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        File folder = new File(args.get(0) + File.separator + args.get(1));
        if (!folder.exists()) {
            folder.mkdir();
        }
        return "Directory created";
    }
}
