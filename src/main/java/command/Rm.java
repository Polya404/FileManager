package command;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Rm extends Command{
    public Rm(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify the path,  where you want to delete file.");
        File file = new File(scanner.nextLine());
        String path = file.getPath();
        if (file.isDirectory() && (!FileUtils.isEmptyDirectory(file))){
            return "Directory not empty";
        }
        Files.deleteIfExists(Path.of(path));
        return "File was delete";
    }
}
