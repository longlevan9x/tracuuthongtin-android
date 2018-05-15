package vn.com.dtsgroup.look_up_information_android.Class;

/*******************************
 *                             *
 * Created by: VinhLD 20180515 *
 *                             *
 *******************************/

public class Branch {
    private int id, id_group;
    private String name;

    public Branch(int id, int id_group, String name) {
        this.id = id;
        this.id_group = id_group;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
