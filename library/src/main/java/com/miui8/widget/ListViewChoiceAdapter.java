package com.miui8.widget;

import java.util.List;
import java.util.Arrays;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ListViewChoiceAdapter extends BaseAdapter{
	Context mContext;
	LayoutInflater lInflater;
	List<String> data;
	
	ListViewChoiceAdapter(Context context, List<String> data) {
		mContext = context;
		this.data = data;
		lInflater = (LayoutInflater) mContext
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	ListViewChoiceAdapter(Context context, String[] values) {
		mContext = context;
		this.data =  Arrays.asList(values);
		lInflater = (LayoutInflater) mContext
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			view = lInflater.inflate(R.layout.single_choice_items, parent, false);
		}
		((TextView) view.findViewById(R.id.single_choice_item_checkbox)).setText(data.get(position));

		return view;
	}
}
