import company.dao.UserDao;
import company.gender.Gender;
import company.model.User;
import company.service.UserService;
import company.service.impl.MyException;
import company.service.impl.ServiceImpl;

public class Main {
    public static void main(String[] args) {

            User user1 = new User(1, 25, "Mukabyl", Gender.MALE);
            User user2 = new User(2, 23, "Asan", Gender.MALE);
            User user3 = new User(3, 29, "Gulnur", Gender.FEMALE);

            ServiceImpl service = new ServiceImpl();
            service.addUser(user1);
            service.addUser(user2);
            service.addUser(user3);
            service.getAllUser();

           try{
                   service.findById(3);
           }catch (MyException e){
                   System.out.println(e.getMessage());
           }
           try{
                   service.deleteId(5);
           }
           catch (MyException e){
                   System.out.println(e.getMessage());
           }



    }
}