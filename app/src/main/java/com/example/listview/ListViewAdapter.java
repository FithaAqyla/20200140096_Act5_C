package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private ArrayList<ClassName> arrayList;

    public ListViewAdapter(Context context){
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ClassName>();
        this.arrayList.addAll(Home.classNamaArrayList);
    }
    public class viewHolder{
        TextView name;
    }
    @Override
    public int getCount(){
        return Home.classNamaArrayList.size();
    }
    @Override
    public Object getItem(int i){
        return Home.classNamaArrayList.get(i);
    }
    @Override
    public long getItemId(int i){
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        final viewHolder holder;
        if (view == null){
            holder=new viewHolder();
            view = inflater.inflate(R.layout.activity_itemlistview, null);
            holder.name=view.findViewById(R.id.tvnama_item);
            view.setTag(holder);
        }
        else{
            holder = (viewHolder) view.getTag();
        }
        holder.name.setText(Home.classNamaArrayList.get(i).getNama());
        return view;
    }
}