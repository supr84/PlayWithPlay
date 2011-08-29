package models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="tenants")
public class Tenant {
	@Id
	private ObjectId id;
	private String tenantName;
	private Long tenantId;
	
	public ObjectId getId() {
		return id;
	}
	
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public Long getTenantId() {
		return tenantId;
	}
}
