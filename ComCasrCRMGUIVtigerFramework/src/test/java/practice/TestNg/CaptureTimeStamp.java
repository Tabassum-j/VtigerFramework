package practice.TestNg;

import java.util.Date;

public class CaptureTimeStamp {
	public static void main(String[] args) {
		
	
  String time=new Date().toString();
  System.out.println(time.replace(" ", "_").replace(":", "_"));
  
	}

}
