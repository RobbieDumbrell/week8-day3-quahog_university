package db;

import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBStudent {

    private static Session session;

    public static void addStudentToLesson(Student student, Lesson lesson){
//        List<Lesson> avalaibleLessons = DBStudent.getAvailableLessonsFor(student);
//        if (avalaibleLessons.contains(lesson)){
            lesson.addStudent(student);
            DBHelper.update(lesson);
//        }
    }

    public static List<Lesson> getLessonsFor(Student student){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> results = null;
        try {
            Criteria cr = session.createCriteria(Lesson.class);
            cr.createAlias("students", "student");
            cr.add(Restrictions.eq("student.id", student.getId()));
            results = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Lesson> getAvailableLessonsFor(Student student) {
       List<Lesson> results = DBCourse.getLessonsOf(student.getCourse());
       return results;
    }
}
