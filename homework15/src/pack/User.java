package pack;

public class User {
    private int id;
    private String name;
    private int age;
    private boolean activated;
    private String login;
    private String pass;
    private static int idCounter;

    {
        id = idCounter++;
    }

    public User() {
    }

    public User(String name, int age, boolean activated, String login, String pass) {
        this.name = name;
        this.age = age;
        this.activated = activated;
        this.login = login;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", activated=" + activated +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
