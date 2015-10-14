package com.example.administrator.myapplication;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input = (EditText)findViewById(R.id.userInput);
        final TextView output = (TextView)findViewById(R.id.output);

        Button reverseB = (Button)findViewById(R.id.reverse);
        reverseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = input.getText().toString();
                String reverseOutput = (new StringBuilder(userInput).reverse().toString());
                output.setText(reverseOutput);

                Drawable input_color = input.getBackground();
                Drawable output_color = output.getBackground();
                int tColor1 = (input.getCurrentTextColor());
                int tColor2 = output.getCurrentTextColor();

                input.setBackground(output_color);
                input.setTextColor(tColor2);
                output.setBackground(input_color);
                output.setTextColor(tColor1);
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
