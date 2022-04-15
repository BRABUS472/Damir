package draft;

public class infoString {
    /*
    создание строк
String s1 = "Java";
String s2 = new String("Home");
String s3 = new String(new char[]{'A', 'B', 'C'});
String s4 = new String(s3);
String s5 = new String(new byte[]{65, 66, 67});
String s6 = new String(new byte[]{0, 65, 0, 66}, StandardCharsets.UTF_16);
System.out.printf("s1 = %s, s2 = %s, s3 = %s, s4 = %s, s5 = %s, s6 = %s", s1, s2, s3, s4, s5, s6);
Результат:
s1 = Java, s2 = Home, s3 = ABC, s4 = ABC, s5 = ABC, s6 = AB

int length()                              Получение длины строки
char charAt(int pos)                      Извлечение из строки символа, находящегося на позиции pos,
                                          индексация символов начинается с нуля
char[] toCharArray()                      Преобразование строки в массив символов
boolean equals(Object obj)                Посимвольное сравнение строк
boolean equalsIgnoreCase(Object obj)      Сравнение строк без учета регистра
Strinq concat(String obj)                 Объединение двух строк в одну. Этот метод создает новый строковый
                                          объект, содержащий вызываемую строку, в конце которой добавляется
                                          содержимое параметра строка. Метод выполняет то же действие, что и операция +.
String toLowerCase(),                     Преобразование всех символов строки из верхнего регистра в нижний,
String toUpperCase()                      из нижнего регистра в верхний

Методы для работы с StringBuilder и StringBuffer

int length()                                  Получение длины строки
nt capacity()                                 Получение объема выделенной памяти
void ensureCapacity(int minimumCapacity)      Предварительное выделение места для определенного количества
                                              символов после создания объекта типа StringBuffer, чтобы установить
                                              емкость буфера. Это удобно, если заранее известно, что к объекту
                                              типа StringBuffer предполагается присоединить большое количество
                                              мелких символьных строк.
void setLength(int length)                    Установка длины строки. Если указанная длина больше текущей, то в
                                              конце строки добавляются пустые символы, если меньше - символы,
                                              оказавшиеся за пределами вновь заданной длины строки, удаляются
void append(...)                              Присоединение любого типа данных в конце вызывающего объекта

Конкатенация строк
соединение строк
String a1 = "Hello ";
String a2 = "World";
String a3 = a1 + a2;
System.out.println(a3);
String b1 = "Число 10: ";
int b2 = 10;
String b3 = b1 + b2;
System.out.println(b3);
String c1 = "Home";
String c2 = "[" + c1 + "] = " + 1;
System.out.println(c2);

Результат:
Hello World
Число 10: 10
[Home] = 1

String str = "Десять: " + 5 + 5;
System.out.println(str);
Результат:
Десять: 55

String str = "Десять: " + (5 + 5);
System.out.println(str);
Результат:
Десять: 10
     */
}
