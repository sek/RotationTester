
package com.example.newera;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RotationTester extends ListActivity {
    String[] listItems = { "RotatingHelloWorld", "NonRotatingHelloWorld" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int itemLayout = android.R.layout.simple_list_item_1;
        setListAdapter(new ArrayAdapter<String>(this, itemLayout, listItems));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        try {
            startActivity(new Intent(this, Class.forName(getPackageName() + "."
                    + listItems[position])));
        } catch (ClassNotFoundException e) {
            Toast.makeText(this, "could not find Activity for: " + listItems[position],
                    Toast.LENGTH_SHORT).show();
        }
    }
}
