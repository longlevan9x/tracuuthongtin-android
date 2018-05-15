package vn.com.dtsgroup.look_up_information_android.Class;

/*******************************
 *                             *
 * Created by: VinhLD 20180515 *
 *                             *
 *******************************/

public class BranchGroup {
    private int id, id_faculty;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(int id_faculty) {
        this.id_faculty = id_faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BranchGroup(int id, int id_faculty, String name) {
        this.id = id;
        this.id_faculty = id_faculty;
        this.name = name;
    }
}
