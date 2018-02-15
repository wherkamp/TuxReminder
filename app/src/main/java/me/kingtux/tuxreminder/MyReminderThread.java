package me.kingtux.tuxreminder;

import android.content.Context;
import java.util.concurrent.TimeUnit;

public class MyReminderThread extends Thread{
  private Context context;
  public MyReminderThread(Context context){
    this.context = context;
  }
  @Override
  public void run(){
    //Toast.makeText(context, "You Failed!", Toast.LENGTH_SHORT).show();

    try {
      sleep(TimeUnit.SECONDS.toMillis(1));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
