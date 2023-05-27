package com.example.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        registerForContextMenu(tvDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        registerForContextMenu(tvOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvUOB);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact Bank");
        if (v == tvDBS) {
            wordClicked = "DBS";
        } else if (v == tvOCBC) {
            wordClicked = "OCBC";
        } else if (v == tvUOB) {
            wordClicked = "UOB";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                // code for action
                String url = "https://www.dbs.com.sg";
                Intent intentLink = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentLink);
                return true;
            } else if (item.getItemId() == 1) {
                // code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18001111111L));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                // code for action
                String url = "https://www.ocbc.com";
                Intent intentLink = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentLink);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18003633333L));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                // code for action
                String url = "https://www.uob.com.sg";
                Intent intentLink = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentLink);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18002222121L));
                startActivity(intentCall);
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }
//}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS ");
            tvOCBC.setText("OCBC ");
            tvUOB.setText("UOB ");
            return true;
        } else if (id == R.id.JapaneseSelection) {
            tvDBS.setText("DBS銀行 ");
            tvOCBC.setText("OCBC銀行");
            tvUOB.setText("UOB銀行 ");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}