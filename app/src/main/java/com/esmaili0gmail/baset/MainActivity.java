package com.esmaili0gmail.baset;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
private EditText edt_Name,edt_PhoneNUmber;
private Switch sw_experience;
private SeekBar seekBar;
private RatingBar ratingbar;
private RadioGroup radioGroup;
private LinearLayout visibility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupToolbar();
        setupCompenets();

    }

    private void setupCompenets() {
        sw_experience.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    visibility.setVisibility(View.VISIBLE);
                }else {
                    visibility.setVisibility(View.GONE);
                }
            }
        });
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(getBaseContext(),R.drawable.ic_done_black_24dp));
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating>=4){
                    Toast.makeText(MainActivity.this, "خوب است علاقه مندی", Toast.LENGTH_SHORT).show();
                }
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edt_Name.getText().toString())&&!TextUtils.isEmpty(edt_PhoneNUmber.getText().toString())){
                    if (sw_experience.isChecked()){
                        if (seekBar.getProgress()>=2){
                            if (ratingbar.getRating()>=4){
                                Toast.makeText(MainActivity.this, edt_Name.getText().toString()+"به شرکت ما خوش آمدی شما استخدام هستید", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(MainActivity.this, "شما به حرفه خود علاقه ندارید و این روحیه کاری را از بین می برد", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "سابقه کاری شما بسیار کم است", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        if (radioGroup.getCheckedRadioButtonId()==-1){
                            Toast.makeText(MainActivity.this, getResources().getString(R.string.not_have_college), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "درست است که شما تحصیلات خوبی دارید اما سابقه بسیار مهم است", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.name_and_phone_not_be_empty), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupViews() {
        toolbar=findViewById(R.id.toolbar);
        edt_Name=(EditText)findViewById(R.id.edt_name);
        edt_PhoneNUmber=(EditText)findViewById(R.id.edt_phone);
        sw_experience=(Switch)findViewById(R.id.sw_experience);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        ratingbar=(RatingBar)findViewById(R.id.ratingbar);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        visibility=findViewById(R.id.linearLayout3);
    }
}
