package com.mycompany.jogogalo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class main extends AppCompatActivity {

    private int plays = 0;
    private String won = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showIcon(View v) {
        TextView iv = (TextView) findViewById(v.getId());
        if (iv.getText().equals("")) {
            if (plays % 2 == 0) {
                iv.setText("O");
                TextView turn = (TextView) findViewById(R.id.turn);
                turn.setText("X Turn");
            }
            else {
                iv.setText("X");
                TextView turn = (TextView) findViewById(R.id.turn);
                turn.setText("O Turn");
            }
            plays++;
            if (checkResult()) {
                Intent intent = new Intent(this, congrats.class);
                intent.putExtra("winner", won);
                startActivity(intent);
            }
            else if (tie()) {
                Intent intent = new Intent(this, congrats.class);
                intent.putExtra("winner", "tie");
                startActivity(intent);
            }
        }
    }

    public boolean tie() {
        String l1 = (String) ((TextView) findViewById(R.id.l1)).getText();
        String l2 = (String) ((TextView) findViewById(R.id.l2)).getText();
        String l3 = (String) ((TextView) findViewById(R.id.l3)).getText();
        String l4 = (String) ((TextView) findViewById(R.id.l4)).getText();
        String l5 = (String) ((TextView) findViewById(R.id.l5)).getText();
        String l6 = (String) ((TextView) findViewById(R.id.l6)).getText();
        String l7 = (String) ((TextView) findViewById(R.id.l7)).getText();
        String l8 = (String) ((TextView) findViewById(R.id.l8)).getText();
        String l9 = (String) ((TextView) findViewById(R.id.l9)).getText();
        String[] s = {l1, l2, l3, l4, l5, l6, l7, l8, l9};
        for (String str : s) {
            if (str.equals("")) {
                return false;
            }
        }
        return true;
    }

    public boolean checkResult() {
        String l1 = (String) ((TextView) findViewById(R.id.l1)).getText();
        String l2 = (String) ((TextView) findViewById(R.id.l2)).getText();
        String l3 = (String) ((TextView) findViewById(R.id.l3)).getText();
        String l4 = (String) ((TextView) findViewById(R.id.l4)).getText();
        String l5 = (String) ((TextView) findViewById(R.id.l5)).getText();
        String l6 = (String) ((TextView) findViewById(R.id.l6)).getText();
        String l7 = (String) ((TextView) findViewById(R.id.l7)).getText();
        String l8 = (String) ((TextView) findViewById(R.id.l8)).getText();
        String l9 = (String) ((TextView) findViewById(R.id.l9)).getText();
        if (l1.equals(l2) && l2.equals(l3) && !l1.equals("")) {
            won = l1;
            return true;
        } else if (l4.equals(l5) && l5.equals(l6) && !l4.equals("")) {
            won = l4;
            return true;
        } else if (l7.equals(l8) && l8.equals(l9) && !l7.equals("")) {
            won = l7;
            return true;
        } else if (l1.equals(l4) && l4.equals(l7) && !l1.equals("")) {
            won = l1;
            return true;
        } else if (l2.equals(l5) && l5.equals(l8) && !l2.equals("")) {
            won = l2;
            return true;
        } else if (l3.equals(l6) && l6.equals(l9) && !l3.equals("")) {
            won = l3;
            return true;
        } else if (l1.equals(l5) && l5.equals(l9) && !l1.equals("")) {
            won = l1;
            return true;
        } else if (l3.equals(l5) && l5.equals(l7) && !l3.equals("")) {
            won = l3;
            return true;
        } else
            return false;
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, main_screen.class);
        startActivity(intent);
    }
}