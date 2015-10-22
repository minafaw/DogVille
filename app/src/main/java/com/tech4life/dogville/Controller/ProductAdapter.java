package com.tech4life.dogville.Controller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech4life.dogville.Model.ProductsModel;
import com.tech4life.dogville.R;


public class ProductAdapter extends ArrayAdapter<ProductsModel>{

    Context context ;
    int layoutResourceId;
    ProductsModel data[] = null;

    public ProductAdapter(Context context , int layoutResourceId ,ProductsModel[] data)
    {
        super( context, layoutResourceId, data );
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        OfferHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new OfferHolder();
            holder.image = (ImageView)row.findViewById(R.id.image);
            holder.name =(TextView)row.findViewById(R.id.name2);
            row.setTag(holder);
        }
        else
        {
            holder = (OfferHolder)row.getTag();
        }

        ProductsModel product = data[position];
        holder.name.setText(product.getProductName());
        holder.image.setImageDrawable(product.getImage());
        return row;
    }

    static class OfferHolder
    {
        ImageView image;
        TextView name;
    }

}
