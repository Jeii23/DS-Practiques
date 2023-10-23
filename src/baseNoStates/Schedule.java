package baseNoStates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule {
  private LocalDate startDate;
  private LocalDate endDate;
  private ArrayList<DayOfWeek> daysOfWeek;
  private LocalTime startTime;
  private LocalTime endTime;

  public Schedule(LocalDate startDate, LocalDate endDate, ArrayList<DayOfWeek> daysOfWeek, LocalTime startTime, LocalTime endTime) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.daysOfWeek = daysOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }
  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public ArrayList<DayOfWeek> getDaysOfWeek() {
    return daysOfWeek;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

}
