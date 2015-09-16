package com.guo.duoduo.anyshareofandroid.ui.send.view;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.guo.duoduo.anyshareofandroid.R;
import com.guo.duoduo.anyshareofandroid.entity.IInfo;
import com.guo.duoduo.anyshareofandroid.sdk.cache.Cache;


/**
 * Created by 郭攀峰 on 2015/9/16.
 */
public class ImageSelectAdapter extends FileSelectAdapter
{

    private static final String tag = ImageSelectAdapter.class.getSimpleName();

    private List<IInfo> list;
    private Context context;

    public ImageSelectAdapter(Context context, List<IInfo> list)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int i)
    {
        return list.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup)
    {
        View view = convertView;
        GetView getView;
        if (view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.view_pic_item, null);
            getView = new GetView();
            getView.imageView = (ImageView) view.findViewById(R.id.imageview);
            getView.pic_choice = (ImageView) view.findViewById(R.id.pic_choice);
            view.setTag(getView);
        }
        else
        {
            getView = (GetView) view.getTag();
        }

        Glide.with(context).load(list.get(position).getFilePath())
                .into(getView.imageView);

        String filePath = list.get(position).getFilePath();
        if (Cache.selectedList.contains(filePath))
            getView.pic_choice.setVisibility(View.VISIBLE);
        else
            getView.pic_choice.setVisibility(View.INVISIBLE);

        return view;
    }

    private static class GetView
    {
        ImageView imageView;
        ImageView pic_choice;
    }
}
