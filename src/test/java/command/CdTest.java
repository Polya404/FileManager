package command;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CdTest extends TestCase {

    public void testExecute() {
        Context context = new Context(null, new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command"));
        Cd cd = new Cd(context);

        List<String> args = new ArrayList<>();

        Assertions.assertEquals("Incorrect argument. Use `..` to navigate to parent directory or choose right child directory", cd.execute(args));

        args.add(" ..");
        Assertions.assertEquals("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java", cd.execute(args));
    }
}