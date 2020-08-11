package server;

import java.util.HashSet;
import java.util.Set;

public class BasicAuthService implements AuthService {
    private final Set<Record> records;

    public BasicAuthService() {
        records = new HashSet<>();
        records.add(new Record(1L, "Maxim", "bazhanov.login", "BAZH"));
        records.add(new Record(2L, "Anton", "anton.login", "ANTON"));
        records.add(new Record(3L, "Gerald", "gerald.login", "GERALD"));
    }

    @Override
    public Record findRecord(String login, String password) {
        for (Record record : records) {
            if (record.getLogin().equals(login) && record.getPassword().equals(password)) {
                return record;
            }
        }
        return null;
    }
}