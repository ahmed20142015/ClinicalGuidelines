package com.marvelwall.ahmedpc.clinicalguidelines.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.marvelwall.ahmedpc.clinicalguidelines.model.Index;

import com.marvelwall.ahmedpc.clinicalguidelines.CustExpListview;
import com.marvelwall.ahmedpc.clinicalguidelines.R;
import com.marvelwall.ahmedpc.clinicalguidelines.model.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Category> originalList;
    private List<Category> categoriesList;
    Category cc;
    public CategoryAdapter(Context context, List<Category> categoriesList) {
        this.context = context;
       // this.categoriesList = categoriesList ;


        this.categoriesList = new ArrayList<Category>();
        this.categoriesList.addAll(categoriesList);
        this.originalList = new ArrayList<Category>();
        this.originalList.addAll(categoriesList);
        Log.w("aaa",categoriesList.size()+"");
    }

    @Override
    public int getGroupCount() {
        return categoriesList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return categoriesList.get(groupPosition).getIndexs().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null ;// this.categoriesList.get(this.categoriesList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
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
            v = inflater.inflate(R.layout.category_item, parent, false);
        }



         cc = categoriesList.get(groupPosition);

        String xx = cc.getName();


        TextView tv = (TextView) v.findViewById(R.id.category_name);
        ImageView iv = v.findViewById(R.id.category_icon);

        tv.setText(cc.getName());
        iv.setImageResource(cc.getIcon());

        tv.setText(xx);


        return v;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent){
    View v = convertView;

        if (v == null) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.intex_item, parent, false);
    }

    TextView indexName = v.findViewById(R.id.index_name);
    TextView indexPage = v.findViewById(R.id.index_page);


    Index index = categoriesList.get(groupPosition).getIndexs().get(childPosition);

        indexName.setText(index.getName());
        indexPage.setText(index.getPageNumb());

        return v;
}

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query)
    {
       if(query != null){

           query = query.toLowerCase();
           Log.v("MyListAdapter", String.valueOf(categoriesList.size()));
           categoriesList.clear();

           if(query.isEmpty())
           {
               categoriesList.addAll(originalList);
               Log.w("list",originalList.size()+"");
           } else {
               for(Category continent: originalList)
               {
                   ArrayList<Index> countryList = (ArrayList<Index>) continent.getIndexs();
                   ArrayList<Index> newList = new ArrayList<Index>();
                   for(Index country: countryList)
                   {
                       if(country.getName().toLowerCase().contains(query)||continent.getName().toLowerCase().contains(query))
                       {

                           Log.w("newList","add");
                           newList.add(country);
                           notifyDataSetInvalidated();
                       }
                   }
                   if(newList.size() > 0)
                   {
                       Category nContinent = new Category();
                       nContinent.setName(continent.getName());

                       nContinent.setIndexs(newList);
                       Log.w("newList","added");

                       categoriesList.add(nContinent);
                       notifyDataSetInvalidated();
                   }
               }
           }

           Log.v("MyListAdapter", String.valueOf(categoriesList.size()));
           notifyDataSetChanged();



       }
    }




}
