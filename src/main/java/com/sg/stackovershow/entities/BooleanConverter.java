package com.sg.stackovershow.entities;

import javax.persistence.AttributeConverter;

public class BooleanConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		// TODO Auto-generated method stub
		return Boolean.TRUE.equals(attribute) ? "T" : "F";
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return "T".equals(dbData);
	}

}
