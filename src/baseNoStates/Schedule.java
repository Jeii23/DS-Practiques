package baseNoStates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


public class Schedule {

  // Start date of the schedule.
  private LocalDate startDate;

  // End date of the schedule.
  private LocalDate endDate;

  // List of days of the week when the schedule is active.
  private ArrayList<DayOfWeek> daysOfWeek;

  // Start time of the schedule.
  private LocalTime startTime;

  // End time of the schedule.
  private LocalTime endTime;

  /**
   * Initializes a schedule with the specified start and end dates, days of the week,
   * and time range.
   */
  public Schedule(LocalDate startDate, LocalDate endDate,
                  ArrayList<DayOfWeek> daysOfWeek, LocalTime startTime, LocalTime endTime) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.daysOfWeek = daysOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * Returns the start date of the schedule.
   */
  public LocalDate getStartDate() {
    return startDate;
  }

  /**
   * Returns the end date of the schedule.
   */
  public LocalDate getEndDate() {
    return endDate;
  }

  /**
   * Returns the list of days of the week when the schedule is active.
   */
  public ArrayList<DayOfWeek> getDaysOfWeek() {
    return daysOfWeek;
  }

  /**
   * Returns the start time of the schedule.
   */
  public LocalTime getStartTime() {
    return startTime;
  }

  /**
   * Returns the end time of the schedule.
   */
  public LocalTime getEndTime() {
    return endTime;
  }

  /**
   * Checks if a given date and time fall within the schedule.
   */
  public boolean isInSchedule(LocalDateTime now) {
    LocalDate currentDate = now.toLocalDate();
    LocalTime currentTime = now.toLocalTime();
    DayOfWeek currentDayOfWeek = now.getDayOfWeek();


    // Check if the current date and time are within the schedule's constraints.
    if ((currentDate.isEqual(startDate) || currentDate.isAfter(startDate))
        && (currentDate.isEqual(endDate) || currentDate.isBefore(endDate))
        && daysOfWeek.contains(currentDayOfWeek)
        && (currentTime.equals(startTime) || currentTime.isAfter(startTime))
        && (currentTime.equals(endTime) || currentTime.isBefore(endTime))) {
      return true;
    } else {
      return false;
    }


  }
}

