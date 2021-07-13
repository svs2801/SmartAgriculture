package com.example.growsmart;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    Activity activity;
    ArrayList<String> arrayList;

    public MainAdapter(Activity activity2, ArrayList<String> arrayList2) {
        this.activity = activity2;
        this.arrayList = arrayList2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_main, parent, false));
    }

    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textView.setText(this.arrayList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            /* class com.android_coding.navigationdrawer.MainAdapter.AnonymousClass1 */

            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position == 0) {
                    MainAdapter.this.activity.startActivity(new Intent(MainAdapter.this.activity, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                } else if (position == 1) {
                    MainAdapter.this.activity.startActivity(new Intent(MainAdapter.this.activity, Chinchwad.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                } else if (position == 2) {
                    MainAdapter.this.activity.startActivity(new Intent(MainAdapter.this.activity, Morwadi.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
                else if (position == 3) {
                    MainAdapter.this.activity.startActivity(new Intent(MainAdapter.this.activity, Vallabhnagar.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
                else if (position == 4) {
                    MainAdapter.this.activity.startActivity(new Intent(MainAdapter.this.activity, Pimpri.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
                else if (position == 5) {
                    MainAdapter.this.activity.startActivity(new Intent(MainAdapter.this.activity, Nigdi.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
                else if (position == 6) {
                    MainAdapter.this.activity.startActivity(new Intent(MainAdapter.this.activity, Pradhikaran.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
                   else if (position == 7) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainAdapter.this.activity);
                    builder.setTitle("Logout");
                    builder.setMessage("Are you sure you want to quit this app?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        /* class com.android_coding.navigationdrawer.MainAdapter.AnonymousClass1.AnonymousClass1 */

                        public void onClick(DialogInterface dialog, int which) {
                            MainAdapter.this.activity.finishAffinity();
                            System.exit(0);
                        }
                    });
                    builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        /* class com.android_coding.navigationdrawer.MainAdapter.AnonymousClass1.AnonymousClass2 */

                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
