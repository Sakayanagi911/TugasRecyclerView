package com.example.tugas2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<String> dataList;
    private EditText editTextItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Pastikan nama layout sesuai

        recyclerView = findViewById(R.id.recyclerView);
        editTextItem = findViewById(R.id.editTextItem);
        Button buttonAdd = findViewById(R.id.buttonAdd);

        // Inisialisasi data dan adapter
        dataList = new ArrayList<>();
        adapter = new MyAdapter(dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Logika untuk menambah item
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editTextItem.getText().toString();
                if (!newItem.isEmpty()) {
                    adapter.addItem(newItem);
                    editTextItem.setText(""); // Kosongkan input
                }
            }
        });
    }
}
