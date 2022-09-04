package command;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Rmr extends Command{
    public Rmr(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify the path,  where you want to delete file.");
        File file = new File(scanner.nextLine());
        deleteDirectory(file);
        return "Removed";
    }

    boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
