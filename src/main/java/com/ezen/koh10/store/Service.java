package com.ezen.koh10.store;

import java.util.ArrayList;

public interface Service {
	void insert(String place, String carname, int su, int price);
	
	public int total();
	
	public ArrayList<StoreDTO> page(PageDTO dto);

	public ArrayList<StoreDTO> placesell(PageDTO dto);

	public ArrayList<StoreDTO> carsell(PageDTO dto);
	
	public ArrayList<StoreDTO> maxsell(PageDTO dto);
	
	public ArrayList<StoreDTO> storepageasc(PageDTO dto);
	
}
