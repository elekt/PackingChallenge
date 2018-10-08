package com.mobiquityinc.packer;

import com.mobiquityinc.model.ItemModel;
import com.mobiquityinc.model.PackageModel;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSolver implements Solver {
    @Override
    public String solve(PackageModel pack) {
        StringBuilder resultBuilder = new StringBuilder();

        boolean visited[] = new boolean[pack.getItems().size()];
        knapSack(pack.getMaxWeight(), pack.getItems(), pack.getItems().size(), visited);


        for(int i=0; i < pack.getItems().size(); i++) {
            if(visited[i]) {
                resultBuilder.append(i + 1);
                resultBuilder.append(", ");
            }
        }

        if(resultBuilder.length() == 0) {
            resultBuilder.append("-");
        } else {
            resultBuilder.deleteCharAt(resultBuilder.length()-2);
        }

        return resultBuilder.toString().trim();
    }

    private int knapSack(double maxWeight, List<ItemModel> items, int n, boolean visited[]) {

        if (n == 0 || maxWeight == 0) {
            return 0;
        }

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (items.get(n-1).getWeight() > maxWeight) {

            return knapSack(maxWeight, items, n-1, visited);
        } else {

            boolean v1[]=new boolean[visited.length];
            System.arraycopy(visited, 0, v1, 0, v1.length);
            boolean v2[]=new boolean[visited.length];
            System.arraycopy(visited, 0, v2, 0, v2.length);
            v1[n-1]=true;

            int ans1 = items.get(n-1).getCost() + knapSack(maxWeight-items.get(n-1).getWeight(), items, n-1, v1);
            int ans2 = knapSack(maxWeight, items, n-1,v2);
            if(ans1>ans2){
                System.arraycopy(v1, 0, visited, 0, v1.length);
                return ans1;
            } else{
                System.arraycopy(v2, 0, visited, 0, v2.length);
                return ans2;
            }
        }
    }
}
