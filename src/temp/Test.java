package temp;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
		

		public static void main(String[] args) {
			
			ArrayList<Integer> MYXA = new ArrayList<Integer>();	//Здесь будут храниться цифры мухи
			ArrayList<Integer> SLON = new ArrayList<Integer>();//Здесь будут храниться цифры слона
			ArrayList<Integer> M = new ArrayList<Integer>();	//Здесь будут цифры
			ArrayList<Integer> Y = new ArrayList<Integer>();	//Здесь будут цифры
			ArrayList<Integer> X = new ArrayList<Integer>();	//Здесь будут цифры
			ArrayList<Integer> A = new ArrayList<Integer>();	//Здесь будут цифры
			ArrayList<Integer> REBUS = new ArrayList<Integer>();	//Здесь будут цифры
			//Integer muxaNum;
			for(int m=1; m<=4; m++){			//Заходим в цикл, нужно 4 раза повторить
				M.add(m);						//добавляем первую цифру в м	m=1
				MYXA.add(m);					//добавляем ее же в муху		M и МУХА состоят из 1 эелемента равному 1
				for(int y=0; y<10; y++){			//Заходим во второй цикл, повторить 10 раз
					if (y != m){					//если текущая цифра не равна предыдущей	m=1, y=0
						Y.add(y);					//добавляем ее в 
					MYXA.add(y);				//и добавляем ее в муху		M = {1}, Y={0} и МУХА = {1,0}
						for(int x=0; x<10; x++){			//начинаем 3 цикл, повторить 10 раз
							if (x != m & x != y){			//если текущая цифра не равна двум предыдущим
								X.add(x);					//добавляем ее в 		m=1,y=0,x=2
								MYXA.add(x);				//и добавляем ее в муху	M={1} Y={0} X={2} MYXA={1,0,2}
								for(int a=1; a<10; a++){			//начинаем последний цикл
									if (a != m & a != y & a != x){	//если текущая цифра не равна трем предыдущим
										A.add(a);					//добавляем ее в 		m=1, y=0, x=2, a=3
										MYXA.add(a);				//добавляем ее в муху	M={1} Y={0} X={2} A={3} MYXA={1,0,2,3}
										Integer myxaNum = MYXA.get(0)*1000+MYXA.get(1)*100+MYXA.get(2)*10+MYXA.get(3); //получаем число мухи (хотя можно воспользоваться текущими значениями цикла m,y,x,a)
										Integer slonNum = myxaNum*2;		//муху умножаем на два 				myxaNum=1023, slonNum=2046
										Integer S = slonNum/1000;			//получаем тысячную цифру слона		S=2
										SLON.add(S);						//помещаем в коллекцию слона		SLON={2}
										Integer L = slonNum/100%10;			//получаем сотую цифру слона		L=0
										SLON.add(L);						//помещаем в коллекцию слона		SLON={2,0}
										Integer O = slonNum/10%10;			//получаем десятую цифру слона		O=4
										SLON.add(O);						//помещаем ее в коллекцию слона		SLON={2,0,4}
										Integer N = slonNum%10;				//находим последнюю цифру слона		N=6
										SLON.add(N);						//помещаем ее в коллекцию слона		SLON={2,0,4,6}
										//Collections.addAll(REBUS, SLON);	//помещаем первую цифру слона в ребус		REBUS={2}, так как SLON[0] = 2
										System.out.println(myxaNum);			//выводим на консоль число мухи			1023
										System.out.println(slonNum);			//выводим на консоль число слона		2046
										System.out.println(SLON);				//выводим на консоль коллекцию слона	[2,0,4,6] Или вообще абра-кадабра
										System.out.println(REBUS);				//выводим на консоль коллекцию в ребусе		[2] Или вообще абра-кадабра
										break;									//выходим на всегда из цикла (мы не будем проходить 10 повторений)
										
									}
								}
							break;							//выходим на всегда из цикла (мы не будем проходить 10 повторений)
							}
						}
					break;							//выходим на всегда из цикла (мы не будем проходить 10 повторений)
					}			
				}
			break;						//выходим на всегда из цикла (мы не будем проходить 10 повторений)
			}
			
			System.out.println(MYXA);	//выводим число муха
			//По идее должно вывести [1,0,2,3] Или вообще абра-кадабра
		}
	
}
