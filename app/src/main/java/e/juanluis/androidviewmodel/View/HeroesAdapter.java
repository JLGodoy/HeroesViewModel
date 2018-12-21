package e.juanluis.androidviewmodel.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.List;

import e.juanluis.androidviewmodel.Model.Hero;
import e.juanluis.androidviewmodel.R;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

    Context mContext;
    List<Hero> heroList;

    public HeroesAdapter(Context mContext, List<Hero> heroList){
         this.mContext = mContext;
         this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Hero hero = heroList.get(position);
        holder.textView.setText(hero.getName());

        Glide.with(mContext)
                .load(hero.getImageurl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }


    public class HeroViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public HeroViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
