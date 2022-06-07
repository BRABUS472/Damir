package draft.J2Lesson2;

public class Collatz {
  private  int steps = 0;

   public void get_collatz_sequence(int number, int steps_limit) throws OverStepException //выбрасываем исключение
   {
        System.out.println("number is:" + number + " on step" + (this.steps + 1));

        this.steps++;//увеличение шагов расчета
        if (this.steps > steps_limit) throw new OverStepException("Overstep_exception_occurred_on_step_" + this.steps);//throw-выбросить исключение созданием обекта

        if (number == 1) return;
        if (number % 2 == 0) get_collatz_sequence(number / 2, steps_limit);
        if (number % 2 != 0) get_collatz_sequence(number * 3 + 1, steps_limit);
    }

}
