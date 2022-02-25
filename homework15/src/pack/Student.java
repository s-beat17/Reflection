package pack;

public class Student {
    private String surname;
    private String name;
    private int age;
    private String group;

    public Student(String surname, String name, int age, String group) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                '}';
    }
}
