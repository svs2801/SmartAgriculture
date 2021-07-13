package com.example.growsmart;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> arrayList = new ArrayList<>();
    MainAdapter adapter;
    ImageView btMenu;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;

    public static void closeDrawer(DrawerLayout drawerLayout2) {
        if (drawerLayout2.isDrawerOpen(GravityCompat.START)) {
            drawerLayout2.closeDrawer(GravityCompat.START);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.btMenu = (ImageView) findViewById(R.id.bt_menu);
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        arrayList.clear();
        arrayList.add("Home");
        arrayList.add("Chinchwad");
        arrayList.add("Morwadi");
        arrayList.add("Vallabhnagar");
        arrayList.add("Pimpri");
        arrayList.add("Nigdi");
        arrayList.add("Pradhikaran");
        arrayList.add("Quit");
        this.adapter = new MainAdapter(this, arrayList);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.adapter);
        this.btMenu.setOnClickListener(new View.OnClickListener() {
            /* class com.android_coding.navigationdrawer.MainActivity.AnonymousClass1 */

            public void onClick(View v) {
                MainActivity.this.drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        closeDrawer(this.drawerLayout);
    }
}

