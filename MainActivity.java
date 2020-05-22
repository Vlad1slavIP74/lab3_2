package com.example.lab3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        EditText XA = (EditText) findViewById(R.id.Xa);
        EditText YA = (EditText) findViewById(R.id.Ya);
        EditText XB = (EditText) findViewById(R.id.Xb);
        EditText YB = (EditText) findViewById(R.id.Yb);
        EditText XC = (EditText) findViewById(R.id.Xc);
        EditText YC = (EditText) findViewById(R.id.Yc);
        EditText XD = (EditText) findViewById(R.id.Xd);
        EditText YD = (EditText) findViewById(R.id.Yd);

        EditText Learn = (EditText) findViewById(R.id.learnKoef);
        EditText Count = (EditText) findViewById(R.id.countNumber);
        TextView resultText = (TextView) findViewById(R.id.resultText);
        TextView timeTook = (TextView) findViewById(R.id.timeTook);

        if (XA.getText().toString().trim().equals("")
                || YA.getText().toString().trim().equals("")
                || XB.getText().toString().trim().equals("")
                || YB.getText().toString().trim().equals("")
                || XC.getText().toString().trim().equals("")
                || YC.getText().toString().trim().equals("")
                || XD.getText().toString().trim().equals("")
                || YD.getText().toString().trim().equals("")
                || Learn.getText().toString().trim().equals("")
                || Count.getText().toString().trim().equals("")) {
            resultText.setText("Введіть вірні дані!");
            return;
        }

        int Xa = Integer.parseInt(XA.getText().toString());
        int Ya = Integer.parseInt(YA.getText().toString());
        int Xb = Integer.parseInt(XB.getText().toString());
        int Yb = Integer.parseInt(YB.getText().toString());
        int Xc = Integer.parseInt(XC.getText().toString());
        int Yc = Integer.parseInt(YC.getText().toString());
        int Xd = Integer.parseInt(XD.getText().toString());
        int Yd = Integer.parseInt(YD.getText().toString());

        double learning = Double.parseDouble(Learn.getText().toString());
        int iterations = Integer.parseInt(Count.getText().toString());

        double w1a = 0, w2a = 0, wa = 0, wb = 0, wc = 0, wd = 0,
                w1b = 0, w2b = 0, w1c = 0, w2c = 0, w1d = 0, w2d = 0, delta;
        int P = 4;

        double start, end;
        start = System.nanoTime();

        for (int i = 0; i < iterations / 4; i++) {
            wa = w1d * Xa + w2d * Ya;
            delta = P - wa;
            w1a = w1d + Xa * learning * delta;
            w2a = w2d + Ya * learning * delta;

            wb = w1a * Xb + w2a * Yb;
            delta = P - wb;
            w1b = w1a + Xb * learning * delta;
            w2b = w2a + Yb * learning * delta;

            wc = w1b * Xc + w2b * Yc;
            delta = P - wc;
            w1c = w1b + Xc * learning * delta;
            w2c = w2b + Yc * learning * delta;

            wd = w1c * Xd + w2c * Yd;
            delta = P - wd;
            w1d = w1c + Xd * learning * delta;
            w2d = w2c + Yd * learning * delta;
        }

        end = System.nanoTime();
        double time = end - start;

        resultText.setMovementMethod(new ScrollingMovementMethod());
        resultText.setText(String.format("Wa = %.3g%n", wa) +
                "  W1 = " + String.format("%.3g%n", w1a)
                + "  W2 = " + String.format("%.3g%n", w2a)
                + "\nWb = " + String.format("%.3g%n", wb)
                + "  W1 = " + String.format("%.3g%n", w1b)
                + "  W2 = " + String.format("%.3g%n", w2b)
                + "\nWc = " + String.format("%.3g%n", wc)
                + "  W1 = " + String.format("%.3g%n", w1c)
                + "  W2 = " + String.format("%.3g%n", w2c)
                + "\nWd = " + String.format("%.3g%n", wd)
                + "  W1 = " + String.format("%.3g%n", w1d)
                + "  W2 = " + String.format("%.3g%n", w2d)
                + "Витрачено часу: " + time);

        end = System.nanoTime();
        time = end - start;
        timeTook.setText("Витрачено часу: " + time);
    }
    public void Clear(View v) {
        EditText XA = (EditText) findViewById(R.id.Xa);
        EditText YA = (EditText) findViewById(R.id.Ya);
        EditText XB = (EditText) findViewById(R.id.Xb);
        EditText YB = (EditText) findViewById(R.id.Yb);
        EditText XC = (EditText) findViewById(R.id.Xc);
        EditText YC = (EditText) findViewById(R.id.Yc);
        EditText XD = (EditText) findViewById(R.id.Xd);
        EditText YD = (EditText) findViewById(R.id.Yd);

        EditText Learn = (EditText) findViewById(R.id.learnKoef);
        EditText Count = (EditText) findViewById(R.id.countNumber);
        TextView resultText = (TextView) findViewById(R.id.resultText);

        XA.setText(null);
        YA.setText(null);
        XB.setText(null);
        YB.setText(null);
        XC.setText(null);
        YC.setText(null);
        XD.setText(null);
        YD.setText(null);

        Learn.setText(null);
        Count.setText(null);
        resultText.setText(null);
    }

}
