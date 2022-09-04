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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify the path,  where you want to create a new directory.");

        String path = scanner.nextLine();

        System.out.println("Enter directory name");

        String name = scanner.nextLine();

        File folder = new File(path + File.separator + name);
        if (!folder.exists()) {
            folder.mkdir();
        }
        return "Directory created";
    }
}
