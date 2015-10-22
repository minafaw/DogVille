package com.tech4life.dogville.View;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tech4life.dogville.Controller.ProductAdapter;
import com.tech4life.dogville.Model.ProductsModel;
import com.tech4life.dogville.R;

/**
 * Created by karma on 05/09/2015.
 */
public class ProductFragment extends Fragment {

    ListView listView;
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
       View rootView = inflater.inflate(R.layout.fragment_product, null);
       listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setDivider(null);
       populateList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

            }
        });
        return rootView;
    }

    private void populateList() {

        ProductsModel products[] = new ProductsModel[8];

        // elements of product list
        ProductsModel element = new ProductsModel();
        String uri = "@drawable/product_1";
        int imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        element.setImage(res);
        element.setProductName("Dog Food");
        products[0] = element;

        element = new ProductsModel();
        uri = "@drawable/product_2";
        imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
        res = getResources().getDrawable(imageResource);
        element.setImage(res);
        element.setProductName("Treats");
        products[1] = element;

        element = new ProductsModel();
        uri = "@drawable/product_3";
        imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
        res = getResources().getDrawable(imageResource);
        element.setImage(res);
        element.setProductName("Rawhide");
        products[2] = element;


        element = new ProductsModel();
        uri = "@drawable/product_4";
        imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
        res = getResources().getDrawable(imageResource);
        element.setImage(res);
        element.setProductName("Supplements");
        products[3] = element;


        element = new ProductsModel();
        uri = "@drawable/product_5";
        imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
        res = getResources().getDrawable(imageResource);
        element.setImage(res);
        element.setProductName("Collar & leaches");
        products[4] = element;


        element = new ProductsModel();
        uri = "@drawable/product_6";
        imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
        res = getResources().getDrawable(imageResource);
        element.setImage(res);
        element.setProductName("Fleas and ticks");
        products[5] = element;


        element = new ProductsModel();
        uri = "@drawable/product_7";
        imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
        res = getResources().getDrawable(imageResource);
        element.setImage(res);
        element.setProductName("Shampoos");
        products[6] = element;

        element = new ProductsModel();
         uri = "@drawable/product_8";
         imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
         res = getResources().getDrawable(imageResource);
        element.setImage(res);
        element.setProductName("Brunches");
        products[7] = element;

        ProductAdapter adapter = new ProductAdapter(getActivity(),
                R.layout.ctrl_product_item, products);
        listView.setAdapter(adapter);
    }
    }