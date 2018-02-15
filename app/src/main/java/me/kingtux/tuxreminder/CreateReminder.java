package me.kingtux.tuxreminder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateReminder extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_reminder);
    Button button = findViewById(R.id.create);
    button.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        Toast.makeText(CreateReminder.this, "Shown", Toast.LENGTH_SHORT).show();

       // TextView name, startTime, endTime, interval;
        //name = (TextView) findViewById(R.id.name);
        //startTime = (TextView) findViewById(R.id.startTime);
        //endTime = (TextView) findViewById(R.id.endTime);
        //interval = (TextView) findViewById(R.id.interval);
        //Reminder reminder;
        //reminder = new Reminder(name.getText().toString(),
         //   Double.parseDouble(startTime.getText().toString()),
           // Double.parseDouble(endTime.getText().toString()),
           // Double.parseDouble(interval.getText().toString()));
          //write(Reminder.toJson(reminder));

      //  Toast.makeText(CreateReminder.this, reminder.toString(), Toast.LENGTH_SHORT).show();
       // setContentView(R.layout.activity_main);

      }
    });
  }

  public void write(String json) throws IOException {

    File gpxfile = new File("reminder.txt");
    FileWriter writer = new FileWriter(gpxfile);
    writer.append(json);
    writer.flush();
    writer.close();
  }
}
