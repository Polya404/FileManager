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

    /**
     * this method removes an empty directory or removes
     * a directory with files via recursion
     *
     * @param args file path
     * @return file deletion or error message
     */
    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        if (args.size() == 0) {
            return "Enter path";
        }
        File file = new File(args.get(0));
        if (file.exists()) {
            if (args.size() == 2 && args.get(1).equals("rf")) {
                deleteDirectoryWithRecursion(file);
            } else {
                deleteDirectory(file);
            }
            return "File was delete";
        } else {
            return "File not found";
        }
    }

    /**
     * removes an empty directory
     *
     * @param file directory
     */
    @SneakyThrows
    private void deleteDirectory(File file) {
        String path = file.getPath();
        if (file.isDirectory() && (!FileUtils.isEmptyDirectory(file))) {
            System.out.println("Directory not empty");
        }
        Files.deleteIfExists(Path.of(path));
    }

    /**
     * recursively goes through the entire contents of
     * the directory and deletes everything and then
     * deletes the directory itself
     *
     * @param directoryToBeDeleted directory
     * @return boolean
     */
    private boolean deleteDirectoryWithRecursion(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectoryWithRecursion(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
