package friendPac;

import java.util.ArrayList;

public interface FriendDBA {
	//추가
	//보기
	//검색
	
	public void friendInsert(Friend f);
	public ArrayList<Friend> friendView();
	public ArrayList<Friend> friendSearch(String str, int idx);
	public void friendUpdate(Friend f, int num);
	public void friendDelete(int num);
	public Friend friendSelect(int num);

}
