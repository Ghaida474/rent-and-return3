package com.example.rentmyspot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class RentActivity extends  SigninActivity  {
    ListView list;
    SeatingListAdapter seatArrayAdapter;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

            list = findViewById(R.id.seatrentlist);
            username = (String) getIntent().getSerializableExtra("username");
            DBHelper db = new DBHelper(this);
            ShowSeatsOnListView(db);

    }


    private void ShowSeatsOnListView(DBHelper dataBaseHelper) {
        seatArrayAdapter = new SeatingListAdapter(RentActivity.this, dataBaseHelper.SeatingrentList(username));
        list.setAdapter(seatArrayAdapter);
    }
}

