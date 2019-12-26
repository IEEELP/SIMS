package domain;
/*
课程实体类
 */
public class Course {
    private int id;         //主键id
    private String name;    //课程名
    private int cridit;     //学分值
    private int check;      //考核方式 0考查 1考试
    private String checakStr;

    public String getChecakStr() {
        if (check==0){
            checakStr="考查";
        }else {
            checakStr="考试";
        }
        return checakStr;
    }

    public void setChecakStr(String checakStr) {
        this.checakStr = checakStr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCridit() {
        return cridit;
    }

    public void setCridit(int cridit) {
        this.cridit = cridit;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public Course(int id, String name, int cridit, int check, String checakStr) {
        this.id = id;
        this.name = name;
        this.cridit = cridit;
        this.check = check;
        this.checakStr = checakStr;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cridit=" + cridit +
                ", check=" + check +
                ", checakStr='" + checakStr + '\'' +
                '}';
    }
}
