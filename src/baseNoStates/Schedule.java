package baseNoStates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule {

  //Definim els atributs de la nostra classe i seguidament els inicialitzem.
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
  //Funció que retorna la data de començament
  public LocalDate getStartDate() {
    return startDate;
  }


  //Funció que retorna la data de finalització
  public LocalDate getEndDate() {
    return endDate;
  }

  //Funció que retorna l'array de tots els dies que composen un setmana
  public ArrayList<DayOfWeek> getDaysOfWeek() {
    return daysOfWeek;
  }

  //Funció que retorna l´'hora de començament

  public LocalTime getStartTime() {
    return startTime;
  }


  //Funció que retorna l'hora de finalització
  public LocalTime getEndTime() {
    return endTime;
  }

  public boolean isInSchedule(LocalDateTime now) { //Ceder espacio en schedule
    LocalDate currentDate = now.toLocalDate();
    LocalTime currentTime = now.toLocalTime();
    DayOfWeek currentDayOfWeek = now.getDayOfWeek();

    if ((currentDate.isEqual(startDate) || currentDate.isAfter(startDate)) &&
        (currentDate.isEqual(endDate) || currentDate.isBefore(endDate)) &&
        daysOfWeek.contains(currentDayOfWeek) &&
        (currentTime.equals(startTime) || currentTime.isAfter(startTime)) &&
        (currentTime.equals(endTime) || currentTime.isBefore(endTime))) {
      return true;
    } else {
      return false;
    }
  }

}
