package home_work_3_3;

import java.io.Serializable;


    class Students  implements Serializable {
        int id;
        String name;


        public Students(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void info() {
            System.out.println(id + " " + name);
        }
    }
