public class FinalCalc {

    public static void main(String[] args) {
        double hw = 80;
        double exams = 85;
        double target = 80;
        double final_score = 100.0* ((target-(20.0*(hw/100))-(60.0*(exams/100)))/20);

        System.out.println("Final Score Required is: " + final_score);
    }
}
