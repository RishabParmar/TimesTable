package com.example.parma.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SeekBar logic
        SeekBar multiSeeker = findViewById(R.id.multiSeeker);
        multiSeeker.setMin(1);
        multiSeeker.setMax(20);
        multiSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // ListView logic
                final ListView listView = findViewById(R.id.digitsList);
                ArrayList<Integer> multiplierArray = new ArrayList<Integer>();
                // In the following line, the context should be MainActivity.this and not this because if we write this
                // it will refer to the seekbar and not the activity in which the listView resides
                ArrayAdapter<Integer> arrayListAdapter = new ArrayAdapter<Integer>(MainActivity.this, android.R.layout.simple_list_item_1, multiplierArray);

                for (int multiplier = 1; multiplier <= 10; multiplier++) {
                    multiplierArray.add(i*multiplier);
                }

                listView.setAdapter(arrayListAdapter);
                TextView multiplierMessage = findViewById(R.id.multiplierText);
                String message = Integer.toString(i) + "'s Table";
                multiplierMessage.setText(message);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
