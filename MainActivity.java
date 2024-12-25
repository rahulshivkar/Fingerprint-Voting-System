// MainActivity.java
package com.example.votekaro;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_USE_BIOMETRIC = 1001;

    private EditText nameEditText, idEditText;
    private Button loginButton;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        idEditText = findViewById(R.id.idEditText);
        loginButton = findViewById(R.id.loginButton);

        // Request permission for biometric authentication
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.USE_BIOMETRIC)
                != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.USE_BIOMETRIC}, REQUEST_USE_BIOMETRIC);
        }

        // Create executor for biometric prompt
        Executor executor = ContextCompat.getMainExecutor(this);

        // Initialize biometric prompt
        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                // Authentication successful, proceed to voting screen
                Intent intent = new Intent(MainActivity.this, VotingActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                // Authentication failed, handle accordingly
                Toast.makeText(MainActivity.this, "Fingerprint authentication failed!", Toast.LENGTH_SHORT).show();
            }
        });

        // Set biometric prompt info
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric Login")
                .setSubtitle("Login using your fingerprint")
                .setNegativeButtonText("Cancel")
                .build();

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dummy login process, replace with actual authentication logic
                String name = nameEditText.getText().toString().trim();
                String id = idEditText.getText().toString().trim();

                // Dummy condition, assume user provided name and ID
                if (!name.isEmpty() && !id.isEmpty()) {
                    // Prompt user for fingerprint authentication
                    biometricPrompt.authenticate(promptInfo);
                } else {
                    Toast.makeText(MainActivity.this, "Please provide name and ID.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
