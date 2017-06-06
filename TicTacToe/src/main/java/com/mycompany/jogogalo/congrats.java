package com.mycompany.jogogalo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class congrats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        Bundle winner = getIntent().getExtras();
        if (winner != null) {
            String won = winner.getString("winner");
            if (won.equals("tie")) {
                TextView v = (TextView) findViewById(R.id.winner);
                v.setText("It's a tie!");
            }
            else{
                TextView v = (TextView) findViewById(R.id.winner);
                v.setText(won + " won");
            }
        }
    }

    public void restartGame(View v){
        Intent intent = new Intent(this, main.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, main_screen.class);
        startActivity(intent);
    }

}
