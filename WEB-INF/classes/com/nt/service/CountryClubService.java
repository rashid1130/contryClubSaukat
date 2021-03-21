package com.nt.service;

import com.saukat.bo.CountryClubBO;
import com.saukat.dao.CountryClubDAO;
import com.saukat.dto.CountryClubDTO;

public class CountryClubService {

	public String Calculate(CountryClubDTO dto) {
		String result=null;
		float discount=(dto.getHpddl()*10)/100;
		
		float totalAmount=dto.getHpddl()-discount;
		if(dto.getHpddl()==100000) {
			result="Silver";
			
		}else if (dto.getHpddl()==200000) {
			result="Gold";
		}else if (dto.getHpddl()==400000) {
			result="Platinum";
		}else {
			result="Dimond";
		}
		
		//prepare BO class object having persistent data
		CountryClubBO bo=new CountryClubBO();
		bo.setName(dto.getName());
		bo.setAddr(dto.getAddr());
		bo.setCountry(dto.getCountry());
		bo.setPackage_price(dto.getHpddl());
	    bo.setPackage_discount(discount);
	    bo.setTotal_amount(totalAmount);
	    bo.setHoliday_package(result);
	    
	    //use Dao
	    CountryClubDAO dao=new CountryClubDAO();
	    int count=dao.insert(bo);
	    if(count==0) {
	    	return "Registration Failed";
	    }else {
	    	return "Registration Succeded";
	    }
		
		
	
	}
}
