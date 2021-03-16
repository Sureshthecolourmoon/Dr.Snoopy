package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.drsnoopy.R;

public class AgentRegistrationActivity extends AppCompatActivity {
    Button agent_next_agent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_registration);
        agent_next_agent = findViewById(R.id.agent_next_agent);
        agent_next_agent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgentRegistrationActivity.this, AgentRegistrationFinalActivity.class);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                startActivity(intent);
            }
        });

    }
}