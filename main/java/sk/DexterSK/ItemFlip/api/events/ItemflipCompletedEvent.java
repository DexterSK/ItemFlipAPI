package sk.DexterSK.ItemFlip.api.events;

import java.io.IOException;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import sk.DexterSK.ItemFlip.utilz.Serializers;

public class ItemflipCompletedEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private OfflinePlayer player1;
    private OfflinePlayer player2;
    // Base64 serialized items
    private String p1_items;
    private String p2_items;
    private OfflinePlayer winner;
    private OfflinePlayer loser;
    private Long timestamp;

    public ItemflipCompletedEvent(OfflinePlayer player1, OfflinePlayer player2, String p1_items, String p2_items, OfflinePlayer winner, OfflinePlayer loser, Long timestamp) {
        this.player1 = player1;
        this.player2 = player2;
        this.p1_items = p1_items;
        this.p2_items = p2_items;
        this.winner = winner;
        this.loser = loser;
        this.timestamp = timestamp;
    }

    public Long getTimestamp() {
        return timestamp;
    }
    
    public OfflinePlayer getP1() {
        return player1;
    }

    public OfflinePlayer getP2() {
        return player2;
    }
    
    public OfflinePlayer getWinner() {
        return winner;
    }

    public OfflinePlayer getLoser() {
        return loser;
    }

    public ItemStack[] getP1Items() {
        try {
			return Serializers.itemStackArrayFromBase64( p1_items );
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public ItemStack[] getP2Items() {
        try {
			return Serializers.itemStackArrayFromBase64( p2_items );
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
}
