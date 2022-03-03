package TD2;

public class Document {
    private int num;
    private String title;

    public Document(int num, String title) {
        this.num = num;
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Document{" +
                "num=" + num +
                ", title='" + title + '\'' +
                '}';
    }

    public boolean asAutor() {
        return false;
    }
}
