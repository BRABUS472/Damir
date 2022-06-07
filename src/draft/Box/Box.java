package draft.Box;

public class Box {
    //поля класса
    private int width;
    private int height;
    private int depth;

    //конструктор класса
    public Box(int w, int h, int d)
    {
        this.width = w;
        this.height = h;
        this.depth = d;
    }

    //Обеспечени безопасного  доступа к полям класса
    //get - получение доступа
    public int get_Width()
    {
      return this.width;
    }
    //set - установить
  public void  set_Width(int width)
  {
      this.width = width;
  }

    public int get_Height()
    {
        return this.height;
    }
    //set - установить
    public void  set_Height(int height)
    {
        this.height = height;
    }

    public int get_Depth()
    {
        return this.depth;
    }
    //set - установить
    public void  set_Depth(int depth)
    {
        this.depth = depth;
    }

    //первый вариант метода возвращающего объем параллелипипеда
    public int get_volume(){
        //this-ссылка на объект, содержащий метод
        return this.width*this.height*this.depth;
    }

    public int get_surface_area(){
        return 2*(this.width*this.height+this.width*this.depth+this.height*this.depth);
    }
    //статический вариант метода, возвращаемого объем параллепипеда
    public static int get_volume(int a, int b, int c){
        return a*b*c;
    }
    //площадь поверхности паралепипеда как статический метод
    public static int get_surface_area(int a,int b,int c){
        return 2*(a*b+a*c+b*c);
    }
}

