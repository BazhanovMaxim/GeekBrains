package prev;

import java.util.Objects;

public class HumanTelephones {
    private long humanTelephones;

    public HumanTelephones(long humanTelephones) {
        this.humanTelephones = humanTelephones;
    }

    @Override
    public String toString() {
        return String.valueOf(humanTelephones);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanTelephones that = (HumanTelephones) o;
        return humanTelephones == that.humanTelephones;
    }

    @Override
    public int hashCode() {
        return Objects.hash(humanTelephones);
    }
}
