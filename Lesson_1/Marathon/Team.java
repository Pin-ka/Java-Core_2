package Lesson_1.Marathon;

public class Team {
    String title;
    Competitor[] competitors;


    public Team(String title, Competitor...competitors) {
        this.title = title;
        this.competitors=new Competitor[competitors.length];
        for (int i=0;i<competitors.length;i++){
            this.competitors[i]=competitors[i];
        }
    }

    public void showVin(){
        for (Competitor c:competitors) {
            if(c.isOnDistance()){c.info();}
        }
    }

    public void showResults(){
        for (Competitor c:competitors) {
            c.info();
        }
    }

}
