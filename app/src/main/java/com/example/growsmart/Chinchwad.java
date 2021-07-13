package com.example.growsmart;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Chinchwad extends AppCompatActivity {
    ImageView btMenu;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinchwad);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("hh:mm:ss");
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        TextView textView = findViewById(R.id.CityDisplay);
        textView.setText("Pune, Maharashtra " +currentDate+ " ");

        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.btMenu = (ImageView) findViewById(R.id.bt_menu);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(new MainAdapter(this, MainActivity.arrayList));
        this.btMenu.setOnClickListener(new View.OnClickListener() {
            /* class com.android_coding.navigationdrawer.Chinchwad.AnonymousClass1 */

            public void onClick(View v) {
                Chinchwad.this.drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        MainActivity.closeDrawer(this.drawerLayout);
    }
}
