package com.tech4life.dogville.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.tech4life.dogville.Controller.Constants.AppConstants;
import com.tech4life.dogville.Controller.DogsAdapter;
import com.tech4life.dogville.Controller.HorizontalListView;
import com.tech4life.dogville.Controller.ProductAdapter;
import com.tech4life.dogville.Model.DogsModel;
import com.tech4life.dogville.Model.ProductsModel;
import com.tech4life.dogville.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by karma on 18/05/2015.
 */

public class HomeFragment extends Fragment {


    private Vector<DogsModel> puppyList = new Vector<>();
    private Vector<ProductsModel> accessoryList = new Vector<>();
    private Vector<ProductsModel> foodList = new Vector<>();
    private Fragment fragment;
    private HorizontalListView listview , listview2 , listview3;
    private FragmentTransaction fragmentTransaction;
    static ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    private TextView mTitle;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
        if(bundle != null){
            accessoryList = (Vector<ProductsModel>) bundle.getSerializable(AppConstants.ACCESSORIES);
            foodList = (Vector<ProductsModel>) bundle.getSerializable(AppConstants.FOODS);
            puppyList = (Vector<DogsModel>) bundle.getSerializable(AppConstants.DOGS);
            String title = bundle.getString(AppConstants.NAME);
        }



        View rootView = inflater.inflate(R.layout.fragment_home, null);
        listview = (HorizontalListView) rootView.findViewById(R.id.listview);
        listview2 = (HorizontalListView) rootView.findViewById(R.id.listview2);
        //       listview2.setAdapter(new HAdapter2());
        listview3 = (HorizontalListView) rootView.findViewById(R.id.listview3);
        //       listview3.setAdapter(new HAdapter());
        mTitle = (TextView) rootView.findViewById(R.id.mtitle);
        mTitle.setText("Home");
        populateList();

        listview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Bundle bundle = new Bundle();
                DogsModel dog = new DogsModel();
                dog = (DogsModel) puppyList.elementAt(position);
                bundle.putSerializable(AppConstants.DETAILS2, dog);
                bundle.putSerializable(AppConstants.DETAILS, puppyList);
                bundle.putString(AppConstants.NAME, "Home");
                fragment = new DetailsFragment();
                fragment.setArguments(bundle);
                //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack("fragment");
                fragmentTransaction.commit();

            }
        });
        listview2.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Bundle bundle = new Bundle();
                ProductsModel product = new ProductsModel();
                product = (ProductsModel) accessoryList.elementAt(position);
                bundle.putSerializable(AppConstants.DETAILS2, product);
                bundle.putSerializable(AppConstants.DETAILS, accessoryList);
                bundle.putString(AppConstants.NAME, "Home");
                fragment = new DetailsFragment();
                fragment.setArguments(bundle);
                //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack("fragment");
                fragmentTransaction.commit();

            }
        });
        listview3.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Bundle bundle = new Bundle();
                ProductsModel product = new ProductsModel();
                product = (ProductsModel) foodList.elementAt(position);
                bundle.putSerializable(AppConstants.DETAILS2, product);
                bundle.putSerializable(AppConstants.DETAILS, foodList);
                bundle.putString(AppConstants.NAME, "Home");
                fragment = new DetailsFragment();
                fragment.setArguments(bundle);
                //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack("fragment");
                fragmentTransaction.commit();

            }
        });
        return rootView;
    }

    private void populateList() {
        list.clear();

        DogsModel dogs[] = new DogsModel[puppyList.size()];
        for (int i = 0; i < puppyList.size(); i++) {
            DogsModel puppy = (DogsModel) puppyList.elementAt(i);
            DogsModel element = new DogsModel();
            element.setImage(puppy.getImage());
            element.setDogName(puppy.getDogName());
            dogs[i] = element;
        }


        DogsAdapter puppyadapter = new DogsAdapter(getActivity(),
                R.layout.home_item_blue, dogs);
        listview.setAdapter(puppyadapter);

        list.clear();
        ProductsModel accessory[] = new ProductsModel[accessoryList.size()];
        for (int i = 0; i < accessoryList.size(); i++) {
            ProductsModel product = (ProductsModel) accessoryList.elementAt(i);
            ProductsModel element = new ProductsModel();
            element.setImage(product.getImage());
            element.setProductName(product.getProductName());
            accessory[i] = element;
        }

        ProductAdapter accessoryadapter = new ProductAdapter(getActivity(),
                R.layout.home_item_white, accessory);
        listview2.setAdapter(accessoryadapter);
        list.clear();


        ProductsModel foodproducts[] = new ProductsModel[foodList.size()];
        for (int i = 0; i < foodList.size(); i++) {
            ProductsModel product = (ProductsModel) foodList.elementAt(i);
            ProductsModel element = new ProductsModel();
            element.setImage(product.getImage());
            element.setProductName(product.getProductName());
            foodproducts[i] = element;
        }

        ProductAdapter foodadapter = new ProductAdapter(getActivity(),
                R.layout.home_item_blue, foodproducts);
        listview3.setAdapter(foodadapter);
    }
}