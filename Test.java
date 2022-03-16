import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Test {

    public static void main(String[] args) throws IOException {
        System.out.println("true");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Dmitr\\Desktop\\test\\src\\User"))) {

            List<User> users = new ArrayList<>();

            while (bufferedReader.ready()) {

                boolean isTrue = true;
                int count = 1;

                String lastName = null;
                String name = null;
                String age = null;

                while (isTrue) {
                    String el = bufferedReader.readLine();
                    switch (count) {
                        case 1 -> lastName = el;
                        case 2 -> name = el;
                        case 3 -> age = el;
                    }

                    if (count == 3) {
                        isTrue = false;

                    }
                    count++;

                }
                users.add(addList(new User(), lastName, name, age));
            }

            System.out.println(users);
            List<User> sortedListUsers = users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
            System.out.println(sortedListUsers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static User addList(User user, String lastName, String name, String age) {
        user.setLastName(lastName);
        user.setName(name);
        user.setAge(age);
        return user;
    }

}
