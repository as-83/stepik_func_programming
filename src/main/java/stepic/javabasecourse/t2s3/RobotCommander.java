package stepic.javabasecourse.t2s3;

public class RobotCommander {
    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction direction = robot.getDirection();
        int x = robot.getX();
        int y = robot.getY();
        int currentDirection = direction.ordinal();
        if (x < toX) {
           while(currentDirection < Direction.RIGHT.ordinal()) {

           }
        }

        robot.stepForward();
    }
}


