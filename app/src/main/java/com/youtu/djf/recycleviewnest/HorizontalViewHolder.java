package com.youtu.djf.recycleviewnest;

/**
 * Created by djf on 2017/8/21.
 */

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * 嵌套的水平RecyclerView
 * 当条目被回收时，下次加载会重新回到之前的x轴
 */
public class HorizontalViewHolder extends BaseHolder<RouteThemeBean> {
    private static final String TAG = "HorizontalViewHolder";
    private RecyclerView hor_recyclerview;
    private TextView title;
    private List<RouteBean> dataTotal, dataNow;

    private Button up, down;

    private Context context;
    private VerticalAdapter adapter;

    WeakReference<AppCompatActivity> mDiscover;

    public HorizontalViewHolder(WeakReference<AppCompatActivity> mDiscover, Context context, int viewId, ViewGroup parent, int viewType) {
        super(viewId, parent, viewType);
        this.mDiscover = mDiscover;
        this.context = context;
        hor_recyclerview = itemView.findViewById(R.id.rv);
        title = itemView.findViewById(R.id.title);
        up = itemView.findViewById(R.id.btn_up);
        down = itemView.findViewById(R.id.btn_down);
    }

    @Override
    public void refreshData(RouteThemeBean data, int position) {
        this.dataTotal = data.getPageContent();
        title.setText(data.getPageHeader());
        //设置水平RecyclerView水平显示
        hor_recyclerview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        //设置背景
        hor_recyclerview.setBackgroundResource(R.color.colorAccent);
        size = this.dataTotal.size();
        if (size > 0) {
            pageIndex = 0;
            pageSize = size / 3 + ((size % 3 == 0) ? 0 : 1);
            for (int i = 0; i < pageSize; i++) {
                List<RouteBean> page = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int in = j + i * 3;
                    if (in < size) {
                        page.add(this.dataTotal.get(in));
                        Log.d(TAG, "refreshData: " + i + "   " + j);
                    }
                }
                dd.put(i, page);
            }
            dataNow = dd.get(pageIndex);
            adapter = new VerticalAdapter(mDiscover, context, dataNow);
            adapter.setListener(new VerticalAdapter.ChildRecycleViewClickListener() {
                @Override
                public void onChildRecycleViewClickListener(String branchId, int index) {
                    Log.d(TAG, "HorizontalViewHolder onChildRecycleViewClickListener: "
                            + branchId + "  " + index);
                    if (listener!=null){
                        listener.onHorizontalViewHolderClickListener(branchId,dataNow.get(index));
                    }
                }
            });
            hor_recyclerview.setAdapter(adapter);
        }

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pageIndex > 0) {
                    pageIndex--;
                    dataNow = dd.get(pageIndex);
                    adapter.setData(dataNow);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "已经是第一页", Toast.LENGTH_SHORT).show();
                }

            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pageIndex < pageSize - 1) {
                    pageIndex++;
                    dataNow = dd.get(pageIndex);
                    adapter.setData(dataNow);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "已经是最后一页", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    Hashtable<Integer, List<RouteBean>> dd = new Hashtable<>();
    int size, pageIndex, pageSize;

    private HorizontalViewHolderClickListener listener;

    public void setListener(HorizontalViewHolderClickListener listener) {
        this.listener = listener;
    }

    public interface HorizontalViewHolderClickListener {
        void onHorizontalViewHolderClickListener(String branchId, RouteBean bean);
    }

}
