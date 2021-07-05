package participants;

import prev.Behavior;

public abstract class Participants implements Behavior {
    protected String name;
    protected float maxRunOfParticipants;
    protected float maxJumpOfParticipants;

    public Participants(String name, float maxRunOfParticipants, float maxJumpOfParticipants) {
        this.name = name;
        this.maxRunOfParticipants = maxRunOfParticipants;
        this.maxJumpOfParticipants = maxJumpOfParticipants;
    }

    @Override
    public boolean run(float lengthOfTreadmill) {
        if (maxRunOfParticipants < lengthOfTreadmill) {
            System.out.println(String.format("Участник[%s] не смог пробежать дистанцию и " +
                    "не сможет принимать участие далее", name));
            return false;
        } else {
            System.out.println(String.format("Участник[%s] смог пробежать дистанцию", name));
            return true;
        }
    }

    @Override
    public boolean jump(float heightOfWall) {
        if (maxJumpOfParticipants < heightOfWall) {
            System.out.println(String.format("Участник[%s] не смог перепрыгнуть стену и " +
                    "не сможет принимать участие далее", name));
            return false;
        } else {
            System.out.println(String.format("Участник[%s] смог перепрыгнуть стену", name));
            return true;
        }
    }
}
