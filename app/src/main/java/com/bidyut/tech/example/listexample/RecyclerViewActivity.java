package com.bidyut.tech.example.listexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        final RecyclerView rv = (RecyclerView) findViewById(R.id.recyler_list);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new ListExampleAdapter(this));
    }

    private static class ListExampleAdapter extends RecyclerView.Adapter<RowViewHolder> {
        private static final String[] sList = new String[]{
                "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen"
        };

        private final LayoutInflater mInflater;

        public ListExampleAdapter(Context context) {
            super();
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public RowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view = mInflater.inflate(R.layout.list_row, parent, false);
            view.setClickable(true);
            view.setBackgroundResource(android.R.drawable.list_selector_background);
            final RowViewHolder viewHolder = new RowViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), sList[viewHolder.getPosition()],
                            Toast.LENGTH_SHORT).show();
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RowViewHolder holder, int position) {
            holder.label.setText(sList[position]);
        }

        @Override
        public int getItemCount() {
            return sList.length;
        }
    }

    private static class RowViewHolder extends RecyclerView.ViewHolder {
        public final TextView label;

        public RowViewHolder(View row) {
            super(row);
            this.label = (TextView) row.findViewById(R.id.label);
        }
    }
}
