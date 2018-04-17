import java.math.BigInteger;

/**
 * Created by 平凡的世界 on 2018/4/16.
 */
public class Student {
    private int location;
    private BigInteger id;
    private int source;

    public Student(int n, String s) {
    }


    public Student(int location, BigInteger id, int source) {
        this.location = location;
        this.id = id;
        this.source = source;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Student{" +
                "location=" + location +
                ", id=" + id +
                ", source=" + source +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (location != student.location) return false;
        if (source != student.source) return false;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        int result = location;
        result = 31 * result + id.hashCode();
        result = 31 * result + source;
        return result;
    }
}
