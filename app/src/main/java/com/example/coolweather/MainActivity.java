package com.example.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private  String[] data =
            {"北京","上海","天津","重庆","香港",
                    "澳门","台湾","黑龙江","吉林","辽宁",
                    "内蒙古","河北","河南","山西","山东",
                    "江苏","浙江","福建","江西","安徽",
                    "湖北","湖南","广东","广西","海南",
                    "贵州","云南","四川","西藏","陕西","宁夏","甘肃","青海","新疆"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.province_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,data[position],Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,CityActivity.class);
                intent.putExtra("province",data[position]);
                startActivity(intent);

            }
        });
    }
}
