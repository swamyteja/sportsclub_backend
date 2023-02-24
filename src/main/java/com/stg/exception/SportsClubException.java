package com.stg.exception;

public class SportsClubException extends RuntimeException {
	private String errorMsg;

	public SportsClubException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.errorMsg;
	}

	

}
