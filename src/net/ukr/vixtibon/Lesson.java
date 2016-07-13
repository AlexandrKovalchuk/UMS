package net.ukr.vixtibon;

import java.io.Serializable;

/**
 * Created by akovalchuk on 5/22/2015.
 */
public class Lesson implements Serializable {
    private static final long serialVersionUID = 1L;
    private String timeStart;
    private Discipline discipline;
    private Teacher teacher;
    private int lessonNumberInDay;

    public void setLessonNumberInDay(int lessonNumberInDay) {
        this.lessonNumberInDay = lessonNumberInDay;
        switch (lessonNumberInDay){
            case 1: {timeStart = "8:30";} break;
            case 2: {timeStart = "10:25";} break;
            case 3: {timeStart = "12:20";} break;
            case 4: {timeStart = "14:15";} break;
            case 5: {timeStart = "16:10";} break;
            case 6: {timeStart = "18:05";} break;
            case 7: {timeStart = "20:00";} break;
            default: System.out.println("Error in setLessonNumberInDay");
        }
    }

    public Lesson(int lessonNumberInDay) {
        this.lessonNumberInDay = lessonNumberInDay;
        setLessonNumberInDay(this.lessonNumberInDay);
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public void setDiscipline(Discipline discipline) {

        this.discipline = discipline;
    }

    public int getLessonNumberInDay() {
        return lessonNumberInDay;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void showLesson(){
        System. out .println(getTimeStart() + " " + (getDiscipline() != null ? discipline.getNameOfDiscipline(): "none") + " " +   (getTeacher() != null ? teacher.getName(): "none") +
                " " + (getTeacher() != null ? teacher.getSecondName(): "none"));
    }
}
