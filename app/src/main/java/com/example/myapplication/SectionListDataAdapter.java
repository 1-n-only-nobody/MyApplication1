package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemsList;
    public Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        SingleItemModel singleItem = itemsList.get(i);

        //holder.tvTitle.setText(singleItem.getName());
        holder.itempage.loadData( singleItem.getUrl(), "text/html" , "utf-8" );

    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        //protected TextView tvTitle;

        protected WebView itempage;


        public SingleItemRowHolder(View view) {
            super(view);

            //this.tvTitle = view.findViewById(R.id.tvTitle);
            this.itempage = view.findViewById(R.id.webView1);
            itempage.setWebViewClient(new WebViewClient());
            itempage.getSettings().setJavaScriptEnabled(true);
            itempage.getSettings().setAllowFileAccess(true);
            itempage.getSettings().setAllowFileAccessFromFileURLs(true);
            itempage.getSettings().setAppCacheEnabled(true);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }

}