package com.task.vodafone.ui.home;

import com.amr.core.activity.BaseScreen;
import com.task.vodafone.data.models.bundle.BundleModel;

import java.util.ArrayList;
import java.util.HashMap;

public interface HomeScreen extends BaseScreen {
    void updateUi(HashMap<String, ArrayList<BundleModel>> bundleModelsMap);
    void updateRecyclerPosition(int position);
}
