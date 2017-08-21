package com.youtu.djf.recycleviewnest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by djf on 2017/8/21.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<HorizontalViewHolder> {
    private List<RouteThemeBean> datas;
    private static final String TAG = "RecycleViewAdapter";
    private Context context;
    protected WeakReference<AppCompatActivity> mDiscover;

    public void setDatas(List<RouteThemeBean> datas) {
        this.datas = datas;
    }

    public RecycleViewAdapter(AppCompatActivity mDiscover, Context context, List<RouteThemeBean> datas) {
        this.mDiscover = new WeakReference<AppCompatActivity>(mDiscover);
        this.datas = datas;
        this.context = context;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HorizontalViewHolder holder= new HorizontalViewHolder(mDiscover,context, R.layout.item, parent, viewType);
        holder.setListener(new HorizontalViewHolder.HorizontalViewHolderClickListener() {
            @Override
            public void onHorizontalViewHolderClickListener(String branchId, RouteBean bean) {
                if (listener!=null){
                    listener.onRecycleViewAdapterItemChildClickListener(branchId,bean);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
        RouteThemeBean routeThemeBean = datas.get(position);
        holder.refreshData(routeThemeBean, position);
        Log.d(TAG, "RecycleViewAdapter onBindViewHolder: " + position);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setListener(RecycleViewAdapterItemChildClickListener listener) {
        this.listener = listener;
    }

    private RecycleViewAdapterItemChildClickListener listener;
    public interface RecycleViewAdapterItemChildClickListener{
        void onRecycleViewAdapterItemChildClickListener(String branchId, RouteBean bean);
    };
}
