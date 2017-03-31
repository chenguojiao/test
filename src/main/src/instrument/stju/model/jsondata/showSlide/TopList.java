package instrument.stju.model.jsondata.showSlide;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TopList implements Serializable {
    private List<Top_image> top;

    public List<Top_image> getTop() {
        top = new ArrayList<Top_image>();
        return top;
    }


}
