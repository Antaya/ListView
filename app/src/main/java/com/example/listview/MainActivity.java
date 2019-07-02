package com.example.listview;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ListView list = findViewById(R.id.list);

        List<Map<String, String>> data = prepareContent();

        SimpleAdapter listContentAdapter = createAdapter(data);

        list.setAdapter(listContentAdapter);

    }

    @NonNull
    private SimpleAdapter createAdapter(List<Map<String, String>> data) {
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.simple_list_item,
                new String[]{"title", "subtitle"}, new int[]{R.id.item_text, R.id.item_text_length});
        return simpleAdapter;
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> data = new ArrayList<>();
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


        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        for (int i = 0; i < arrayContent.length; i++) {
            String part1 = arrayContent[0];
            String part2 = arrayContent[1];
            String part3 = arrayContent[2];
            String part4 = arrayContent[3];
            String part5 = arrayContent[4];
            String part6 = arrayContent[5];
            String part7 = arrayContent[6];
            String part8 = arrayContent[7];
            String part9 = arrayContent[8];
            String part10 = arrayContent[9];
            String part11 = arrayContent[10];
            String part12 = arrayContent[11];
            String part13 = arrayContent[12];
            String part14 = arrayContent[13];
            String part15 = arrayContent[14];
            String part16 = arrayContent[15];
            String part17 = arrayContent[16];
            String part18 = arrayContent[17];


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
}