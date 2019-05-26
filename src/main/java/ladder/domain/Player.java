package ladder.domain;

import java.util.Objects;

public class Player {
    private static final String ALL = "all";

    static final int MAX_NAME_LENGTH = 5;
    static final int MIN_NAME_LENGTH = 1;

    private final String name;

    Player(final String name) {
        validateNameIsAll(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameIsAll(String name) {
        if (name.toLowerCase().equals(ALL)) {
            throw new IllegalArgumentException("이름은 " + ALL + "일 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MIN_NAME_LENGTH + "자 이상 " + MAX_NAME_LENGTH + "자 이내여야 합니다.");
        }
    }

    boolean matchName(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}