package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String url = "https://catfact.ninja/facts?limit=4&max_length=150";
    String fact;
    String[] facts;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        //API
        facts = new String[4];
        RequestQueue ExampleRequestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        ExampleRequestQueue.add(ExampleStringRequest);
        //API
    }
    //API
    StringRequest ExampleStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            //Toast.makeText(context, "Success", Toast.LENGTH_LONG).show();
            try {
                JSONObject json = new JSONObject(response);
                JSONArray jarray = json.getJSONArray("data");
                JSONObject object;
                for(int i = 0;i < 4;i++) {
                    object = jarray.getJSONObject(i);
                    fact = object.getString("fact");
                    System.out.println("fact : " + fact);
                    facts[i] = fact;
                }
            } catch (JSONException e) {
                //Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
        }
    });
    //API

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1 = inflater.inflate(R.layout.fragment_home, container, false);
        final Context context = getActivity().getApplicationContext();
        String[] names;
        //System.out.println("facts size : " + facts.length);
        names = facts;
        System.out.println("facts size : " + names[0]);
        int[] photos = {R.drawable.img_266351, R.drawable.img_266351, R.drawable.img_266351, R.drawable.img_266351};
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(context, names, photos);
        RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.view_recycle1);
        RecyclerView.LayoutManager mlm = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mlm);
        recyclerView.setAdapter(recyclerAdapter);
        return view1;
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
