package lesson19.reflection.annotation;

public class ParseAnnotation {
    public static void main(String[] args) {
        User user = new User(User.Permission.ADMIN);
        Class<?> actionClass = DeleteAction.class;
        PermissionRequired permissionRequired = actionClass.getAnnotation(PermissionRequired.class);

        if (permissionRequired != null){
           if( user.getPermission().equals(permissionRequired.value())){
                System.out.println("Пользователю доступно удаление");
            }
        }
    }
}

//Написать рефлексивный toString
//Написать небольшой dependency injection framework
