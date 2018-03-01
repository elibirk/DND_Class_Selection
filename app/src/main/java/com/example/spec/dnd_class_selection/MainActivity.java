package com.example.spec.dnd_class_selection;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;
    private final String[] classes = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Wizard",
            "Monk", "Paladin", "Ranger", "Sorcerer", "Rogue", "Warlock"};
    private final String[] images = {"barbarian", "bard", "cleric", "druid", "fighter", "wizard",
            "monk", "paladin", "ranger", "sorcerer", "rogue", "warlock"};
    //these arrays contain our class titles and the names of the associated images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listview);
        final ImageView iv = (ImageView) findViewById(R.id.iv_class);
        //this allows us to find the image associated with the row

        LAdapter adapter = new LAdapter(this, classes);
        list.setAdapter(adapter);//set listview's adapter

        //Set OnItemClickListener for the list view
        //so when a user click a row, the related image is shown.
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You've chosen " + classes[position], Toast.LENGTH_SHORT).show();
                //Make a toast to indicate change in D&D class

                int num = getResources().getIdentifier(images[position], "drawable", getPackageName());
                iv.setImageResource(num);
                //Set header image to match the class
            }
        });//end setItemClickListener
    }//end onCreate
}//end MainActivity
