package myclass;

import com.abc.Add;
import com.abc.AddService;
import com.abc.Second;
import com.abc.SecondService;

public class DoAdd {

	public static void main(String[] args) {
		Add add  = new AddService().getAddPort();
		System.out.println(add.add(2, 3));
		
		Second s = new SecondService().getSecondPort();
		System.out.println(s.times(2, 3));
	}

}
