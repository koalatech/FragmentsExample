package com.koalatech.fragmentsexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    Button B1, B2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1 = (Button)findViewById(R.id.button1);
        B2 = (Button)findViewById(R.id.button2);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager FM = getFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();
                FragmentOne F1 = new FragmentOne();

                    FT.add(R.id.FrameLayout1,F1);
                    FM.popBackStackImmediate(); //removes previous running fragment
                    FT.addToBackStack("F1");
                    FT.commit();


            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager FM = getFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();
                FragmentTwo F2 = new FragmentTwo();

                FT.add(R.id.FrameLayout2,F2);
                FM.popBackStackImmediate(); //removes previous running fragment
                FT.addToBackStack("F2");
                FT.commit();


            }


        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
