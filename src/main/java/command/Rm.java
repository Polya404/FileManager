package command;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Rm extends Command {
    public Rm(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        File file = new File(args.get(0));
        if (args.size() == 2) {
            deleteDirectoryWithRecursion(file);
        } else {
            deleteDirectory(file);
        }
        return "File was delete";
    }

    @SneakyThrows
    private void deleteDirectory(File file) {
        String path = file.getPath();
        if (file.isDirectory() && (!FileUtils.isEmptyDirectory(file))) {
            System.out.println("Directory not empty");
        }
        Files.deleteIfExists(Path.of(path));
    }

    boolean deleteDirectoryWithRecursion(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectoryWithRecursion(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
