package instrument.stju.model.jsondata.showInstrument;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangzhiwei on 16/10/28.
 */
public class InsArr {
    public List<String> typeList;
   private List<Insinfo> insArr;
    public InsArr(){
        insArr =new ArrayList<Insinfo>();
        typeList = new ArrayList<String>();
        typeList.add("����");
        typeList.add("С����");
        typeList.add("����˹");
        typeList.add("����");
//        String type = typeList.get(0);
    }
    public List<Insinfo> getInsArr() {
        return insArr;
    }

    public void setInsArr(List<Insinfo> insArr) {
        this.insArr = insArr;
    }


    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }
}
