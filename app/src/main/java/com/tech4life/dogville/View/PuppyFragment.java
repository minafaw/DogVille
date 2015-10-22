package com.tech4life.dogville.View;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tech4life.dogville.Controller.Utils;
import com.tech4life.dogville.Model.DogsModel;
import com.tech4life.dogville.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by karma on 18/05/2015.
 */

public class PuppyFragment extends Fragment {

    //private Vector<DogsModel> puppyList = new Vector<>();
    //public static Handler operationHandler;
    //private Fragment fragment;
    //private FragmentTransaction fragmentTransaction;
    static ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    //private GridView gridView;
    //private TextView mTitle;
    private String title = "Puppies";

    private List<DogsModel> _PuppyListItems = new ArrayList<>();
    private RecyclerView _PuppyRecycleView;

    public PuppyFragment() {

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Utils.showLoader(getActivity());
        //setActionHandler();
        //Intent intent = new Intent(getActivity(), PuppyService.class);
        //getActivity().startService(intent);
        View rootView = inflater.inflate(R.layout.fragment_puppies, null);

        _PuppyRecycleView = (RecyclerView) rootView.findViewById(R.id.puppyList);
        _PuppyRecycleView.addOnItemTouchListener(new RecycleOntouchListner(getActivity(), new ClickListner() {
            @Override
            public void OnClick(View view, int position) {
                Toast.makeText(getContext().getApplicationContext(), "position" + position , Toast.LENGTH_LONG).show();
            }
        }));

        //mTitle = (TextView) rootView.findViewById(R.id.mtitle);
        //gridView = (GridView) rootView.findViewById(R.id.gridView);
        //mTitle.setText(title);

//        gridView.setOnItemClickListener(new OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Bundle bundle = new Bundle();
//                DogsModel dog = new DogsModel();
//                dog = (DogsModel) puppyList.elementAt(position);
//                bundle.putSerializable(AppConstants.DETAILS2, dog);
//                bundle.putSerializable(AppConstants.DOGS, puppyList);
//                bundle.putString(AppConstants.NAME, "Puppies");
//                fragment = new DetailsFragment();
//                fragment.setArguments(bundle);
//                //fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
//                fragmentTransaction.addToBackStack("fragment");
//                fragmentTransaction.commit();
//            }
//        });

        return rootView;
    }

//    private void setActionHandler() {
//        operationHandler = new Handler() {
//            @SuppressWarnings({"unchecked"})
//            public void handleMessage(Message msg) {
//                Utils.hideLoader();
//                {
//                    puppyList = ((Vector<DogsModel>) msg.obj);
//                    populateList();
//                }
//            }
//        };
//    }

//    private void populateList() {
//        list.clear();
//
//        DogsModel dogs[] = new DogsModel[puppyList.size()];
//        for (int i = 0; i < puppyList.size(); i++) {
//            DogsModel dog = (DogsModel) puppyList.elementAt(i);
//            DogsModel element = new DogsModel();
//            element.setImage(dog.getImage());
//            element.setDogName(dog.getDogName());
//            dogs[i] = element;
//        }
//
//        DogsAdapter adapter = new DogsAdapter(getActivity(),
//                R.layout.ctrl_listview_item_row, dogs);
//        gridView.setAdapter(adapter);
//
//    }

    public class RecycleOntouchListner implements RecyclerView.OnItemTouchListener {

        private GestureDetector mGestureDetector;
        private ClickListner mClickListner;

        public RecycleOntouchListner(Context mContext, ClickListner clickListner) {

            this.mClickListner = clickListner;
            mGestureDetector = new GestureDetector(mContext, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {

                    return true;
                }
            });
        }


        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && mClickListner != null && mGestureDetector.onTouchEvent(e)) {
                mClickListner.OnClick(child, rv.getChildAdapterPosition(child));
                return false;

            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    public static interface ClickListner {
        void OnClick(View view, int position);
    }

}