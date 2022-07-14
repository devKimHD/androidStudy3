package com.kh.project11_1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    Context context;
    int viewId;
    List<MovieDto> list;

    public GridAdapter(Context context, int viewId, List<MovieDto> list) {
        this.context = context;
        this.viewId = viewId;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.view_gridcell, null);
        }
        ImageView imageViewCell = convertView.findViewById(R.id.imageViewCell);
        TextView textViewCell = convertView.findViewById(R.id.textViewCell);
        imageViewCell.setImageResource(list.get(position).getImgId());
        textViewCell.setText(list.get(position).getTitle());
        return convertView;
    }
}
