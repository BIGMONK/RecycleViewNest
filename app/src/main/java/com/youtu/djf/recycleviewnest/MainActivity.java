package com.youtu.djf.recycleviewnest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecycleViewAdapter.RecycleViewAdapterItemChildClickListener, View.OnClickListener {
    private static final String TAG = "MainActivity";
    private RecyclerView rv;
    private Button pre;
    private Button next;
    private RecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        try {
            InputStream open = getResources().getAssets().open("routes.txt");
            InputStreamReader bis = new InputStreamReader(open);
            BufferedReader bufferedReader = new BufferedReader(bis);
            String tem;
            StringBuilder sb = new StringBuilder();
            while ((tem = bufferedReader.readLine()) != null) {
                Log.e(TAG, "onCreate: " + tem);
                sb.append(tem);
            }

            List<RouteThemeBean> routeThemeBeanList = JsonTool
                    .getObjects(sb.toString(), new TypeToken<List<RouteThemeBean>>
                            () {
                    }.getType());

            initData(routeThemeBeanList);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<RouteThemeBean> routeThemeTotal, routeThemeNow;
    private int size,pageIndex,pageSize;
    private Hashtable<Integer,List<RouteThemeBean>> hashtable=new Hashtable<>();
    private void initData(List<RouteThemeBean> routeThemeBeanList) {
        rv.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        routeThemeTotal=routeThemeBeanList;
        size=routeThemeTotal.size();
        pageIndex=0;
        pageSize= size / 4 + ((size % 4 == 0) ? 0 : 1);

        for (int i = 0; i < pageSize; i++) {
            List<RouteThemeBean> page = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                int in = j + i * 4;
                if (in < size) {
                    page.add(routeThemeTotal.get(in));
                    Log.d(TAG, "refreshData: " + i + "   " + j+"  "+routeThemeTotal.get(in).getPageHeader());
                }
            }
            hashtable.put(i,page);
        }

        routeThemeNow= hashtable.get(pageIndex);
        Log.d(TAG, "initData: asdfasd "+routeThemeNow.size());
        adapter = new RecycleViewAdapter(MainActivity.this, this,routeThemeNow);

        adapter.setListener(this);

        rv.setAdapter(adapter);

    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        pre = (Button) findViewById(R.id.pre);
        pre.setOnClickListener(this);
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);
    }

    @Override
    public void onRecycleViewAdapterItemChildClickListener(String branchId, RouteBean bean) {
        Log.d(TAG, TAG + "  onRecycleViewAdapterItemChildClickListener: " + bean.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pre:
                if (pageIndex > 0) {
                    pageIndex--;
                    routeThemeNow = hashtable.get(pageIndex);
                    adapter.setDatas(routeThemeNow);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(this, "已经是第一页", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.next:
                if (pageIndex < pageSize-1) {
                    pageIndex++;
                    routeThemeNow = hashtable.get(pageIndex);
                    adapter.setDatas(routeThemeNow);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(this, "已经是最后一页", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
