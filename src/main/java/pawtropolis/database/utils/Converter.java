package pawtropolis.database.utils;

import org.springframework.stereotype.Component;
import pawtropolis.database.entity.BagEntity;
import pawtropolis.database.entity.ItemEntity;
import pawtropolis.database.entity.PlayerEntity;
import pawtropolis.game.domain.Bag;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;

@Component
public class Converter {

    public PlayerEntity fromPlayerToEntity(Player player, BagEntity bagEntity) {
        PlayerEntity result = new PlayerEntity();
        result.setName(player.getName());
        result.setLifePoints(player.getLifePoints());
        result.setBag(bagEntity);
        return result;
    }

    public BagEntity fromBagToEntity(Bag bag){
        BagEntity result = new BagEntity();
        result.setAvailableSlots(bag.getAvailableSlots());
        return result;
    }

    public ItemEntity fromItemToEntity(Item item, BagEntity bagEntity) {
        ItemEntity result = new ItemEntity();
        result.setName(item.getName());
        result.setDescription(item.getDescription());
        result.setRequiredSlots(item.getRequiredSlots());
        result.setBag(bagEntity);
        return result;
    }
}
