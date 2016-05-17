package com.example.aaron.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void save(View view)
    {
        EditText name = (EditText)findViewById(R.id.editText);
        EditText pass = (EditText)findViewById(R.id.editText2);
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", name.getText().toString());
        editor.putString("password", pass.getText().toString());
        editor.apply();
        Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void display(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        String name = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        TextView top = (TextView) findViewById(R.id.textView);
        TextView bottom = (TextView) findViewById(R.id.textView2);
        top.setText(name);
        bottom.setText(password);
    }
}
