package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;

import java.util.List;


/**
 *  Data model that represents a package.
 *
 * @author  Tamas Elekes
 */
public class PackageModel {

    private int maxWeight;
    private List<ItemModel> items;

    /**
     * @param maxWeight the total possible weight of the choosen items
     * @param items all the items in a packer problem
     */
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
