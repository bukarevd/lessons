package lesson13;

import java.util.Arrays;

public class EnumExample {
    public static void main(String[] args) {
        User user = new User(1, "Test", Role.ADMIN);
        System.out.println(user);
        Role guest = Role.GUEST;
        if (guest == Role.ADMIN);

        System.out.println(Arrays.toString(Role.values()));
        for (Role roles : Role.values())
            System.out.println(roles);
        String str = "USER";
        Role userRole = Role.valueOf(str);
        User user1 = new User(2, "Test2", userRole);
        System.out.println(userRole.ordinal());

    }
}
     class User{
        private int id;
        private String name;
        private Role role;

        public User(int id, String name, Role role) {
            this.id = id;
            this.name = name;
            this.role = role;
        }

         @Override
         public String toString() {
             return "User{" +
                     "id=" + id +
                     ", name='" + name + '\'' +
                     ", role=" + role +
                     '}';
         }
     }
    enum Role{
        ADMIN{
            public Role adminRole(){
                return ADMIN;
            }

        }, USER, GUEST;

        public Role someRole(){ //для всех перечислений
            return USER;
        }
    }

