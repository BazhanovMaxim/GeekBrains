import obstacle.Obstacle;
import obstacle.Treadmill;
import obstacle.Wall;
import participants.organic.animal.Cat;
import participants.organic.animal.Dog;
import prev.Behavior;
import participants.organic.person.Man;
import participants.organic.person.Woman;
import participants.inorganic.robot.MilitaryRobot;

public class Main {

    public static void main(String[] args) {
        firstTask();
    }

    public static void firstTask() {
        Behavior[] behaviors = {new Man("Bob", 10, 2.5f),
                new Woman("Alica", 9, 1.5f),
                new Cat("Vania", 4, 3f),
                new Dog("Ram", 10, 1.5f),
                new MilitaryRobot("R2D2", 6, 1f)};

        // Без массива препятствий
        //Wall wall = new Wall(2.5f);
        //Treadmill treadmill = new Treadmill(7f);
        //for (Behavior move : behaviors) {
        //    if (!move.run(treadmill.getLength())) continue;
        //    move.jump(wall.getHeight());
        //}

        Obstacle[] obstacles = {
                new Wall(1.5f),
                new Treadmill(6f)
        };

        for (Behavior move : behaviors) {
            for (Obstacle obstacle : obstacles) {
                if (obstacle instanceof Treadmill) {
                    if (!move.run(obstacle.getLength())) continue;
                }
                if (obstacle instanceof Wall) {
                    move.jump(obstacle.getHeight());
                }
            }
        }
    }
}
