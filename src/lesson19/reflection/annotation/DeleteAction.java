package lesson19.reflection.annotation;

@PermissionRequired(User.Permission.ADMIN)
public class DeleteAction {
    public void delete(User user){
        System.out.println("del user");
    }

}
