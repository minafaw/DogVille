package com.tech4life.dogville.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.tech4life.dogville.Controller.Utils;
import com.tech4life.dogville.Model.DogsModel;
import com.tech4life.dogville.Model.ProductsModel;
import com.tech4life.dogville.R;
import com.tech4life.dogville.Controller.Constants.AppConstants;

import java.util.Vector;


/**
 * Created by karma on 19/05/2015.
 */

public class MenuFragment extends Fragment {

    Vector<ProductsModel> productList = new Vector<ProductsModel>();
    static Vector<ProductsModel> orderList = new Vector<ProductsModel>();

    public static Handler operationHandler;
    private Fragment fragment;
    private ImageButton btnHome, btnPuppy, btnTips, btnProduct, btnAccount;
    Bundle bundle;
    FragmentTransaction fragmentTransaction;
    private Vector<DogsModel> dogsList;
    private Vector<ProductsModel> accessoriesList;
    private Vector<ProductsModel> foodsList;

    public MenuFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Utils.showLoader(getActivity());
        setActionHandler();
        Intent intent = new Intent(getActivity(), HomeService.class);
        intent.putExtra("data", HomeService.HOME_ACCESSORIES);
        getActivity().startService(intent);
        Intent intent2 = new Intent(getActivity(), HomeService.class);
        intent2.putExtra("data", HomeService.HOME_FOOD);
        getActivity().startService(intent);
        Intent intent3 = new Intent(getActivity(), HomeService.class);
        intent3.putExtra("data", HomeService.HOME_PUPPIES);
        getActivity().startService(intent);

        bundle = new Bundle();
        bundle.putSerializable(AppConstants.DOGS, dogsList);
        bundle.putSerializable(AppConstants.PRODUCTS, accessoriesList);
        bundle.putSerializable(AppConstants.FOODS, foodsList);
        View view = inflater.inflate(R.layout.menu_multi_fragment, container, false);

        btnHome = (ImageButton) view.findViewById(R.id.home_btn);
        btnPuppy = (ImageButton) view.findViewById(R.id.puppy_btn);

        btnTips = (ImageButton) view.findViewById(R.id.tips_btn);
        btnProduct = (ImageButton) view.findViewById(R.id.product_btn);
        btnAccount = (ImageButton) view.findViewById(R.id.account_btn);

        btnHome.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                goHome();

            }
        });

        btnPuppy.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                goPuppy();
            }
        });

        btnTips.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                goTips();

            }
        });

        btnProduct.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                goProduct();
            }
        });

        btnAccount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                goAccount();
            }
        });

        return view;
    }


    public void setActionHandler() {
        operationHandler = new Handler() {
            @SuppressWarnings({"unchecked"})
            public void handleMessage(Message msg) {

                if (msg.arg1 == HomeService.HOME_ACCESSORIES) {
                    accessoriesList = ((Vector<ProductsModel>) msg.obj);
                } else if (msg.arg1 == HomeService.HOME_FOOD) {
                    foodsList = ((Vector<ProductsModel>) msg.obj);
                } else if (msg.arg1 == HomeService.HOME_PUPPIES) {
                    dogsList = ((Vector<DogsModel>) msg.obj);
                }
                bundle = new Bundle();
                if (accessoriesList != null)
                    bundle.putSerializable(AppConstants.ACCESSORIES, accessoriesList);
                if (foodsList != null)
                    bundle.putSerializable(AppConstants.FOODS, foodsList);
                if (dogsList != null) {
                    bundle.putSerializable(AppConstants.DOGS, dogsList);
                    Utils.hideLoader();
                    fragment = new HomeFragment();
                    fragment.setArguments(bundle);
                    //fragmentTransaction = getFragmentManager().beginTransaction().add(R.id.container, fragment);
                    fragmentTransaction.commit();

                }
            }
        };

    }


    public void goAccount() {
        fragment = new AccountFragment();
        btnHome.setImageResource(R.drawable.home);
        btnPuppy.setImageResource(R.drawable.puppy);
        btnProduct.setImageResource(R.drawable.product);
        btnTips.setImageResource(R.drawable.tips);
        fragment.setArguments(bundle);
//        btnAccount.setImageResource(R.drawable.account_h);
        //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public void goTips() {
        fragment = new TipsFragment();
        btnHome.setImageResource(R.drawable.home);
        btnPuppy.setImageResource(R.drawable.puppy);
        btnProduct.setImageResource(R.drawable.product);
//        btnTips.setImageResource(R.drawable.tips_h);
        btnAccount.setImageResource(R.drawable.account);
        //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public void goProduct() {
        fragment = new ProductFragment();
        bundle.putString(AppConstants.NAME, "Products");
        fragment.setArguments(bundle);
        btnHome.setImageResource(R.drawable.home);
        btnPuppy.setImageResource(R.drawable.puppy);
//        btnProduct.setImageResource(R.drawable.product_h);
        btnTips.setImageResource(R.drawable.tips);
        btnAccount.setImageResource(R.drawable.account);
        //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public void goPuppy() {
        fragment = new PuppyFragment();
        bundle.putString(AppConstants.NAME, "Puppies");
        fragment.setArguments(bundle);
        btnHome.setImageResource(R.drawable.home);
//        btnPuppy.setImageResource(R.drawable.puppy_h);
        btnProduct.setImageResource(R.drawable.product);
        btnTips.setImageResource(R.drawable.tips);
        btnAccount.setImageResource(R.drawable.account);
       // fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public void goHome() {
        fragment = new HomeFragment();
//        btnHome.setImageResource(R.drawable.home_h);
        bundle.putString(AppConstants.NAME, "Home");
        fragment.setArguments(bundle);
        btnPuppy.setImageResource(R.drawable.puppy);
        btnProduct.setImageResource(R.drawable.product);
        btnTips.setImageResource(R.drawable.tips);
        btnAccount.setImageResource(R.drawable.account);
        //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

}
