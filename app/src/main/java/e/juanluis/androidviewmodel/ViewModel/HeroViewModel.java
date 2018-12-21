package e.juanluis.androidviewmodel.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import java.util.List;

import e.juanluis.androidviewmodel.Model.Api;
import e.juanluis.androidviewmodel.Model.Hero;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroViewModel extends ViewModel {

    private MutableLiveData<List<Hero>> heroList; //this is the data we will fetch asynchronously.

    public LiveData<List<Hero>> getHeroes(){ //method used to call the data.
        if (heroList == null){
            heroList = new MutableLiveData<List<Hero>>();
            loadHeroes();
        }
        return heroList;
    }

    private void loadHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api= retrofit.create(Api.class);
        Call<List<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
    }
}
