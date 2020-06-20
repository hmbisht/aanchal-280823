package com.simplified.aanchal.connectors.db;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.simplified.aanchal.common.constants.AppConstants;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = AppConstants.TABLE_NAME)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String code;

	@Column
	private String name;

	@Column
	private String gender;

	@Column(name = AppConstants.CREATED, updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date created;

	@Column(name = AppConstants.LAST_MODIFIED, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastModified;

	// Problem: created and last_modified columns were not updating itslelf. It was working in MySql 5.5 but not in Mysql 8.0
	// For some reasons I'm not able to set explicit_defaults_for_timestamp ON in Mysql 8.0
	// SET GLOBAL explicit_defaults_for_timestamp = 1;
	// SHOW GLOBAL VARIABLES LIKE '%timestamp%';
	// Thats why added explicit PrePersist and PreUpdate for timestamp
	// https://dev.mysql.com/doc/refman/8.0/en/server-system-variables.html#sysvar_explicit_defaults_for_timestamp

	@PrePersist
	protected void onCreate() {
		lastModified = created = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		lastModified = new Date();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
}
