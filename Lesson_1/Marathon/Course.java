package Lesson_1.Marathon;

public class Course {
    Obstacle [] massObstacle;
    public Course(Obstacle...massObstacle) {
        this.massObstacle=new Obstacle[massObstacle.length];
        for (int i=0;i<massObstacle.length;i++){
            this.massObstacle[i]=massObstacle[i];
        }
    }

    public void start(Team team){
        for (Competitor c:team.competitors) {
            for (Obstacle o:massObstacle) {
                o.doit(c);
                if (!c.isOnDistance()){
                    break;
                }
            }

        }
    }
}
