package command;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Open extends Command{
    public Open(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        if (args.isEmpty()){
            return "Please provide argument";
        }
        File file = new File(context.getCurrentDirectory(), args.get(0));
        if (!file.exists()){
            return "File not found";
        }
        if (!file.isFile()){
            return "give me file please";
        }
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
}
