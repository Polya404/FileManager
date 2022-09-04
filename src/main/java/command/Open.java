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
        File file = context.getCurrentDirectory();
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
}
