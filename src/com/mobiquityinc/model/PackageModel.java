package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;

import java.util.List;

public class PackageModel {

    private int maxWeight;
    private List<ItemModel> items;

    public PackageModel(int maxWeight, List<ItemModel> items) throws APIException{

        if(maxWeight > 100 ) {
            throw new APIException("Package weight have to be less or equal than 100");
        }

        if(items.size() > 15) {
            throw new APIException("Maximum of 15 items can be in a package");
        }

        this.maxWeight = maxWeight;
        this.items = items;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public List<ItemModel> getItems() {
        return items;
    }
}
