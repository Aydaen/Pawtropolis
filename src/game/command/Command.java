package game.command;

import java.util.List;

public interface Command {
    void execute(List<String> parameters);
}
