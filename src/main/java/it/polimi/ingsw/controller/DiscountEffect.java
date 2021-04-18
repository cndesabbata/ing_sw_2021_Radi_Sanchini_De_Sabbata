package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.*;

import java.util.ArrayList;

public class DiscountEffect implements LeaderEffect{
    private final Resource resource;

    public DiscountEffect(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void doLeaderEffect(Player player, Action action) throws WrongActionException {
        if (action instanceof BuyDevCard){
            ArrayList<LeaderCard> playerCards = player.getHandLeaderCards();
            boolean check = false;
            for(LeaderCard Lc : playerCards){
                if (Lc.getResource() == resource && Lc.getType() == LeaderType.DISCOUNT && Lc.isPlayed()) {
                    check = true;
                    break;
                }
            }
            if(!check) throw new WrongActionException("The player does not have the corresponding leadCard");
            else {
                for (ResourceQuantity res : ((BuyDevCard) action).getReq()){
                    if (res.getResource().equals(resource)){
                        ((BuyDevCard) action).getReq().remove(res);
                        break;
                    }
                }
            }
        }
    }
}