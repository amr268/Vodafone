package com.task.vodafone.data.models.bundle;

import java.util.ArrayList;

public class BundleModels {
    private String title;
    private ArrayList<BundleModel> bundleModels;

    public BundleModels(String title, ArrayList<BundleModel> bundleModels) {
        this.title = title;
        this.bundleModels = bundleModels;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<BundleModel> getBundleModels() {
        return bundleModels;
    }
}
