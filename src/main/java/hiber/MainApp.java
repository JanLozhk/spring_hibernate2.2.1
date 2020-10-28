package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("ModelX", 100500)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Model10", 10)));
      userService.add(new User("User32", "Lastname23", "user23@mail.ru", new Car("Model10", 10)));
      userService.add(new User("User12", "Lastname13", "user13@mail.ru", new Car("Model10", 101)));
      userService.add(new User("User42", "Lastname43", "user43@mail.ru", new Car("Model100", 10)));
      userService.add(new User("User52", "Lastname52", "user52@mail.ru", new Car("Model10", 10)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Model3", 3)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      //userService.listUsers().forEach(System.out::println);

      //System.out.println(userService.listUsers().toString());
      //userService.userListByModelAndSeries("Model10", 3);//isEmpty().forEach(System.out::println);

      List<User> listUsr = userService.userListByModelAndSeries("Model10", 10);
      System.out.println("User with the car:");
      if (!listUsr.isEmpty()) {
         for (User usr :
                 listUsr) {
            System.out.println(usr.getCar().getModel() + " " + usr.getFirstName()
                    + " " + usr.getLastName() + " " + usr.getEmail());
         }
      } else {
         System.out.println("there is no user with car");
      }
      userService.deleteUsers();
      carService.deleteCar();
  /*

      CarService carService = context.getBean(CarService.class);
*//*      carService.add(new Car("Model1", 12345));
      List<Car> cars = carService.listCar();
      System.out.println(cars.get(0));*//*
      carService.deleteCar();
*/
      context.close();
   }
}
