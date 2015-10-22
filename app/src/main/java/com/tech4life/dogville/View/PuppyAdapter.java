package com.tech4life.dogville.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by NT on 10/22/15.
 */
public class PuppyAdapter extends RecyclerView.Adapter<PuppyAdapter.PuppyViewHolder> {


    @Override
    public PuppyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PuppyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PuppyViewHolder extends RecyclerView.ViewHolder {

        public PuppyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
