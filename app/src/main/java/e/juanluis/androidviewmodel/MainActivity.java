package e.juanluis.androidviewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;


import e.juanluis.androidviewmodel.Model.Hero;

import e.juanluis.androidviewmodel.View.HeroesAdapter;
import e.juanluis.androidviewmodel.ViewModel.HeroViewModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HeroesAdapter heroesAdapter;
    List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        HeroViewModel model = ViewModelProviders.of(this).get(HeroViewModel.class);

       model.getHeroes().observe(this, new Observer<List<Hero>>(){


           @Override
           public void onChanged(@Nullable List<Hero> heroList){
               heroesAdapter = new HeroesAdapter(MainActivity.this, heroList);
               recyclerView.setAdapter(heroesAdapter);
           }
       });




    }


}
