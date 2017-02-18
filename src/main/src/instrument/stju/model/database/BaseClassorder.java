package instrument.stju.model.database;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseClassorder<M extends BaseClassorder<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setUserId(java.lang.Integer userId) {
		set("userId", userId);
	}

	public java.lang.Integer getUserId() {
		return get("userId");
	}

	public void setClassId(java.lang.Integer classId) {
		set("classId", classId);
	}

	public java.lang.Integer getClassId() {
		return get("classId");
	}

	public void setOrdernum(java.lang.Integer ordernum) {
		set("ordernum", ordernum);
	}

	public java.lang.Integer getOrdernum() {
		return get("ordernum");
	}

	public void setTel(java.lang.String tel) {
		set("tel", tel);
	}

	public java.lang.String getTel() {
		return get("tel");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setPrice(java.lang.Double price) {
		set("price", price);
	}

	public java.lang.Double getPrice() {
		return get("price");
	}

	public void setMethod(java.lang.Integer method) {
		set("method", method);
	}

	public java.lang.Integer getMethod() {
		return get("method");
	}

	public void setDate(java.lang.String date) {
		set("date", date);
	}

	public java.lang.String getDate() {
		return get("date");
	}

	public void setSituation(java.lang.Integer situation) {
		set("situation", situation);
	}

	public java.lang.Integer getSituation() {
		return get("situation");
	}

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}

	public java.lang.String getRemark() {
		return get("remark");
	}

}
