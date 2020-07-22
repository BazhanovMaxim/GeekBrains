package participants.inorganic.robot;

import participants.inorganic.Inorganic;

public abstract class Robot extends Inorganic{
    public Robot(String name, float maxRunOfParticipants, float maxJumpOfParticipants) {
        super(name, maxRunOfParticipants, maxJumpOfParticipants);
    }
}
