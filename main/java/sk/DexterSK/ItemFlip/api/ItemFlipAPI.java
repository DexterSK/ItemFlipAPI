package sk.DexterSK.ItemFlip.api;

import sk.DexterSK.ItemFlip.storage.PlayerData;
import java.util.Optional;
import org.bukkit.entity.Player;

public interface ItemFlipAPI
{
	/**
     * Fetch player data
     *
     * @param player The player to search
     * @return  Optional of player data, represents if they are loaded in cache
     */
	Optional<PlayerData> getPlayerData( Player player );
}
