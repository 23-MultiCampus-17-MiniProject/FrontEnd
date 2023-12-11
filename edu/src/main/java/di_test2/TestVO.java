package di_test2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("vo")
public class TestVO {
	private String member1;
	private String member2;
	public String getMember1() {
		return member1;
	}
	public void setMember1(String member1) {
		this.member1 = member1;
	}
	public String getMember2() {
		return member2;
	}
	public void setMember2(String member2) {
		this.member2 = member2;
	}
}
