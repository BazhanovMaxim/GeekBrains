package participants.organic.animal;

import participants.organic.Organic;

public abstract class Animal extends Organic {
    public Animal(String name, float maxRunOfParticipants, float maxJumpOfParticipants) {
        super(name, maxRunOfParticipants, maxJumpOfParticipants);
    }
}
