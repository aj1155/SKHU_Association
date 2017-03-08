package me.skhu.util;

import java.io.UnsupportedEncodingException;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PaginationUser extends Pagination {

	int user_type;

	public int getUt(){
		return this.user_type;
	}

	public void setUt(int user_type){
		this.user_type=user_type;
	}

	@Override
	public String getQueryString() throws UnsupportedEncodingException{
		String s = super.getQueryString();
		return String.format("%s&ut=%d", s, user_type);
	}
}
