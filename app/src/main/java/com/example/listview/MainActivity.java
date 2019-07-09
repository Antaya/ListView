package com.example.listview;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    private List<Map<String, String>> data = new ArrayList<>();
    private ListView list;
    String[] savedText;
    SimpleAdapter listContentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = (ListView) findViewById(R.id.list);

        listContentAdapter = createAdapter(data);

        list.setAdapter(listContentAdapter);
        saveText();
        data = loadText();


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                data.remove(position);
                listContentAdapter.notifyDataSetChanged();
            }

        });

        final SwipeRefreshLayout swipeLayout = findViewById(R.id.swipeRefresh);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            // Будет вызван, когда пользователь потянет список вниз
            @Override
            public void onRefresh() {
                loadText();
                swipeLayout.setRefreshing(false);
                listContentAdapter.notifyDataSetChanged();

            }
        });


    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, getString(R.string.large_text));
        ed.commit();

    }

    public List<Map<String, String>> loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        Map<String, String> contentMap1 = new HashMap<>();
        Map<String, String> contentMap2 = new HashMap<>();
        Map<String, String> contentMap3 = new HashMap<>();
        Map<String, String> contentMap4 = new HashMap<>();
        Map<String, String> contentMap5 = new HashMap<>();
        Map<String, String> contentMap6 = new HashMap<>();
        Map<String, String> contentMap7 = new HashMap<>();
        Map<String, String> contentMap8 = new HashMap<>();
        Map<String, String> contentMap9 = new HashMap<>();
        Map<String, String> contentMap10 = new HashMap<>();
        Map<String, String> contentMap11 = new HashMap<>();
        Map<String, String> contentMap12 = new HashMap<>();
        Map<String, String> contentMap13 = new HashMap<>();
        Map<String, String> contentMap14 = new HashMap<>();
        Map<String, String> contentMap15 = new HashMap<>();
        Map<String, String> contentMap16 = new HashMap<>();
        Map<String, String> contentMap17 = new HashMap<>();
        Map<String, String> contentMap18 = new HashMap<>();
        String[] savedText = sPref.getString(SAVED_TEXT, "").split("\n\n");
        for (int i = 0; i < savedText.length; i++) {
            String part1 = savedText[0];
            String part2 = savedText[1];
            String part3 = savedText[2];
            String part4 = savedText[3];
            String part5 = savedText[4];
            String part6 = savedText[5];
            String part7 = savedText[6];
            String part8 = savedText[7];
            String part9 = savedText[8];
            String part10 = savedText[9];
            String part11 = savedText[10];
            String part12 = savedText[11];
            String part13 = savedText[12];
            String part14 = savedText[13];
            String part15 = savedText[14];
            String part16 = savedText[15];
            String part17 = savedText[16];
            String part18 = savedText[17];


            contentMap1.put("title", part1);
            contentMap1.put("subtitle", Integer.toString(part1.length()));
            contentMap2.put("title", part2);
            contentMap2.put("subtitle", Integer.toString(part2.length()));
            contentMap3.put("title", part3);
            contentMap3.put("subtitle", Integer.toString(part3.length()));
            contentMap4.put("title", part4);
            contentMap4.put("subtitle", Integer.toString(part4.length()));
            contentMap5.put("title", part5);
            contentMap5.put("subtitle", Integer.toString(part5.length()));
            contentMap6.put("title", part6);
            contentMap6.put("subtitle", Integer.toString(part6.length()));
            contentMap7.put("title", part7);
            contentMap7.put("subtitle", Integer.toString(part7.length()));
            contentMap8.put("title", part8);
            contentMap8.put("subtitle", Integer.toString(part8.length()));
            contentMap9.put("title", part9);
            contentMap9.put("subtitle", Integer.toString(part9.length()));
            contentMap10.put("title", part10);
            contentMap10.put("subtitle", Integer.toString(part10.length()));
            contentMap11.put("title", part11);
            contentMap11.put("subtitle", Integer.toString(part11.length()));
            contentMap12.put("title", part12);
            contentMap12.put("subtitle", Integer.toString(part12.length()));
            contentMap13.put("title", part13);
            contentMap13.put("subtitle", Integer.toString(part13.length()));
            contentMap14.put("title", part14);
            contentMap14.put("subtitle", Integer.toString(part14.length()));
            contentMap15.put("title", part15);
            contentMap15.put("subtitle", Integer.toString(part15.length()));
            contentMap16.put("title", part16);
            contentMap16.put("subtitle", Integer.toString(part16.length()));
            contentMap17.put("title", part17);
            contentMap17.put("subtitle", Integer.toString(part17.length()));
            contentMap18.put("title", part18);
            contentMap18.put("subtitle", Integer.toString(part18.length()));
        }

        data.add(contentMap1);
        data.add(contentMap2);
        data.add(contentMap3);
        data.add(contentMap4);
        data.add(contentMap5);
        data.add(contentMap6);
        data.add(contentMap7);
        data.add(contentMap8);
        data.add(contentMap9);
        data.add(contentMap10);
        data.add(contentMap11);
        data.add(contentMap12);
        data.add(contentMap13);
        data.add(contentMap14);
        data.add(contentMap15);
        data.add(contentMap16);
        data.add(contentMap17);
        data.add(contentMap18);


        return data;
    }

    @NonNull
    private SimpleAdapter createAdapter(List<Map<String, String>> data) {
        SimpleAdapter listContentAdapter = new SimpleAdapter(this, data, R.layout.simple_list_item,
                new String[]{"title", "subtitle"}, new int[]{R.id.item_text, R.id.item_text_length});
        return listContentAdapter;
    }


}