package com.miui8.widget;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.miui8.widget.BaseQuickAdapter;
import com.miui8.widget.BaseViewHolder;

import java.util.List;

/**
 * Created by XiaoJianjun on 2017/6/17.
 * adapter
 */
public class ItemAdapter extends BaseQuickAdapter<Item, BaseViewHolder> {

    public ItemAdapter(@LayoutRes int layoutResId, @Nullable List<Item> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Item item) {
       // holder.setImageResource(R.id.img_item, item.img);
        holder.setText(R.id.text_item, item.text);
    }
}
