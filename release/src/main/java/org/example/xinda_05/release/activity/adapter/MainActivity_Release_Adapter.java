package org.example.xinda_05.release.activity.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.example.xinda_05.release.R;
import org.example.xinda_05.release.activity.entity.Release_pager_entity;

import java.util.ArrayList;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class MainActivity_Release_Adapter extends BaseAdapter{
    private   Context context;
    private ArrayList<Release_pager_entity> list;
    private int page;

    public MainActivity_Release_Adapter(Context context,ArrayList<Release_pager_entity>list,int page) {
        this.context = context;
        this.list=list;
        this.page=page;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.release_gridview_page_layout, null);
            holder.image = (ImageView) view.findViewById(R.id.Release_content_GridView_Page_image);
            holder.text = (TextView) view.findViewById(R.id.Release_content_GridView_Page_text);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        switch (page){
            case 0:{
                Release_pager_entity info = list.get(i);
                Picasso.with(context).load(info.getParent_cate_img_url()).into(holder.image);
                holder.text.setText(info.getParent_cate_name());
            }break;
            case 1:{
                Log.e("TAG","list的总大小是:"+list.size()+"这是grid中的："+i);
                Release_pager_entity info = list.get(i+7);
                Picasso.with(context).load(info.getParent_cate_img_url()).into(holder.image);
                holder.text.setText(info.getParent_cate_name());
            }break;
        }
        return view;
    }

    private class ViewHolder {
        private TextView text;
        private ImageView image;
    }
}
