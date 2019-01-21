import java.util.ArrayList;

public class Beer {
    private ArrayList<Data> data;

    public Beer() {
        this.data = new ArrayList<>();
    }

    ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    /**
     * Overriding toString to call toString on every Data instance which the ArrayList contains.
     * @return a String which contains every information of the Data instances.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Data d : data) {
            sb.append(d.toString());
        }
        return String.valueOf(sb);
    }
}
