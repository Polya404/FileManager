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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify the path,  where you want to create a new file.");

        String path = scanner.nextLine();

        System.out.println("Enter file name");

        String name = scanner.nextLine();

        File file = new File(path + File.separator + name);
        if (!file.exists()) {
            file.createNewFile();
        }
        return "File created";
    }
}
