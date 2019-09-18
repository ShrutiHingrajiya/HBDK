package com.example.hbd_k.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hbd_k.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MasterTreasure extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Treasure");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_treasure);

        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btn10 = (Button) findViewById(R.id.btn_10);
        this.setListners();

    }

    private void setListners() {

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("id").setValue("1");
                myRef.child("clue").setValue(getResources().getString(R.string.car_hint)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MasterTreasure.this, "Msg Sent", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("id").setValue("2");
                myRef.child("clue").setValue(getResources().getString(R.string.tample_hint)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MasterTreasure.this, "Msg Sent", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("id").setValue("3");
                myRef.child("clue").setValue(getResources().getString(R.string.stickey_note_hint)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MasterTreasure.this, "Msg Sent", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("id").setValue("4");
                myRef.child("clue").setValue(getResources().getString(R.string.moniter_hint)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MasterTreasure.this, "Msg Sent", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("id").setValue("5");
                myRef.child("clue").setValue(getResources().getString(R.string.projector_hint)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MasterTreasure.this, "Msg Sent", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("id").setValue("6");
                myRef.child("clue").setValue(getResources().getString(R.string.coofie_hint)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MasterTreasure.this, "Msg Sent", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("id").setValue("1");
                myRef.child("clue").setValue(getResources().getString(R.string.broadband_hint)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MasterTreasure.this, "Msg Sent", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("id").setValue("8");
                myRef.child("clue").setValue(getResources().getString(R.string.register_hint)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MasterTreasure.this, "Msg Sent", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("id").setValue("9");
                myRef.child("clue").setValue(getResources().getString(R.string.frize_hint)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MasterTreasure.this, "Msg Sent", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("id").setValue("10");
                myRef.child("clue").setValue(getResources().getString(R.string.Chair_hint)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MasterTreasure.this, "Msg Sent", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
