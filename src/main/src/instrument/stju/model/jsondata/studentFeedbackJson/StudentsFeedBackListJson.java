package instrument.stju.model.jsondata.studentFeedbackJson;

/**
 * Created by Administrator on 2017/2/23.
 */
public class StudentsFeedBackListJson {
    private int Topic_id;
    private String Content;
    private String Date;
    private String Name;

    public int getTopic_id() {
        return Topic_id;
    }

    public void setTopic_id(int topic_id) {
        Topic_id = topic_id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
