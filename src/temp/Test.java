package temp;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
		

		public static void main(String[] args) {
			
			ArrayList<Integer> MYXA = new ArrayList<Integer>();	//����� ����� ��������� ����� ����
			ArrayList<Integer> SLON = new ArrayList<Integer>();//����� ����� ��������� ����� �����
			ArrayList<Integer> M = new ArrayList<Integer>();	//����� ����� �����
			ArrayList<Integer> Y = new ArrayList<Integer>();	//����� ����� �����
			ArrayList<Integer> X = new ArrayList<Integer>();	//����� ����� �����
			ArrayList<Integer> A = new ArrayList<Integer>();	//����� ����� �����
			ArrayList<Integer> REBUS = new ArrayList<Integer>();	//����� ����� �����
			//Integer muxaNum;
			for(int m=1; m<=4; m++){			//������� � ����, ����� 4 ���� ���������
				M.add(m);						//��������� ������ ����� � �	m=1
				MYXA.add(m);					//��������� �� �� � ����		M � ���� ������� �� 1 ��������� ������� 1
				for(int y=0; y<10; y++){			//������� �� ������ ����, ��������� 10 ���
					if (y != m){					//���� ������� ����� �� ����� ����������	m=1, y=0
						Y.add(y);					//��������� �� � 
					MYXA.add(y);				//� ��������� �� � ����		M = {1}, Y={0} � ���� = {1,0}
						for(int x=0; x<10; x++){			//�������� 3 ����, ��������� 10 ���
							if (x != m & x != y){			//���� ������� ����� �� ����� ���� ����������
								X.add(x);					//��������� �� � 		m=1,y=0,x=2
								MYXA.add(x);				//� ��������� �� � ����	M={1} Y={0} X={2} MYXA={1,0,2}
								for(int a=1; a<10; a++){			//�������� ��������� ����
									if (a != m & a != y & a != x){	//���� ������� ����� �� ����� ���� ����������
										A.add(a);					//��������� �� � 		m=1, y=0, x=2, a=3
										MYXA.add(a);				//��������� �� � ����	M={1} Y={0} X={2} A={3} MYXA={1,0,2,3}
										Integer myxaNum = MYXA.get(0)*1000+MYXA.get(1)*100+MYXA.get(2)*10+MYXA.get(3); //�������� ����� ���� (���� ����� ��������������� �������� ���������� ����� m,y,x,a)
										Integer slonNum = myxaNum*2;		//���� �������� �� ��� 				myxaNum=1023, slonNum=2046
										Integer S = slonNum/1000;			//�������� �������� ����� �����		S=2
										SLON.add(S);						//�������� � ��������� �����		SLON={2}
										Integer L = slonNum/100%10;			//�������� ����� ����� �����		L=0
										SLON.add(L);						//�������� � ��������� �����		SLON={2,0}
										Integer O = slonNum/10%10;			//�������� ������� ����� �����		O=4
										SLON.add(O);						//�������� �� � ��������� �����		SLON={2,0,4}
										Integer N = slonNum%10;				//������� ��������� ����� �����		N=6
										SLON.add(N);						//�������� �� � ��������� �����		SLON={2,0,4,6}
										//Collections.addAll(REBUS, SLON);	//�������� ������ ����� ����� � �����		REBUS={2}, ��� ��� SLON[0] = 2
										System.out.println(myxaNum);			//������� �� ������� ����� ����			1023
										System.out.println(slonNum);			//������� �� ������� ����� �����		2046
										System.out.println(SLON);				//������� �� ������� ��������� �����	[2,0,4,6] ��� ������ ����-�������
										System.out.println(REBUS);				//������� �� ������� ��������� � ������		[2] ��� ������ ����-�������
										break;									//������� �� ������ �� ����� (�� �� ����� ��������� 10 ����������)
										
									}
								}
							break;							//������� �� ������ �� ����� (�� �� ����� ��������� 10 ����������)
							}
						}
					break;							//������� �� ������ �� ����� (�� �� ����� ��������� 10 ����������)
					}			
				}
			break;						//������� �� ������ �� ����� (�� �� ����� ��������� 10 ����������)
			}
			
			System.out.println(MYXA);	//������� ����� ����
			//�� ���� ������ ������� [1,0,2,3] ��� ������ ����-�������
		}
	
}
