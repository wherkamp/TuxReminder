package me.kingtux.tuxreminder;

import com.google.gson.Gson;

public class Reminder {

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public double getInterval() {
    return interval;
  }

  public void setInterval(double interval) {
    this.interval = interval;
  }

  public double getStartTime() {
    return startTime;
  }

  public void setStartTime(double startTime) {
    this.startTime = startTime;
  }

  public double getEndTime() {
    return endTime;
  }

  public void setEndTime(double endTime) {
    this.endTime = endTime;
  }

  public Reminder(String item, double interval, double startTime, double endTime) {

    this.item = item;
    this.interval = interval;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  private String item;
  private double interval, startTime, endTime;

  @Override
  public String toString() {
    return "Reminder{" +
        "item='" + item + '\'' +
        ", interval=" + interval +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        '}';
  }

  /**
   *
   * @param reminder
   * @return
   */
  public static String toJson(Reminder reminder){
    Gson gson = new Gson();
    return gson.toJson(reminder);
  }

  /**
   *
   * @param json
   * @return
   */
  public static Reminder fromJson(String json){
    Gson gson = new Gson();
    return gson.fromJson(json, Reminder.class);
  }
}
