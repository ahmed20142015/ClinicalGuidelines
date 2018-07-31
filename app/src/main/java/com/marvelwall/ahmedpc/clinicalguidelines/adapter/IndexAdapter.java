package com.marvelwall.ahmedpc.clinicalguidelines.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.marvelwall.ahmedpc.clinicalguidelines.R;
import com.marvelwall.ahmedpc.clinicalguidelines.model.Index;

import java.util.List;
import java.util.Locale;

public class IndexAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<Index> indexList;

    public IndexAdapter(Context context, List<Index> indexList) {
        this.context = context;
        this.indexList = indexList;
    }

    @Override
    public int getGroupCount() {
        return indexList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 2;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.intex_item, parent, false);
        }

        TextView indexName = v.findViewById(R.id.index_name);
        TextView indexPage = v.findViewById(R.id.index_page);

        Index index = indexList.get(groupPosition);

        indexName.setText(index.getName());
        indexPage.setText(index.getPageNumb());

        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
