package oso.ntnu.idatt2015.backend.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import oso.ntnu.idatt2015.backend.model.QCourse;
import oso.ntnu.idatt2015.backend.model.User.QRole;
import oso.ntnu.idatt2015.backend.model.User.QUser;
import oso.ntnu.idatt2015.backend.model.User.UserRoleCourse;
import oso.ntnu.idatt2015.backend.repository.CourseRepository;
import oso.ntnu.idatt2015.backend.repository.RoleRepository;
import oso.ntnu.idatt2015.backend.repository.UserRepository;
import oso.ntnu.idatt2015.backend.repository.UserRoleCourseRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TestConfig {
    @Bean
    CommandLineRunner commandLineRunner(CourseRepository courseRepository, RoleRepository roleRepository,
                                        UserRepository userRepository, UserRoleCourseRepository userRoleCourseRepository){
        return args -> {
            int testSize = 10;

            List<QUser> ul = new ArrayList<QUser>();
            List<QRole> rl = new ArrayList<QRole>();
            List<QCourse> cl = new ArrayList<QCourse>();

            QRole role1 = new QRole("Student");
            QRole role2 = new QRole("StudAss");
            QRole role3 = new QRole("Professor");

            rl.add(role1);
            rl.add(role2);
            rl.add(role3);

            QUser prof = new QUser("Professor", "password");

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
