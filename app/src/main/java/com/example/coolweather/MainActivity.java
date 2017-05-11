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

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> source = Arrays.asList(new String[]{});
    private List<String> province = Arrays.asList(new String[]{"北京","浙江","","","","","","","","",""});
    private List<String> city01 = Arrays.asList(new String[]{"北京市"});
    private List<String> city02 = Arrays.asList(new String[]{"上海市"});
    private List<String> city03 = Arrays.asList(new String[]{"天津市"});
    private List<String> city04 = Arrays.asList(new String[]{"重庆市"});
    private List<String> city17 = Arrays.asList(new String[]{"杭州","温州","嘉兴","宁波","绍兴","台州","湖州","丽水","金华","衢州","舟山"});
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,android.R.layout.simple_list_item_1,province);
        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,province.get(position),Toast.LENGTH_SHORT).show();
                final Button button = (Button) findViewById(R.id.backbutton);

                if ("北京".equals(province.get(position))){
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            MainActivity.this,android.R.layout.simple_list_item_1,city01);
                    listView.setAdapter(adapter);
                    button.setVisibility(View.VISIBLE);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                                    MainActivity.this,android.R.layout.simple_list_item_1,province);
                            listView.setAdapter(adapter);
                            button.setVisibility(View.GONE);
                        }
                    });
                }
                else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            MainActivity.this,android.R.layout.simple_list_item_1,city17);
                    listView.setAdapter(adapter);
                    button.setVisibility(View.VISIBLE);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                                    MainActivity.this,android.R.layout.simple_list_item_1,province);
                            listView.setAdapter(adapter);
                            button.setVisibility(View.GONE);
                        }
                    });
                }

//                Intent intent = new Intent(MainActivity.this,CityActivity.class);
//                intent.putExtra("province",data[position]);
//                startActivity(intent);
            }
        });
    }
}
