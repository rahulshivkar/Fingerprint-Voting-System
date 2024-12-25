// VotingActivity.java
package com.example.votekaro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class VotingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button partyAButton = findViewById(R.id.partyAButton);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button partyBButton = findViewById(R.id.partyBButton);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button partyCButton = findViewById(R.id.partyCButton);

        partyAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic to vote for Party A
                // Display success message
                Toast.makeText(VotingActivity.this, "Vote for Party A recorded successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        partyBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic to vote for Party B
                // Display success message
                Toast.makeText(VotingActivity.this, "Vote for Party B recorded successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        partyCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic to vote for Party C
                // Display success message
                Toast.makeText(VotingActivity.this, "Vote for Party C recorded successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
