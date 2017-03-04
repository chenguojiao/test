package instrument.stju.model.jsondata.instrumentDetailJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
public class InstrumentDetailJson {

    private int Instrument_id;
    private String Instrument_name;
    private int Instrument_pre_price;
    private int Instrument_now_price;
    private double Freight;
    private String Instrument_location;
    private List<ProductInfoJson> Product;
    private String Description;
    private List<PicUrlInfoJson> Pic_url;

    public InstrumentDetailJson() {
        Product = new ArrayList<ProductInfoJson>();
        Pic_url = new ArrayList<PicUrlInfoJson>();
    }

    public int getInstrument_id() {
        return Instrument_id;
    }

    public void setInstrument_id(int instrument_id) {
        Instrument_id = instrument_id;
    }

    public String getInstrument_name() {
        return Instrument_name;
    }

    public void setInstrument_name(String instrument_name) {
        Instrument_name = instrument_name;
    }

    public int getInstrument_pre_price() {
        return Instrument_pre_price;
    }

    public void setInstrument_pre_price(int instrument_pre_price) {
        Instrument_pre_price = instrument_pre_price;
    }

    public int getInstrument_now_price() {
        return Instrument_now_price;
    }

    public void setInstrument_now_price(int instrument_now_price) {
        Instrument_now_price = instrument_now_price;
    }

    public double getFreight() {
        return Freight;
    }

    public void setFreight(double freight) {
        Freight = freight;
    }

    public String getInstrument_location() {
        return Instrument_location;
    }

    public void setInstrument_location(String instrument_location) {
        Instrument_location = instrument_location;
    }

    public List<ProductInfoJson> getProduct() {
        return Product;
    }

    public void setProduct(List<ProductInfoJson> product) {
        Product = product;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<PicUrlInfoJson> getPic_url() {
        return Pic_url;
    }

    public void setPic_url(List<PicUrlInfoJson> pic_url) {
        Pic_url = pic_url;
    }

}
