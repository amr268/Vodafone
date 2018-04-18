package com.task.vodafone.data.models.bundle;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BundlesResponse {

    @SerializedName("eCode")
    private String code;
    @SerializedName("eDesc")
    private String desc;
    @SerializedName("bundles")
    private ArrayList<BundleResponse> bundleResponses;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public ArrayList<BundleResponse> getBundleResponses() {
        return bundleResponses;
    }

    public class BundleResponse {

        @SerializedName("title")
        private String title;
        @SerializedName("price")
        private String price;
        @SerializedName("currency")
        private String currency;
        @SerializedName("type")
        private String type;
        @SerializedName("description")
        private String description;

        public String getTitle() {
            return title;
        }

        public String getPrice() {
            return price;
        }

        public String getCurrency() {
            return currency;
        }

        public String getType() {
            return type;
        }

        public String getDescription() {
            return description;
        }
    }
}
