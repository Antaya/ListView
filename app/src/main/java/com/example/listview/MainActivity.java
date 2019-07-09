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
   private ArrayList<Integer> savedPosition = new ArrayList<>();

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
                savedPosition.add(position);
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList("SavedPosition", savedPosition);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedPosition = savedInstanceState.getIntegerArrayList("SavedPosition");
        for (int i = 0; i < savedPosition.size(); i++){
            data.remove(savedPosition.get(i).intValue());
            listContentAdapter.notifyDataSetChanged();
        }
    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, getString(R.string.large_text));
        ed.commit();

    }

    public List<Map<String, String>> loadText() {
        sPref = getPreferences(MODE_PRIVATE);


        String[] savedText = sPref.getString(SAVED_TEXT, "").split("\n\n");
        for (int i = 0; i < savedText.length; i++) {
            String part = savedText[i];
            Map<String, String> contentMap = new HashMap<>();
            contentMap.put("title", part);
            contentMap.put("subtitle", Integer.toString(part.length()));
            data.add(contentMap);
        }


        return data;
    }

    @NonNull
    private SimpleAdapter createAdapter(List<Map<String, String>> data) {
        SimpleAdapter listContentAdapter = new SimpleAdapter(this, data, R.layout.simple_list_item,
                new String[]{"title", "subtitle"}, new int[]{R.id.item_text, R.id.item_text_length});
        return listContentAdapter;
    }


}