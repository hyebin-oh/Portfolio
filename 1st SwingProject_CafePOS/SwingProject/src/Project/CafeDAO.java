package Project;

import java.util.ArrayList;

import com.model.Friend;

public interface CafeDAO {
	
	
	//카드결제 버튼
	public void OrderCard(Cafe f);
	
	
	//현금결제 버튼
	public void OrderCash(Cafe f);
	
	
	//판매리스트 버튼
	public ArrayList<Cafe> SellList();
	
	
	//메뉴별 판매량 버튼
	public ArrayList<Cafe> SellMenu();
	

	
}
