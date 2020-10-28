package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private CarDao carDao;

   @Transactional
   @Override
   public void add(User user) {
      if (user.getCar() != null) {
         carDao.add(user.getCar());
      }
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional//??(readOnly = true)
   @Override
   public List<User> userListByModelAndSeries(String model, int series) {
      return userDao.userListByModelAndSeries(model, series);
   }

   @Transactional
   @Override
   public void deleteUsers() {
      userDao.deleteUsers();
   }
}