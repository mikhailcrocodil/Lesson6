package ru.mirea.martynovmv.lesson6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.martynovmv.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences preferences	= getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
        String group = preferences.getString("Group", "unknown");
        int numberinlist = preferences.getInt("NumberInList", 0);
        String serialorfilm = preferences.getString("Serial/Film", "unknown");

        binding.edGroup.setText(group);
        binding.edList.setText(String.valueOf(numberinlist));
        binding.edSerial.setText(serialorfilm);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences_bt = getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
                SharedPreferences.Editor editor_bt	= preferences_bt.edit();
                editor_bt.putString("Group", binding.edGroup.getText().toString());
                editor_bt.putInt("NumberInList", Integer.parseInt(binding.edList.getText().toString()));
                editor_bt.putString("Serial/Film",binding.edSerial.getText().toString());
                editor_bt.apply();

            }
        });
    }
}