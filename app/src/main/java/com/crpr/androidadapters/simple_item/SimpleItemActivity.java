package com.crpr.androidadapters.simple_item;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.crpr.androidadapters.R;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;
import com.crpr.androidadapters.common.models.AdapterListProvider;
import com.crpr.androidadapters.common.models.AdapterModel;

public class SimpleItemActivity extends AppCompatActivity {

    private SimpleItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(0,0);

        setContentView(R.layout.activity_list);

        setupToolbar();
        setupAdapter();
    }

    private void setupToolbar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupAdapter() {
        adapter = new SimpleItemAdapter(this, new SimpleItemViewHolderManager(), AdapterListProvider.getContactModels(),
                new RecyclerItemTouchListener() {
                    @Override
                    public void onTouch(View view, int position) {
                        handleTouch(position);
                    }
                });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    private void handleTouch(int position) {
        AdapterModel model = adapter.getItemByPosition(position);

        if(model == null || model.isSeparator()){
            return;
        }

        String message = model.getContact() == null ?
                model.getDummy().toString() :
                model.getContact().toString();

        Toast.makeText(this, "INDEX: " + position + " - VALUE: " + message, Toast.LENGTH_LONG).show();
    }
}
