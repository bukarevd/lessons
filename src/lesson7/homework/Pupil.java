package lesson7.homework;

public class Pupil {
    private int id;
    private ExamResult examResult[];

    Pupil(int id) {
        this.id = id;
    }

    void setExams(String ex[], int marks[]){
        examResult = new ExamResult[ex.length];

        if(ex.length != marks.length) {
            System.out.println("Не верные данные");
        }else{
            for (int i = 0; i < ex.length; i++){
                examResult[i] = new ExamResult();
                examResult[i].setNameExam(ex[i]);
                examResult[i].setScore(marks[i]);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (ExamResult anExamResult : examResult) str.append(anExamResult.toString()).append("\n");
        return "Студент:" + id + "\n" + str;
    }

    class ExamResult{
         private String nameExam;
         private int score;
         private boolean resultExam;

        void setNameExam(String nameExam) {
            this.nameExam = nameExam;
        }

        void setScore(int score) {
            this.score = score;
        }


        boolean getResulExam(){
            if (score < 3) resultExam = false;
            else resultExam = true;
            return resultExam;
        }

        @Override
        public String toString() {
            return nameExam + (getResulExam() ? " сдал" : " не сдал");
        }
    }


}
