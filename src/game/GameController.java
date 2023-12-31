package game;

import game.command.Command;
import game.command.EnumCommand;
import game.console.InputController;
import game.domain.Player;
import lombok.Getter;
import lombok.Setter;
import map.domain.Room;
import map.utils.RoomFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO @NoArgsConstructor(access = AccessLevel.PRIVATE) ???
@Getter
public class GameController {
    private static GameController instance = null;
    private static final int DEFAULT_MAP_RECURSION_DEPTH = 3;
    @Setter
    private Room currentRoom;
    private Player player;
    @Setter
    private boolean gameEnded;

    private GameController() {
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void runGame() {
        String input;
        System.out.println("What's your name?");
        System.out.print(">");
        input = InputController.readString();
        player = new Player(input);
        currentRoom = RoomFactory.getInstance().generateGameMap(DEFAULT_MAP_RECURSION_DEPTH);
        gameEnded = false;
        System.out.println("Welcome " + player.getName() + ", let's play!");

        while (!isGameEnded()) {
            System.out.println("What do you wanna do?");
            System.out.print(">");
            input = InputController.readString();

            String[] splitInput = input.trim().split("\\s+");
            String commandName = splitInput[0].toLowerCase();
            List<String> parameters = new ArrayList<>(Arrays.asList(splitInput).subList(1, splitInput.length));

            Command command = EnumCommand.getCommandByString(commandName);
            command.execute(parameters);
        }
    }
}
