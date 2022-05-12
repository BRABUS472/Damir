package draft.Box;

public class AdvancedBox extends Box implements BoxFillingInterface {
    private String color;
    private int density;

    //Конструктор клаасса AdvancedBox
    public AdvancedBox(int w, int h, int d, String color) {
        super(w,h,d);//вызов конструктора суперкласса и передача ему параметров
        this.color = color;
        this.density = 0;
    }
    //перегруженный конструктор класса AdvancedBox
    public AdvancedBox(Box box, String color){
        //передаем параметры через геттеры
        super(box.get_Width(),box.get_Height(), box.get_Depth());//вызов конструктора через объект box
        this.color = color;
        this.density = 0;
    }
    //вызов конструктора учитывающего его плотность
    public AdvancedBox(int w, int h, int d, int density){
        super(w,h,d);//вызов конструктора суперкласса и передача ему параметров
        this.color = "Default color";
        this.density = density;
    }

    public int get_mass(){//получить массу коробки
      if (this.density>0){
          //альтернативное использование слова super
          return super.get_Depth()*super.get_Height()*super.get_Width()*this.density;
      }
      else return 0;
    }

    @Override
    public void get_fill(){
        System.out.println("Коробка была наполнена");
    }
}

