package com.task.vodafone.data.api;

import com.task.vodafone.data.models.bundle.BundlesResponse;
import com.task.vodafone.di.application.ApplicationScope;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@ApplicationScope
public class WebServicesStore {

    @Inject
    public WebServicesStore() {
    }

    public Single<ArrayList<BundlesResponse.BundleResponse>> fetchBundles() {
        return Single.create(emitter -> {
            IServices services = IServices.retrofit.create(IServices.class);
            services.getBundlesRequest()
                    .enqueue(new Callback<BundlesResponse>() {
                        @Override
                        public void onResponse(Call<BundlesResponse> call, Response<BundlesResponse> response) {
                            emitter.onSuccess(response.body().getBundleResponses());
                        }

                        @Override
                        public void onFailure(Call<BundlesResponse> call, Throwable t) {
                            emitter.onError(t);
                        }
                    });
        });
    }
}
