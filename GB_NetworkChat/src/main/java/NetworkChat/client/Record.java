package NetworkChat.client;

import java.util.Objects;

public class Record {
    private final long id;
    private final String name;
    private final String login;
    private final String password;

    public Record(long id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return id == record.id &&
                Objects.equals(name, record.name) &&
                Objects.equals(login, record.login) &&
                Objects.equals(password, record.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, password);
    }
}
