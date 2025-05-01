package com.iubat.chatapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtMessage;
    TextView txtMessage;
    ImageView imgSend;
    FirebaseDatabase db;
    DatabaseReference databaseReference;

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

        db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference("message");
       // databaseReference.setValue("Hello World!");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void sendMessage() {
        String name = edtName.getText().toString();
        String message = edtMessage.getText().toString();

        if (name.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "Please enter your name and message", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!message.isEmpty()) {
            edtName.setVisibility(View.GONE);
            edtMessage.setText("");
            DatabaseReference dr = databaseReference.push();
            MessageModel messageModel = new MessageModel(dr.getKey(), name, message, System.currentTimeMillis());
            dr.setValue(messageModel);
        }
    }
}