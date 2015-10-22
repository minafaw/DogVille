package com.tech4life.dogville.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech4life.dogville.Controller.Constants.AppConstants;
import com.tech4life.dogville.Model.ProductsModel;
import com.tech4life.dogville.R;

import java.util.Vector;

public class DetailsFragment extends Fragment {
    TextView title,tv1,tv2,tv3,tv4;

    ImageView imageVew;
    Vector<ProductsModel> productList = new Vector<ProductsModel>();
    static ProductsModel  product = new ProductsModel();
    Fragment fragment;
    String name;
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();

        product = (ProductsModel)bundle.getSerializable(AppConstants.DETAILS2);
        name = bundle.getString(AppConstants.NAME);
        productList = (Vector<ProductsModel>) bundle.getSerializable(AppConstants.DETAILS);
        View rootView = inflater.inflate(R.layout.fragment_details, null);
        title = (TextView) rootView.findViewById(R.id.titleTV);
        title.setText(product.getProductName());
        tv1 = (TextView) rootView.findViewById(R.id.title1TV);
        tv1.setText(product.getDescription());
        tv2 = (TextView) rootView.findViewById(R.id.title2TV);
        tv2.setText(product.getPrice());
        imageVew = (ImageView) rootView.findViewById(R.id.imageV);
        imageVew.setBackgroundDrawable(product.getImage());

    return  rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    // handle back button's click listener
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(AppConstants.DETAILS,productList);
                    if(name.equals("Home")) {
                        fragment = new HomeFragment();
                        fragment.setArguments(bundle);
                        //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
                        //fragmentTransaction.commit();
                    }else if(name.equals("Puppies")) {
                        fragment = new PuppyFragment();
                        fragment.setArguments(bundle);
                        //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
                        //fragmentTransaction.commit();
                    }else if(name.equals("Products")) {
                        fragment = new ProductFragmentDetails();
                        fragment.setArguments(bundle);
                        //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
                        //fragmentTransaction.commit();
                    }
                    return true;
                }
                return false;
            }
        });
    }


    public static void  addProduct_ActionHandler()
    {
        MenuFragment.orderList.addElement(product);
    }

}

