package com.example.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> dataList = new ArrayList<>();
    private List<String> province = Arrays.asList(new String[]{"北京","浙江","","","","","","","","",""});
    private List<String> city01 = Arrays.asList(new String[]{"北京市"});
    private List<String> city17 = Arrays.asList(new String[]{"杭州","温州","嘉兴","宁波","绍兴","台州","湖州","丽水","金华","衢州","舟山"});
    private List<String> county128 = Arrays.asList(new String[]{"嘉兴","嘉善","海宁","桐乡","平湖","海盐"});
    private int level=1;
    private  Button button = null;
    private  ListView listView = null;
    private  ArrayAdapter adapter;
    //选中的省或者直辖市的序号（0,1,2...)
    private int selectedProvinceIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = (Button) findViewById(R.id.backbutton);
        listView = (ListView) findViewById(R.id.list_view);
        this.dataList.addAll(this.province);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, this.dataList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (level == 1) {
                    selectedProvinceIndex = position;
                    showCities(selectedProvinceIndex);
                } else if (level == 2) {
                    showCounties();
                } else {
                    //TODO 选定区县，去显示天气界面
                }

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level==3){
                    showCities(MainActivity.this.selectedProvinceIndex);
                }else if(level==2){
                    level=1;
                    button.setVisibility(View.GONE);
                    MainActivity.this.dataList.clear();
                    MainActivity.this.dataList.addAll(province);
                    MainActivity.this.adapter.notifyDataSetChanged();
                }



            }
        });

    }
    private void showCities(int position) {
        level=2;
        this.button.setVisibility(View.VISIBLE);
        this.dataList.clear();
        if("北京".equals(this.province.get(position))){
            this.dataList.addAll(city01);
        }else{
            this.dataList.addAll(city17);
        }
        this.adapter.notifyDataSetChanged();
    }

    private void showCounties() {
        level=3;
        this.dataList.clear();
        this.dataList.addAll(county128);
        adapter.notifyDataSetChanged();
    }
}
