package com.bidyut.tech.example.listexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(new ListExampleAdapter(this));
    }

    private static class ListExampleAdapter extends BaseAdapter {
        private static final String[] sList = new String[] {
                "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen"
        };

        private final LayoutInflater mInflater;

        public ListExampleAdapter(Context context) {
            super();
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return sList.length;
        }

        @Override
        public Object getItem(int position) {
            return sList[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View view;
            final ListRowHolder vh;
            if (convertView == null) {
                view = mInflater.inflate(R.layout.list_row, parent, false);
                vh = new ListRowHolder(view);
                view.setTag(vh);
            } else {
                view = convertView;
                vh = (ListRowHolder) view.getTag();
            }

            vh.label.setText(sList[position]);
            return view;
        }
    }

    private static class ListRowHolder {
        public final TextView label;

        public ListRowHolder(View row) {
            this.label = (TextView) row.findViewById(R.id.label);
        }
    }
}
