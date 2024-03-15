package in.ayush.service;

import in.ayush.binding.DashboardResponse;
import in.ayush.entity.Counsellor;

public interface CounsellorService {
	
	public String saveCounsellor(Counsellor c);
	 
	public Counsellor loginCheck(String email, String pwd);

	public boolean recoverPwd(String email);

	public DashboardResponse getDashboardInfo(Integer cid);


}
