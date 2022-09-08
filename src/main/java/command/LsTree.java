package command;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class LsTree extends Command {
    private static final String FILE = "[F] : ";
    private static final String DIR = "[D] : ";
    private static final String PREF = "--";

    public LsTree(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {
        File file = context.getCurrentDirectory();
        File[] files = Objects.requireNonNull(file.listFiles());
        for (int i = 0; i < (args.size() == 0 ? Objects.requireNonNull(file.listFiles()).length :Integer.parseInt(args.get(0))); i ++){
            getFileStructure(files[i], "");
        }
        return "";
    }

    private void getFileStructure(File file, String prefix) {
        if (file.isFile()) {
            System.out.println(prefix + FILE.concat(file.getName()));
        } else {
            System.out.println(prefix + DIR.concat(file.getName()));
            for (File f : Objects.requireNonNull(file.listFiles())){
                getFileStructure(f, prefix + PREF);
            }
        }
    }
}
