package logging;
import org.apache.logging.log4j.*;

public class Loggindemo{
	private static Logger demoLogger= LogManager.getLogger(Loggindemo.class.getName());
	  
	  public static void main(String a[]) {
	    new Loggindemo();
	  }
	  
	  public Loggindemo() {
	    Clock c = new Clock(); 
	    
	    MinuteTimer s = new MinuteTimer();
	    HourTimer b = new HourTimer();
	    
	     
	    c.start(); 
	    s.start();
	    b.start();
	    
	  }
	  
	  
	  private static class MinuteTimer extends Thread {
	    
	    public void run() {
	      while(true) {
	        try {
	          Thread.sleep(60000);
	          demoLogger.info("This is info");
	          
	          
	        } catch(InterruptedException e) {
	          e.printStackTrace(); 
	        }
	      }
	    }
	  }
	  private static class HourTimer extends Thread {
		    
		    public void run() {
		      while(true) {
		        try {
		          Thread.sleep(600000);
		        
		          demoLogger.debug("This is debug");
		          
		          
		        } catch(InterruptedException e) {
		          e.printStackTrace(); 
		        }
		      }
		    }
		  }
	  
	  
	 
	  
	  
	  private static class Clock extends Thread {
	    private int sn=0, dk=0, saat=0;
	    
	   
	    private void timeIncrement() {
	      sn++;
	      if(sn/60 > 0) {
	        dk += sn/60;
	        sn %=60;
	      }
	      if(dk/60 > 0) {
	        saat += dk/60;
	        dk %= 60; 
	      }
	    }
	    
	    
	    public void run() {
	      while(true) { 
	        try {
	          Thread.sleep(1000); 
	          timeIncrement(); 
	          demoLogger.error("This is error"); 
	        } catch (InterruptedException e) {
	          e.printStackTrace(); 
	        }
	      }
	    }
	    
	    
	    public String toString() {
	      String a = (saat/10 == 0) ? "0" + saat : ""+saat;
	      a += ":" + ((dk/10 == 0) ? "0" + dk : ""+dk);
	      a += ":" + ((sn/10 == 0) ? "0" + sn : ""+sn);
	      return a;
	    }
	  }
	}