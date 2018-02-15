package me.kingtux.tuxreminder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CreateReminder extends AppCompatActivity {

  private CreateReminder createReminder;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_reminder);
    Button button = findViewById(R.id.create);
    createReminder = this;
    button.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        MyReminderThread reminderThread = new MyReminderThread(createReminder.getApplicationContext());
        reminderThread.start();
        Toast.makeText(CreateReminder.this, "Shown", Toast.LENGTH_SHORT).show();

        TextView name, startTime, endTime, interval;
        name = (TextView) findViewById(R.id.name);
        startTime = (TextView) findViewById(R.id.startTime);
        endTime = (TextView) findViewById(R.id.endTime);
        interval = (TextView) findViewById(R.id.interval);
        Reminder reminder;
        reminder = new Reminder(name.getText().toString(),
            Double.parseDouble(startTime.getText().toString()),
            Double.parseDouble(endTime.getText().toString()),
            Double.parseDouble(interval.getText().toString()));
        write(Reminder.toJson(reminder));

        Toast.makeText(CreateReminder.this, reminder.toString(), Toast.LENGTH_SHORT).show();
        // setContentView(R.layout.activity_main);

      }
    });
  }

  public void write(String json) {
    SharedPreferences sharedPref = createReminder
        .getSharedPreferences("TuxReminder", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString("reminder", json);
    editor.apply();
  }
}
