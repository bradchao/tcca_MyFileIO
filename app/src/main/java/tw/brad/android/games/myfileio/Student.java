package tw.brad.android.games.myfileio;

public class Student {
    int ch, math, eng;
    public Student(int ch, int math, int eng){
        this.ch = ch;
        this.math = math;
        this.eng = eng;
    }
    public double sum(){
        return ch+math+eng;
    }
    public double avg(){
        return sum() / 3.0;
    }
}
