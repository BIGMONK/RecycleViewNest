package com.youtu.djf.recycleviewnest;

/**
 * Created by djf on 2017/8/21.
 */

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 通用子条目hodler
 */
public class ItemViewHolder extends BaseHolder<RouteBean> implements View.OnClickListener {
    private static final String TAG = "ItemViewHolder";
    private TextView tv;
    private Context context;
    private  RouteBean bb;
    private int childPosition;
    public ItemViewHolder(Context context,int viewId, ViewGroup parent, int viewType) {
        super(viewId, parent, viewType);
        this.context=context;
        tv = (TextView) itemView.findViewById(R.id.name);
        itemView.setOnClickListener(this);

    }
    @Override
    public void refreshData(RouteBean data, final int position) {
        bb=data;
        this.childPosition=position;
        tv.setText(data.getLineTitle());

    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "ItemViewHolder onClick: "+bb.getBranchId());
//        Toast.makeText(context, "点击"+bb.getBranchId(), Toast.LENGTH_SHORT).show();
        if (listener!=null){
            listener.onChildItemClickListener(bb.getBranchId(),childPosition);
        }
    }


    public void setListener(ChildItemClickListener listener) {
        this.listener = listener;
    }

    private ChildItemClickListener listener;
    public interface  ChildItemClickListener{
       void onChildItemClickListener(String branchId, int index);
    };
}