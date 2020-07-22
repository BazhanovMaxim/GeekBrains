package participants.organic.person;

import participants.organic.Organic;

public abstract class Person extends Organic {
    public Person(String name, float maxRunOfParticipants, float maxJumpOfParticipants) {
        super(name, maxRunOfParticipants, maxJumpOfParticipants);
    }
}
