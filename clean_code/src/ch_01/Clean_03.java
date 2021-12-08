package ch_01;

public class Clean_03 {

	// 함수를 만드는 첫쨰 규칙은 작게 만드는 것이다 !
	
	// 함수는 반드시 한가지를 하여야 한다. 그 한 가지를 잘 해야 한다. 그 한 가지 만을 하여야 한다.
	// Single Responsibility Principle
	
	// 코드는 위에서 아래로 이야기처럼 읽혀야 한다.
	
	// 한 함수 다음에는 추상화 수준이 한 단계 낮은 함수가 온다.
	// switch 문은 작게만들기 너무 어렵다. case 분기가 단 두개인 switch 문도 너무 길다.
	// 본질적으로 switch 문은 N 가지를 처리한다.
	// 이름을 붙일 때는 일관성이 있어야 한다.
	// 모듈 내에서 함수 이름은 같은 문구, 명사, 동사를 사용
//	public abstract class Employee {
//		public abstract boolean isPayday();
//		public abstract Money calcuatePay();
//		public abstract	void deliverPay(Money pay);
//	}
//	
//	public interface EmployeeFactory {
//		public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
//	}
//	
//	class EmployeeFactoryImpl implements EmployeeFactory {
//		public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType {
//			switch(r.type) P
//			case COMMISSIONED:
//				return new CommissionEmployee(r);
//			case HOURLY:
//				return new HourlyEmployee(r);
//			case SALARIDE :
//				return new SalariedEmployee(r);
//			default :
//				thorw new InvalidEmployeeType(r.type);
//		}
//	}
	
	
}
