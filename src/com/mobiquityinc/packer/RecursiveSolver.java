package com.mobiquityinc.packer;

import com.mobiquityinc.model.ItemModel;
import com.mobiquityinc.model.PackageModel;

import java.util.List;

/**
 * A recursive solver for the knapsack problem
 *
 * @author  Tamas Elekes
 */
public class RecursiveSolver implements Solver {

    /**
     * Builds the solution of the packaging problem
     * @param pack the package model
     * @return a String listing the indexes of the used items
     */
    @Override
    public String solve(PackageModel pack) {
        StringBuilder resultBuilder = new StringBuilder();

        boolean visited[] = new boolean[pack.getItems().size()];
        recursion(pack.getMaxWeight(), pack.getItems(), pack.getItems().size(), visited);

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

    /**
     * Recursive solver of the knapsack problem.
     * @param maxWeight the total weight that the package can include
     * @param items the items that can be included in the package
     * @param n the depth of the recursion, stops when runs out of items
     * @param visited bool array that corresponds to the choosen items
     * @return the maximum cost that can be obtained with the given package size and items
     */
    private int recursion(double maxWeight, List<ItemModel> items, int n, boolean visited[]) {

        if (n == 0 || maxWeight == 0) {
            return 0;
        }

        // skipping items that are larger than the remaining space left in the package
        if (items.get(n-1).getWeight() > maxWeight) {
            return recursion(maxWeight, items, n-1, visited);
        } else {
            // maintaining the copy in each depth of the items we included
            boolean visited1[] = new boolean[visited.length];
            System.arraycopy(visited, 0, visited1, 0, visited1.length);
            boolean visited2[] = new boolean[visited.length];
            System.arraycopy(visited, 0, visited2, 0, visited2.length);
            visited1[n-1] = true;

            // we include this item
            int sumCost1 = items.get(n-1).getCost() + recursion(maxWeight-items.get(n-1).getWeight(), items, n-1, visited1);
            // we do not include this item
            int sumCost2 = recursion(maxWeight, items, n-1, visited2);

            // return the better solution, and copy back to the original visited array this solution
            if(sumCost1 > sumCost2){
                System.arraycopy(visited1, 0, visited, 0, visited1.length);
                return sumCost1;
            } else{
                System.arraycopy(visited2, 0, visited, 0, visited2.length);
                return sumCost2;
            }
        }
    }
}
