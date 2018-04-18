package com.task.vodafone.data.models.bundle;

import com.task.vodafone.di.activity.ActivityScope;

import java.util.ArrayList;

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
}
