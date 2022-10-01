import command.Command;
import command.Context;
import service.Service;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(null, new File("E:\\Polya project\\JavaProject\\FileManager\\src\\main\\java\\command"));
        Map<String, Command> commands = Service.getCommands(context);
        context.setCommandMap(commands);

        System.out.println("Hi there! Press q or exit to quit");
        Service.performCommands(context, commands);
    }
}