package com.lab.riv.four;

public class FindLuckyTicket {

	public static void main(String[] args) {
		try{
			Long nonLucky = 734125L;
			String lucky = "099288";
			Ticket t = new Ticket(nonLucky);
			Ticket t1 = new Ticket(lucky);
			Ticket.eval(t, t1);
			System.out.println(t);
			t.eval(t.HARD);
			System.out.println(t);
			System.out.println(t1);
			for(long i=1; i<1000000;i++){
				t= new Ticket(i);
				t.eval(t.HARD);
				if(t.isLucky())
					System.out.println(t);
			}
			System.out.println("Конец");
		}catch(RuntimeException re){
			System.err.println("Невозможно определить состояние билета:\n" + re.getMessage());
		}
	}

	
}
