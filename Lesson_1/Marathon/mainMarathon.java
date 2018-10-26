package Lesson_1.Marathon;

public class mainMarathon {
    public static void main(String[] args) {
        Team testTeam=new Team("testTeam",new Cat("Барсик",200,20,10),
                                                new Dog("Бобик",500,5,20),
                                                 new Human("Иван",1000,500,1),
                                                new Human("Марья",850,1000,2));

        Course testCourse=new Course(new Wall(2),new Cross(300),new Water(10));
        testCourse.start(testTeam);
        System.out.println("\nРезультаты:");
        testTeam.showResults();

        System.out.println("\nИтого, всю полосу препятствий преодолели:");
        testTeam.showVin();
    }
}
