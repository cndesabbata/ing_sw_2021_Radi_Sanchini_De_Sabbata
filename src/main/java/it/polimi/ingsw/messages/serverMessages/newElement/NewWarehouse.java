package it.polimi.ingsw.messages.serverMessages.newElement;

import it.polimi.ingsw.server.model.ResourceQuantity;

import java.util.List;

public class NewWarehouse implements ChangeMessage{
    private final List<ResourceQuantity> warehouse;
    private final int initialDim;
    private final String owner;

    public NewWarehouse(List<ResourceQuantity> warehouse, int initialDim, String owner) {
        this.warehouse = warehouse;
        this.initialDim = initialDim;
        this.owner = owner;
    }

    public List<ResourceQuantity> getWarehouse() {
        return warehouse;
    }

    public int getInitialDim() {
        return initialDim;
    }

    public String getOwner() {
        return owner;
    }
}
