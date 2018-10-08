package com.mobiquityinc.packer;

import com.mobiquityinc.model.PackageModel;

/**
 * Interface so that different solver solutions can be tested easily
 *
 * @author Tamas Elekes
 */
public interface Solver {
    String solve(PackageModel pack);
}
