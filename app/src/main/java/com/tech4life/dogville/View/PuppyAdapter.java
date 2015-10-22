package com.tech4life.dogville.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.tech4life.dogville.Model.DogsModel;
import com.tech4life.dogville.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NT on 10/22/15.
 */
public class PuppyAdapter extends RecyclerView.Adapter<PuppyAdapter.PuppyViewHolder> {

    private List<DogsModel> _dogsItems;

    public PuppyAdapter (List<DogsModel> items){
        _dogsItems = new ArrayList<>();
        _dogsItems = items;
    }

    @Override
    public PuppyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.puppy_cardrow, parent, false);
        return new PuppyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PuppyViewHolder holder, int position) {
        holder._Puppy_image.setImageBitmap(_dogsItems.get(position).getBitmapImage());
        holder._Puppy_name.setText(_dogsItems.get(position).getDogName());
        holder._Puppy_age.setText(_dogsItems.get(position).getDog_age());
        holder._Puppy_color.setText(_dogsItems.get(position).getDog_color());
        holder._Puppy_gender.setText(_dogsItems.get(position).getGenderId());

    }

    @Override
    public int getItemCount() {
        return _dogsItems.size();
    }

    public class PuppyViewHolder extends RecyclerView.ViewHolder {
        protected NetworkImageView _Puppy_image;
        protected TextView _Puppy_name, _Puppy_age, _Puppy_color, _Puppy_gender;

        public PuppyViewHolder(View itemView) {
            super(itemView);
            _Puppy_image  = (NetworkImageView) itemView.findViewById(R.id.puppy_imageView);
            _Puppy_name   = (TextView) itemView.findViewById(R.id.puppy_name);
            _Puppy_age    = (TextView) itemView.findViewById(R.id.puppy_age);
            _Puppy_color  = (TextView) itemView.findViewById(R.id.puppy_color);
            _Puppy_gender = (TextView) itemView.findViewById(R.id.puppy_gender);

        }
    }
}
