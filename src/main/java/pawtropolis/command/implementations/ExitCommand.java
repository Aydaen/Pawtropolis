package pawtropolis.command.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.database.service.GameService;
import pawtropolis.game.GameController;

@Component
public class ExitCommand extends AbstractCommand {
    private final GameService gameService;
    @Autowired
    private ExitCommand(GameController gameController, GameService gameService) {
        super(gameController);
        this.gameService = gameService;
    }

    @Override
    public void execute() {
            gameController.setGameEnded(true);
            gameService.save(gameController);
    }
}
