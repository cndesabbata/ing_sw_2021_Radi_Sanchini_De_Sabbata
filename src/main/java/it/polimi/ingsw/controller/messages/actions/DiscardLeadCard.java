package it.polimi.ingsw.controller.messages.actions;

import it.polimi.ingsw.controller.messages.actions.Action;
import it.polimi.ingsw.model.LeaderCard;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.exceptions.WrongActionException;

import java.util.List;

public class DiscardLeadCard implements Action {
    private final int index;
    List<LeaderCard> hand;

    public DiscardLeadCard(int index) {
        this.index = index;
        this.hand = null;
    }

    @Override
    public boolean doAction(Player player) {
        hand.remove(index);
        player.getBoard().getItinerary().updatePosition(1);
        return false;
    }

    @Override
    public void checkAction(Player player) throws WrongActionException {
        hand = player.getHandLeaderCards();
        if (index <= 0 || index > hand.size())
            throw new WrongActionException("The specified index is out of bounds");
    }
}