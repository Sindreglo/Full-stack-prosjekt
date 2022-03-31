package oso.ntnu.idatt2015.backend.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import oso.ntnu.idatt2015.backend.model.Course.QCourse;
import oso.ntnu.idatt2015.backend.model.Task.Task;
import oso.ntnu.idatt2015.backend.model.User.QRole;
import oso.ntnu.idatt2015.backend.model.User.QUser;
import oso.ntnu.idatt2015.backend.model.User.UserLevel;
import oso.ntnu.idatt2015.backend.model.User.UserRoleCourse;
import oso.ntnu.idatt2015.backend.repository.Course.CourseRepository;
import oso.ntnu.idatt2015.backend.repository.Course.QElementRepository;
import oso.ntnu.idatt2015.backend.repository.Task.TaskRepository;
import oso.ntnu.idatt2015.backend.repository.Task.TaskValidationFilterRepository;
import oso.ntnu.idatt2015.backend.repository.User.RoleRepository;
import oso.ntnu.idatt2015.backend.repository.User.UserLevelRepository;
import oso.ntnu.idatt2015.backend.repository.User.UserRepository;
import oso.ntnu.idatt2015.backend.repository.User.UserRoleCourseRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TestConfig {


    @Bean
    CommandLineRunner simpleRunner(CourseRepository courseRepository, RoleRepository roleRepository,
                                   UserRepository userRepository, UserRoleCourseRepository userRoleCourseRepository,
                                   UserLevelRepository userLevelRepository, QElementRepository qElementRepository,
                                   TaskRepository taskRepository, TaskValidationFilterRepository taskValidationFilterRepository){
        return args -> {
            UserLevel ul1 = new UserLevel("admin");
            UserLevel ul2 = new UserLevel("user");
            userLevelRepository.save(ul1);
            userLevelRepository.save(ul2);

            QRole r1 = new QRole("Professor");
            QRole r2 = new QRole("Student");
            QRole r3 = new QRole("Assistant");
            roleRepository.save(r1);
            roleRepository.save(r2);
            roleRepository.save(r3);

            QCourse c1 = new QCourse("Math");
            QCourse c2 = new QCourse("Physics");
            courseRepository.save(c1);
            courseRepository.save(c2);

            QUser u1 = new QUser("student", "password");
            QUser u2 = new QUser("admin", "password");

            u1.setUserLevel(ul2);
            u2.setUserLevel(ul1);
            userRepository.save(u1);
            userRepository.save(u2);

            List<UserRoleCourse> urc = new ArrayList<>();
            urc.add(new UserRoleCourse(u1, r3, c1));
            urc.add(new UserRoleCourse(u1, r2, c2));
            urc.add(new UserRoleCourse(u2, r1, c1));
            urc.add(new UserRoleCourse(u2, r1, c2));
            userRoleCourseRepository.saveAll(urc);

            Task task1 = new Task("Øving 1");
            Task task2 = new Task("Øving 2");
            Task task3 = new Task("Øving 1");
            Task task4 = new Task("Øving 2");

            taskRepository.save(task1);
            taskRepository.save(task2);
            taskRepository.save(task3);
            taskRepository.save(task4);

            /*
            c1.addTask(task1);
            c1.addTask(task2);
            c2.addTask(task3);
            c2.addTask(task4);

            courseRepository.save(c1);
            courseRepository.save(c2);

            for (UserRoleCourse var:userRoleCourseRepository.findByRole(r2)) {
                var.getUser().approveTask(var.getCourse().getTasks().get(0));
                var.getUser().failTask(var.getCourse().getTasks().get(0));
            }

            userRepository.save(u2);

             */
        };
    }

    CommandLineRunner commandLineRunner(CourseRepository courseRepository, RoleRepository roleRepository,
                                        UserRepository userRepository, UserRoleCourseRepository userRoleCourseRepository,
                                        UserLevelRepository userLevelRepository){
        return args -> {
            int testSize = 10;

            userRoleCourseRepository.deleteAll();
            roleRepository.deleteAll();
            courseRepository.deleteAll();
            userLevelRepository.deleteAll();
            userRepository.deleteAll();


            List<QUser> ul = new ArrayList<QUser>();
            List<QRole> rl = new ArrayList<QRole>();
            List<QCourse> cl = new ArrayList<QCourse>();

            userLevelRepository.save(new UserLevel("admin"));
            userLevelRepository.save(new UserLevel("user"));

            QRole role1 = new QRole("Student");
            QRole role2 = new QRole("StudAss");
            QRole role3 = new QRole("Professor");

            UserLevel admin = userLevelRepository.getById(1L);

            rl.add(role1);
            rl.add(role2);
            rl.add(role3);

            QUser prof = new QUser("Professor", "password");
            //prof.setUserLevel(admin);

            ul.add(prof);

            for (int i = 0; i < testSize; i++) {
                ul.add(new QUser(i + ".User", "password"));
                cl.add(new QCourse(i + ".Course"));
            }

            courseRepository.saveAll(cl);
            roleRepository.saveAll(rl);
            userRepository.saveAll(ul);

            QUser profDB = userRepository.getById(1L);
            QRole profRoleDB = roleRepository.getById(3L);

            for (QCourse course:courseRepository.findAll()) {
                userRoleCourseRepository.save(new UserRoleCourse(profDB, profRoleDB, course));
            }

            ul = userRepository.findAll();
            cl = courseRepository.findAll();
            rl = roleRepository.findAll();



            /*
            String roles = "Roles: ";
            String courses = "Courses: ";
            String users = "Users: ";

            for (int i = 0; i < 10; i++) {
                if (i<3){
                    roles += rl.get(i).getRole() + ", ";
                }
                courses += cl.get(i).getCourseName() + ", ";
                users += ul.get(i+1).getUsername() + ", ";
            }

            System.out.println(roles + "\n" +  courses + "\n" + users + "\n");

             */

            List<UserRoleCourse> saveList = new ArrayList<>();


            for (int i = 0; i < testSize; i++) {
                try {
                    UserRoleCourse userRoleCourse1 = new UserRoleCourse(ul.get(i+1), rl.get(0), cl.get(i));
                    UserRoleCourse userRoleCourse2 = new UserRoleCourse(ul.get(10-i), rl.get(1), cl.get(9-i));
                    saveList.add(userRoleCourse1);
                    saveList.add(userRoleCourse2);

                }catch (Exception e){
                    System.out.println("error at " + i);
                }
            }
            userRoleCourseRepository.saveAll(saveList);

        };
    }
}
