package com.kingdee.exam.voj.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 系统设置选项类.
 */

@Getter
@Setter
@Entity
@Table(name="voj_options")
public class Option implements Serializable {
	public Option() { }
	
	public Option(String optionName, String optionValue, boolean isAutoload) {
		this.optionName = optionName;
		this.optionValue = optionValue;
		this.isAutoload = isAutoload;
	}
	
	public Option(int optionId, String optionName, String optionValue, boolean isAutoload) {
		this(optionName, optionValue, isAutoload);
		this.optionId = optionId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int optionId;
	private String optionName;
	private String optionValue;
	private boolean isAutoload;

	@Transient
	private static final long serialVersionUID = -1533277464247886659L;
}
