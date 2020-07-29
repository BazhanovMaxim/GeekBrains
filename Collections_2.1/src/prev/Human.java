package prev;

import java.util.Objects;

public class Human {
    private String surname;

    public Human(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname);
    }
}