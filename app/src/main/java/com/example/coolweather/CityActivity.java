package com.example.coolweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CityActivity extends AppCompatActivity {
    private String[] city01 = {"北京市"};
    private String[] city02 = {"上海市"};
    private String[] city03 = {"天津市"};
    private String[] city04 = {"重庆市"};
    private String[] city17 = {"杭州","温州","嘉兴","宁波","绍兴","台州","湖州","丽水","金华","衢州","舟山"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String province = getIntent().getStringExtra("province");
        String[] data=null;
        if ("北京".equals(province)){
            data=city01;
        }else if ("上海".equals(province)){
            data=city02;
        }else if ("天津".equals(province)){
            data=city03;
        }else if ("重庆".equals(province)){
            data=city04;
        }else {
            data=city17;
        }

        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                CityActivity.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

    }
}
