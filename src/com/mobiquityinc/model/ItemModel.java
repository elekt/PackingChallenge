package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;

public class ItemModel {

    private int index;
    private double weight;
    private double cost;


    public ItemModel(int index, double weight, double cost) throws APIException {

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

    public double getCost() {
        return cost;
    }
}
