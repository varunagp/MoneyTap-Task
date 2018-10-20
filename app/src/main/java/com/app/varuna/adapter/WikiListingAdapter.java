package com.app.varuna.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.varuna.R;
import com.app.varuna.model.Page;
import com.app.varuna.ui.WebViewActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WikiListingAdapter extends RecyclerView.Adapter<WikiListingAdapter.WikiViewHolder> {

    private List<Page> pageList;
    private int rowLayout;
    private Context context;


    public static class WikiViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView title;
        TextView description;
        ImageView imageView;


        public WikiViewHolder(View v) {
            super(v);
            linearLayout = (LinearLayout) v.findViewById(R.id.rootLyt);
            title = (TextView) v.findViewById(R.id.title);
            description = (TextView) v.findViewById(R.id.description);
            imageView = (ImageView) v.findViewById(R.id.thumbnail);
        }
    }

    public WikiListingAdapter(List<Page> movies, int rowLayout, Context context) {
        this.pageList = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public WikiListingAdapter.WikiViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new WikiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WikiViewHolder holder, final int position) {
        holder.title.setText(pageList.get(position).getTitle());
        if(pageList.get(position).getTerms() != null) {
            holder.description.setText(pageList.get(position).getTerms().getDescription().get(0));
        }

        if(pageList.get(position).getThumbnail() != null) {
            Picasso.with(context)
                    .load(pageList.get(position).getThumbnail().getSource())
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imageView);
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,WebViewActivity.class);
                intent.putExtra("URL",pageList.get(position).getFullurl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pageList.size();
    }
}
