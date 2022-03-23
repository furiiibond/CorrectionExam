public class Pomme {
    private String color;
    private int size;
    private int weight;

    public Pomme(String color, int size, int weight) {
        this.color = color;
        this.size = size;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pomme{" +
                "color='" + color + '\'' +
                ", size=" + size +
                ", weight=" + weight +
                '}';
    }
}
