package com.hsdc.dp.persist.dto.flyeweight;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.hsdc.dp.intf.dto.flyweight.CodeDto;

@Entity(name="CodeDtoImpl")
public class CodeDtoImpl implements CodeDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5275751776194772207L;
	
	@Id @Column(name="ID") private int id;
	@Column(name="CODEVALUE") private String codeValue;
	@Column(name="CODETEXT") private String codeText;

	public String getCodeValue() {
		return this.codeValue;
	}

	public String getCodeText() {
		return this.codeText;
	}

	@Override
	public String toString() {
		return "CodeDtoImpl [id=" + id + ", codeValue=" + codeValue + ", codeText=" + codeText + "]";
	}

}
