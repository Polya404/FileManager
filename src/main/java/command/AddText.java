package command;

import lombok.SneakyThrows;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class AddText extends Command {
    private Scanner scanner = new Scanner(System.in);
    private File file = context.getCurrentDirectory();

    public AddText(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        System.out.println("Add text");
        String str = scanner.nextLine();
        System.out.println("add an entry to the end of the file ?  y/n");
        String answer = scanner.nextLine();
        if (answer.equals("n")) {
            addTextOnPosition(str);
        } else {
            Files.write(file.toPath(), str.getBytes(), StandardOpenOption.APPEND);
        }
        return "Text added";
    }

    @SneakyThrows
    public void addTextOnPosition(String data) {
        System.out.println("write in which position you want to write the text ");
        int pos = scanner.nextInt();
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(pos);
        raf.write(data.getBytes(StandardCharsets.UTF_8));
        raf.close();
    }
}
