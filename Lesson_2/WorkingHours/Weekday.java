package Lesson_2.WorkingHours;
    public enum Weekday {
        MONDAY("понедельник",8), TUESDAY("вторник",8), WEDNESDAY("среда",8), THURSDAY("четверг",8), FRIDAY("пятница",6), SATURDAY("суббота",0), SUNDAY("воскресенье",0);
        private String rusName;
        private int hours;

        public String getRusName() {
            return rusName;
        }

        public int getHours() {
            return hours;
        }

        Weekday(String rusName, int hours) {
            this.rusName = rusName;
            this.hours = hours;
        }
    }

