package draft.Box;

public class Classes {
    //работа с перечислением
    public enum Flat_Figures{Circle, Triangle, Square, Polygon};

    public static void main(String[] args) {

        Flat_Figures ff = Flat_Figures.Triangle;

        if(ff==Flat_Figures.Triangle) {
            System.out.println("Это треугольник");
        }

        Box box = new Box(2,3,4);

        int volume = box.get_volume();
        int surface_area = box.get_surface_area();

        box.set_Width(5);
        box.set_Height(5);
        box.set_Depth(5);

        System.out.println("Объем коробки равен: "+volume);

        //меняем велимчину коробки
        box.set_Width(7);
        box.set_Height(7);
        box.set_Depth(7);

        volume = box.get_volume();
        surface_area = box.get_surface_area();
        System.out.println("Объем коробки равен: "+volume);
    }
}
