package com.iubat.chatapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtMessage;
    TextView txtMessage;
    ImageView imgSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edt_name);
        edtMessage = findViewById(R.id.edt_message);
        txtMessage = findViewById(R.id.txt_message);
        imgSend = findViewById(R.id.img_send);

        imgSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = db.getReference("message");
        databaseReference.setValue("Hello World!");

    }

    private void sendMessage() {
        String name = edtName.getText().toString();
        String message = edtMessage.getText().toString();

        if (name.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "Please enter your name and message", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!message.isEmpty()) {

        }
    }
}