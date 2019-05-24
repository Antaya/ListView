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

        List<Map<String, String>> date = prepareContent();

        SimpleAdapter listContentAdapter = createAdapter(date);

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
        List<Map<String, String>> date = new ArrayList<>();
        Map<String, String> contentMap = new HashMap<>();
        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        for (int i = 0; i < arrayContent.length; i++) {
            String lengthArrayContent = Integer.toString(arrayContent[i].length());
            contentMap.put("title", arrayContent[i]);
            contentMap.put("subtitle", lengthArrayContent);
        }
        date.add(contentMap);
        return date;
    }
}