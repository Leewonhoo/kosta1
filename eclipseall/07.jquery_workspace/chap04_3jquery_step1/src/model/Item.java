/* 
 * <jsp:useBean > 태그를 사용하기 위한 JavaBeanComponent 설계 규칙
 *  
 * 1. package 선언
 * 2. private 멤버변수 선언
 * 3. public setter() / getter() 선언
 * 		3-1) setter 메서드 형식
 * 				+ setXxx(xxx타입):void 
 * 		3-2) getter 메서드 형식
 * 				+ getXxx():xxx타입
 * 		3-3) valid 검증 메서드 형식
 * 				- isXxx(xxx타입):false
 * 				- setter() 메서드 검증규칙시 호출사용
 * 	4. no argument 생성자 (기본생성자) 선언
 *  5. setter() / getter() 짝을 이루어야함 
 *  	- <jsp:setProperty>
 *  	- <jsp:getProperty>
 *  
 *  6. Domain 클래스 & JavaBean Component로 사용가능
 */
package model;  // 1.

public class Item {

	private String name;  // 2.
	private String description;
	private String category;
	private String expires;	
	
	public Item() {	// 4.
		super();
	}

	public Item(String name, String description, String category, String expires) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.expires = expires;
	}

	public String getName() {	// 3.
		return this.name;
	}

	public String getDescription() {	
		return this.description;
	}

	public String getCategory() {
		return this.category;
	}

	public String getExpires() {
		return this.expires;
	}
}
