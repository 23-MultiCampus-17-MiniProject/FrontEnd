package di_test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class TestDAO {
	
	@Autowired
	private TestVO vo;

	public TestVO getVo() {
		return vo;
	}


	
	public TestVO test(){
		System.out.println("TestVO : test() ");
		return vo;
	}
}
