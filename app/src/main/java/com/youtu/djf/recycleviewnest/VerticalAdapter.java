package com.youtu.djf.recycleviewnest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by djf on 2017/8/21.
 */

public class VerticalAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    public void setData(List<RouteBean> data) {
        this.data = data;
    }

    private List<RouteBean> data;
    private Context context;
    protected WeakReference<AppCompatActivity> mDiscover;

    public VerticalAdapter(WeakReference<AppCompatActivity> mDiscover, Context context, List<RouteBean> data) {
        this.data = data;
        this.context = context;
        this.mDiscover = mDiscover;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewHolder holder = new ItemViewHolder(context, R.layout.item_child, parent, viewType);
        holder.setListener(new ItemViewHolder.ChildItemClickListener() {
            @Override
            public void onChildItemClickListener(String branchId, int index) {
                Log.d(TAG, "VerticalAdapter onChildItemClickListener: " + branchId + "  " + index);
                if (listener != null) {
                    listener.onChildRecycleViewClickListener(branchId, index);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.refreshData(data.get(position), position);
        Log.d(TAG, "VerticalAdapter onBindViewHolder: " + position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setListener(ChildRecycleViewClickListener listener) {
        this.listener = listener;
    }

    private ChildRecycleViewClickListener listener;

    public interface ChildRecycleViewClickListener {
        void onChildRecycleViewClickListener(String branchId, int index);
    }
}
