package member;

//스프링 BEAN = POJO
public class MemberDTO {
	//회원 정보 - members 아이디,암호,이름,이메일,폰
		String memberid; // html name="memeberid" -name속성값과 변수명, db 테이블 컬럼명을 똑같이 맞춰주자 memberid
		String pw;
		String membername;
		String phone;
		String email;
		String regdate; //날짜가 가장 다루기 까다로움 db마다 형식이 다 다름
		
		public MemberDTO() {
			System.out.println("기본생성자 호출");
		}
		
		public MemberDTO(String memberid, String membername, String phone, String email) {
			super();
			this.memberid = memberid;
			this.membername = membername;
			this.phone = phone;
			this.email = email;
		}
		
		public MemberDTO(String memberid, String pw, String membername, String phone, String email, String regdate) {
			super();
			this.memberid = memberid;
			this.pw = pw;
			this.membername = membername;
			this.phone = phone;
			this.email = email;
			this.regdate = regdate;
		}
		
		public String getMemberid() {
			return memberid;
		}
		public void setMemberid(String memberid) {
			this.memberid = memberid;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String getMembername() {
			return membername;
		}
		public void setMembername(String membername) {
			this.membername = membername;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getRegdate() {
			return regdate;
		}
		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}
		
}