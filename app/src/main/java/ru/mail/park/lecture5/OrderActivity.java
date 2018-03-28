package ru.mail.park.lecture5;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class OrderActivity extends AppCompatActivity {
    private OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle(R.string.order_title);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        adapter = new OrderAdapter();
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this, getColumnCount());
        recyclerView.setLayoutManager(layoutManager);
    }

    public int getColumnCount() {
        Resources res = getResources();
        int screenWidth = res.getDisplayMetrics().widthPixels;
        int padding = res.getDimensionPixelSize(R.dimen.padding);
        int minColumnWidth = res.getDimensionPixelSize(R.dimen.min_image_width);

        return Math.max((screenWidth - 2*padding) / minColumnWidth, 1);
    }
}
