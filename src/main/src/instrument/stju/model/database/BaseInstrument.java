package instrument.stju.model.database;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseInstrument<M extends BaseInstrument<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setPrePrice(java.lang.Integer prePrice) {
		set("prePrice", prePrice);
	}

	public java.lang.Integer getPrePrice() {
		return get("prePrice");
	}

	public void setNowPrice(java.lang.Integer nowPrice) {
		set("nowPrice", nowPrice);
	}

	public java.lang.Integer getNowPrice() {
		return get("nowPrice");
	}

	public void setFreight(java.lang.Double freight) {
		set("freight", freight);
	}

	public java.lang.Double getFreight() {
		return get("freight");
	}

	public void setLocation(java.lang.String location) {
		set("location", location);
	}

	public java.lang.String getLocation() {
		return get("location");
	}

	public void setDescription(java.lang.String description) {
		set("description", description);
	}

	public java.lang.String getDescription() {
		return get("description");
	}

	public void setParameter(java.lang.String parameter) {
		set("parameter", parameter);
	}

	public java.lang.String getParameter() {
		return get("parameter");
	}

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}

	public java.lang.String getRemark() {
		return get("remark");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
	}

}
