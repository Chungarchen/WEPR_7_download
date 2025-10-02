package murach.data;

import java.io.*;
import murach.business.User;

public class UserIO {
    public static void add(User user, String filepath) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filepath, true))) {
            out.println(user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String email, String filepath) {
        try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts[0].equalsIgnoreCase(email)) {
                    return new User(parts[0], parts[1], parts[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
