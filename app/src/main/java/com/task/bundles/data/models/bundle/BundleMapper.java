package com.task.bundles.data.models.bundle;

import com.task.bundles.di.activity.ActivityScope;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

@ActivityScope
public class BundleMapper {

    @Inject
    public BundleMapper() {
    }

    public BundleModel toBundleModel(BundlesResponse.BundleResponse bundleResponse) {
        return new BundleModel(bundleResponse.getTitle(),
                bundleResponse.getPrice(),
                bundleResponse.getCurrency(),
                bundleResponse.getType(),
                bundleResponse.getDescription());
    }

    public ArrayList<BundleModel> toBundleModels(ArrayList<BundlesResponse.BundleResponse> bundleResponses) {
        ArrayList<BundleModel> bundleModels = new ArrayList<>();
        for (BundlesResponse.BundleResponse bundleResponse : bundleResponses)
            bundleModels.add(toBundleModel(bundleResponse));
        return bundleModels;
    }

    public HashMap<String, ArrayList<BundleModel>> toBundleModelsMap(ArrayList<BundleModel> bundleModels) {
        HashMap<String, ArrayList<BundleModel>> bundlesMap = new HashMap<>();
        for (BundleModel bundleModel : bundleModels) {
            if (!bundlesMap.containsKey(bundleModel.getType())) {
                ArrayList<BundleModel> list = new ArrayList<>();
                list.add(bundleModel);
                bundlesMap.put(bundleModel.getType(), list);
            } else {
                bundlesMap.get(bundleModel.getType()).add(bundleModel);
            }
        }
        return bundlesMap;
    }
}
