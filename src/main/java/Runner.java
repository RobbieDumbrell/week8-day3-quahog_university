import db.DBCourse;
import db.DBHelper;
import db.DBLesson;
import db.DBStudent;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("Chemistry", "BSc");
        Course course2 = new Course("Physics", "BSc");
        Course course3 = new Course("Computer Science", "MSc");
        Course course4 = new Course("Maths", "MSc");

        DBHelper.save(course1);
        DBHelper.save(course2);
        DBHelper.save(course3);
        DBHelper.save(course4);

        Instructor instructor1 = new Instructor("Alex");
        Instructor instructor2 = new Instructor("Pawel");
        Instructor instructor3 = new Instructor("Colin");

        DBHelper.save(instructor1);
        DBHelper.save(instructor2);
        DBHelper.save(instructor3);

        Lesson lesson1 = new Lesson("Organic", 98, course1, instructor1);
        Lesson lesson2 = new Lesson("Physical", 92, course1, instructor1);
        Lesson lesson3 = new Lesson("Inorganic", 45, course1, instructor1);
        Lesson lesson4 = new Lesson("Astrophysics", 22, course2, instructor2);
        Lesson lesson5 = new Lesson("Quantum Physics", 21, course2, instructor2);
        Lesson lesson6 = new Lesson("Ruby", 1, course3, instructor3);

        DBHelper.save(lesson1);
        DBHelper.save(lesson2);
        DBHelper.save(lesson3);
        DBHelper.save(lesson4);
        DBHelper.save(lesson5);
        DBHelper.save(lesson6);

        Mentor mentor1 = new Mentor("Professor Kevin");
        Mentor mentor2 = new Mentor("Professor Martin");
        Mentor mentor3 = new Mentor("Professor Judy");
        Mentor mentor4 = new Mentor("Professor Julie");
        Mentor mentor5 = new Mentor("Professor Melvin");
        Mentor mentor6 = new Mentor("Professor Daniel");

        DBHelper.save(mentor1);
        DBHelper.save(mentor2);
        DBHelper.save(mentor3);
        DBHelper.save(mentor4);
        DBHelper.save(mentor5);
        DBHelper.save(mentor6);

        Student student1 = new Student("Robbie", 25, 897, course1, mentor1);
        Student student2 = new Student("Ellie", 25, 789, course1, mentor2);
        Student student3 = new Student("Molly", 28, 123, course2, mentor3);
        Student student4 = new Student("Stoo", 29, 832, course2, mentor4);
        Student student5 = new Student("Vicki", 24, 812, course1, mentor5);
        Student student6 = new Student("Kirstin", 27, 983, course2, mentor6);

        DBHelper.save(student1);
        DBHelper.save(student2);
        DBHelper.save(student3);
        DBHelper.save(student4);
        DBHelper.save(student5);
        DBHelper.save(student6);

        List<Lesson> availableLessonsStudent1 = DBStudent.getAvailableLessonsFor(student1);

        DBStudent.addStudentToLesson(student1, lesson1);
        DBStudent.addStudentToLesson(student2, lesson1);
        DBStudent.addStudentToLesson(student3, lesson1);
        DBStudent.addStudentToLesson(student1, lesson2);
        DBStudent.addStudentToLesson(student1, lesson3);
        DBStudent.addStudentToLesson(student1, lesson6);  // shouldn't be allowed???

        List<Lesson> course1Lessons = DBCourse.getLessonsOf(course1);
        List<Student> course1Students = DBCourse.getStudentsOf(course1);

        List<Student> lesson1Students  = DBLesson.getStudentsFor(lesson1);
        List<Lesson> student1Lessons  = DBStudent.getLessonsFor(student1);

    }

}
