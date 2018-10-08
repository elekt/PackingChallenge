package com.mobiquityinc.model;

import java.util.List;

public class PackageModel {

    private int totalWeight;
    private List<ItemModel> items;

    public PackageModel(int totalWeight, List<ItemModel> items) {
        this.totalWeight = totalWeight;
        this.items = items;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public List<ItemModel> getItems() {
        return items;
    }
}
