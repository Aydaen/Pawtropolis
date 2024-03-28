package pawtropolis.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pawtropolis.database.entity.BagEntity;
import pawtropolis.database.entity.ItemEntity;
import pawtropolis.database.entity.PlayerEntity;
import pawtropolis.database.repo.*;
import pawtropolis.database.utils.Converter;
import pawtropolis.game.GameController;
import pawtropolis.game.domain.Bag;
import pawtropolis.game.domain.Player;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final AdjacentRoomRepository adjacentRoomRepository;
    private final AnimalRepository animalRepository;
    private final BagRepository bagRepository;
    private final DirectionRepository directionRepository;
    private final GameRepository gameRepository;
    private final ItemRepository itemRepository;
    private final PlayerRepository playerRepository;
    private final RoomRepository roomRepository;
    private final SpeciesRepository speciesRepository;
    private final Converter converter;

    public void save(GameController gameController) {
        Player playerToSave = gameController.getPlayer();
        Bag bag = playerToSave.getBag();
        BagEntity savedBag = bagRepository.save(converter.fromBagToEntity(bag));
        PlayerEntity savedPlayer = playerRepository.save(converter.fromPlayerToEntity(playerToSave, savedBag));
        List<ItemEntity> savedItems = bag.getItemList().stream()
                .map(item -> itemRepository.save(converter.fromItemToEntity(item, savedBag))).toList();
    }

}
