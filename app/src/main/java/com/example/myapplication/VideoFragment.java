package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VideoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Toolbar toolbar;


    ArrayList<SectionDataModel> allSampleData;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public VideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoFragment newInstance(String param1, String param2) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view2 = inflater.inflate(R.layout.fragment_video,container, false);
        //toolbar = view2.findViewById(R.id.toolbar);
        Context context = getActivity().getApplicationContext();
        allSampleData = new ArrayList<SectionDataModel>();
//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//            toolbar.setTitle("G PlayStore");
//
//        }
        createDummyData();
//        SectionDataModel dm = new SectionDataModel();
//        dm.setHeaderTitle("Sports");
//        ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
//        singleItem.add(new SingleItemModel("Item-1", "<iframe src=\"https://www.youtube.com/embed/wAgZVLk6J4M\" allowfullscreen></iframe>"));
//        dm.setAllItemsInSection(singleItem);
//        allSampleData.add(dm);
//        dm.setHeaderTitle("Sports");
//        ArrayList<SingleItemModel> singleItem1 = new ArrayList<SingleItemModel>();
//        singleItem.add(new SingleItemModel("Item-1", "<iframe src=\"https://www.youtube.com/embed/wAgZVLk6J4M\" allowfullscreen></iframe>"));
//        dm.setAllItemsInSection(singleItem1);
//        allSampleData.add(dm);
//        dm.setHeaderTitle("Sports");
//        ArrayList<SingleItemModel> singleItem2 = new ArrayList<SingleItemModel>();
//        singleItem.add(new SingleItemModel("Item-1", "<iframe src=\"https://www.youtube.com/embed/wAgZVLk6J4M\" allowfullscreen></iframe>"));
//        dm.setAllItemsInSection(singleItem2);
//        allSampleData.add(dm);
//        dm.setHeaderTitle("Sports");
//        ArrayList<SingleItemModel> singleItem3 = new ArrayList<SingleItemModel>();
//        singleItem.add(new SingleItemModel("Item-1", "<iframe src=\"https://www.youtube.com/embed/wAgZVLk6J4M\" allowfullscreen></iframe>"));
//        dm.setAllItemsInSection(singleItem3);
//        allSampleData.add(dm);
        RecyclerView my_recycler_view = view2.findViewById(R.id.nest_rec_view);
        my_recycler_view.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(context, allSampleData);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);
        return view2;
    }

    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {
            SectionDataModel dm = new SectionDataModel();
            dm.setHeaderTitle("Section " + i);
            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 2; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "<iframe src=\"https://www.youtube.com/embed/wAgZVLk6J4M\" allowfullscreen></iframe>"));
            }
            dm.setAllItemsInSection(singleItem);
            allSampleData.add(dm);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
