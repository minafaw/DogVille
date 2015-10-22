package com.tech4life.dogville.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tech4life.dogville.Controller.ProductAdapter;
import com.tech4life.dogville.Model.ProductsModel;
import com.tech4life.dogville.R;
import com.tech4life.dogville.Controller.Constants.AppConstants;

import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.TextView;


public class ProductFragmentDetails extends Fragment {

    Vector<ProductsModel> productList = new Vector<ProductsModel>();
    Fragment fragment;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    static ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    ListView listView;
    TextView mtitle;
    public ProductFragmentDetails() {

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        productList = (Vector<ProductsModel>) bundle.getSerializable(AppConstants.DETAILS);
        String title = bundle.getString(AppConstants.NAME);
        View rootView = inflater.inflate(R.layout.fragment_product, null);
        mtitle = (TextView) rootView.findViewById(R.id.mtitle);
        mtitle.setText(title);
        listView = (ListView) rootView.findViewById(R.id.listView);
        populateList();
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Bundle bundle = new Bundle();
                ProductsModel product = new ProductsModel();
                product = (ProductsModel) productList.elementAt(position);
                bundle.putSerializable(AppConstants.DETAILS2, product);
                bundle.putSerializable(AppConstants.DETAILS,productList);
                bundle.putString(AppConstants.NAME, "Products");
                fragment = new DetailsFragment();
                fragment.setArguments(bundle);
                //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack("fragment");
                fragmentTransaction.commit();
            }
        });

        return rootView;

    }

   private void populateList(){
        list.clear();
        ProductsModel products[] = new ProductsModel[productList.size()];
        for (int i = 0; i < productList.size(); i++) {
            ProductsModel product = (ProductsModel) productList.elementAt(i);
            ProductsModel element = new ProductsModel();
            element.setImage(product.getImage());
            element.setProductName(product.getProductName());
            products[i] = element;
        }

        ProductAdapter adapter = new ProductAdapter(getActivity(),
                R.layout.ctrl_listview_item_row, products);
        listView.setAdapter(adapter);
    }

}