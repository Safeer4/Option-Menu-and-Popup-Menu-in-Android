package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    Menu myMenu;
    EditText selectItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        selectItem = (EditText)findViewById(R.id.popupmenu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1)
        {
            Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.item2)
        {
            Toast.makeText(this, "About Selected", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.item3)
        {
            Toast.makeText(this, "Contact Selected", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    public void btnPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.main_menu, popup.getMenu());
        popup.show();

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.item1)
                {
                    selectItem.setText("Home");
                    Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                }
                if (menuItem.getItemId() == R.id.item2)
                {
                    selectItem.setText("About");
                    Toast.makeText(MainActivity.this, "About Selected", Toast.LENGTH_SHORT).show();
                }
                if (menuItem.getItemId() == R.id.item3)
                {
                    selectItem.setText("Contact");
                    Toast.makeText(MainActivity.this, "Contact Selected", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
    }
}