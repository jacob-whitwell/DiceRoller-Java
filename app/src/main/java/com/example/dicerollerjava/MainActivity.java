package com.example.dicerollerjava;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.Math;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private final String myPrefs = "MyPrefs";
    private final String Name = "nameKey";
    private final int luckyNumber = (int) (Math.random() * 6 + 1);
    private final String luckyHint = ("The lucky number is: " + luckyNumber);

    SharedPreferences sharedPreferences = getSharedPreferences(myPrefs, Context.MODE_PRIVATE);

    public static final String EXTRA_MESSAGE = "com.example.DiceRollerJava.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** valueOf is basically the same as toString() */
        //String numberSides = String.valueOf(dice.GetSides() + " is the length of the  dice");
        Button button = findViewById(R.id.rollButton);

        /**
         * Create toast
         */
        Toast toast = Toast.makeText(getApplicationContext(), luckyHint, Toast.LENGTH_SHORT);


        /**
         * Setup the click listener for the button, and when the button is pressed
         * set the rollNumber TextView to the value of the DiceRoll method.
         */
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                roll();
            }
        });

        Button hintButton = findViewById(R.id.hintButton);
        hintButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toast.cancel();
                toast.show();
            }
        });
    }

    private void roll() {
        Dice dice = new Dice(6);
        Dice diceTwo = new Dice(6);

        TextView successfulRoll = (TextView) findViewById(R.id.successfulRoll);
        ImageView diceOneImage = findViewById(R.id.diceOneImage);
        ImageView diceTwoImage = findViewById(R.id.diceTwoImage);

        /**
         * Init the dice roll used in the switch statement
         */
        int diceOneRoll = dice.DiceRoll();
        int diceTwoRoll = diceTwo.DiceRoll();

        if (diceOneRoll == this.luckyNumber || diceTwoRoll == this.luckyNumber) {
            successfulRoll.setText(R.string.luckyRollText);
        } else {
            successfulRoll.setText("");
        }

        // diceOneImage.setImageResource(R.drawable.dice_1);

        /**
         * Change the image of the dice depending on what the roll outcome is
         */
        switch (diceOneRoll) {
            case 1:
                diceOneImage.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                diceOneImage.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                diceOneImage.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                diceOneImage.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                diceOneImage.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                diceOneImage.setImageResource(R.drawable.dice_6);
                break;
        }

        switch (diceTwoRoll) {
            case 1:
                diceTwoImage.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                diceTwoImage.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                diceTwoImage.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                diceTwoImage.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                diceTwoImage.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                diceTwoImage.setImageResource(R.drawable.dice_6);
                break;
        }
    }
}

