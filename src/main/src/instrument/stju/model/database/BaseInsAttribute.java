package instrument.stju.model.database;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseInsAttribute<M extends BaseInsAttribute<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setInsId(java.lang.Integer insId) {
		set("insId", insId);
	}

	public java.lang.Integer getInsId() {
		return get("insId");
	}

	public void setAttribute(java.lang.String attribute) {
		set("attribute", attribute);
	}

	public java.lang.String getAttribute() {
		return get("attribute");
	}

}
