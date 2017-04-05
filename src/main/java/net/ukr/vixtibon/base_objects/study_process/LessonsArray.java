package net.ukr.vixtibon.base_objects.study_process;

import java.util.ArrayList;

/**
 * Created by alex on 04/04/2017.
 */
public class LessonsArray {
    private ArrayList<Lesson> lessons = new ArrayList<>();

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Lesson getLesson(int groupID, int dayNumber, int lessonNumber){
        Lesson lesson = new Lesson();
        ArrayList<Lesson> lessonsByGroupID = new ArrayList<>();
        ArrayList<Lesson> lessonsByDayNumber = new ArrayList<>();
        for(Lesson l: lessons){
            if(l.getGroupID() == groupID){
                lessonsByGroupID.add(l);

            }else{
                continue;
            }
        }
        for(Lesson l: lessonsByGroupID){
            if(l.getDayNumber() == dayNumber){
                lessonsByDayNumber.add(l);
            }else{
                continue;
            }
        }
        for(Lesson l: lessonsByDayNumber){
            if(l.getLessonNumberInDay() == lessonNumber){
                lesson = l;
                break;
            }else{
                continue;
            }
        }
        return  lesson;

    }
}
