package com.restuarants.smart.speechtotextwatsonv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button placeOrderButton = (Button) findViewById(R.id.etPlaceOrder);
        Button double_double_button = (Button) findViewById(R.id.etDouble_double);

        // Button for confirmation
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, ConfirmationActivity.class);
                MenuActivity.this.startActivity(intent);
            }
        });

        // Button for the Double_Double
        double_double_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String value = "value";
                Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                i.putExtra("my_variable",value);
                startActivity(i);
            }
        });
    }

    public void onToggleClicked(View view) {
    }
}
