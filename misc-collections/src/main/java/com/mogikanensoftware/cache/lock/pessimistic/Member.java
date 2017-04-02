package com.mogikanensoftware.cache.lock.pessimistic;

import java.io.Serializable;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	private int field;

	public Member(int field) {
		super();
		this.field = field;
	}

	public int getField() {
		return field;
	}

	public void setField(int field) {
		this.field = field;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + field;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (field != other.field)
			return false;
		return true;
	}

}
