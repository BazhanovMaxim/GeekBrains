package prev;

import java.util.HashMap;
import java.util.Map;

public class TelephoneCatalog implements Catalog {
    private Map<HumanTelephones, Human> telephoneCatalog;

    public TelephoneCatalog() {
        this.telephoneCatalog = new HashMap<>();
    }

    @Override
    public void add(Object number, Object surname) {
        telephoneCatalog.put((HumanTelephones) number, (Human) surname);
    }

    @Override
    public void get(Object surname) {
        for (Map.Entry<HumanTelephones, Human> map : telephoneCatalog.entrySet()) {
            if (map.getValue().toString().equals(surname)) System.out.println(String.format("Number of telephone: %s", map.getKey()));
        }
    }

    @Override
    public void print() {
        for (Map.Entry<HumanTelephones, Human> map : telephoneCatalog.entrySet()) {
            System.out.println(String.format("Person: %s, number of telephone: %s", map.getValue(), map.getKey()));
        }
    }
}
