package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;


/**
 * The model of and item that can be included in the packing solution.
 *
 * @author  Tamas Elekes
 */
public class ItemModel  {

    private int index;
    private double weight;
    private int cost;

    /**
     * Creates an item model
     *
     * @param index the index of the item
     * @param weight the weight of the item
     * @param cost the cost of the item
     * @throws APIException for parameter errors
     */
    public ItemModel(int index, double weight, int cost) throws APIException {

        if(weight > 100 || cost > 100) {
            throw new APIException("Item weight and cost have to be less or equal than 100");
        }

        if(index <= 0) {
            throw new APIException("Item indexing starts from 1");
        }

        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public double getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!ItemModel.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final ItemModel other = (ItemModel) obj;

        return this.index == other.index && Double.compare(this.weight, other.weight) == 0 && this.cost == other.cost;
    }
}
