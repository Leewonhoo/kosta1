package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EFridge {

	/*  Map<String,Item> 
	 * 1. 특징 - 자료구조 클래스의 일부
	 * 2. Map계열 - key, value(어플리케이션 상에서 실제 활용되는 데이타값)
	 * 				 쌍으로 데이타 관리	 * 
	 * 3. jdk1.5부터 추가된 문법
	 * 		- Map에 저장하는 데이타 타입 제한
	 *  	- 예: Map<String,Item>
	 *  	key명은 반드시 String이어야 한다
	 *      value 반드시 Item 타입어야 한다. 
	 *      
	 * *** 객체 지향 개념 장점- 재사용성, 
	 * 				Item 객체 하나만 뜯어보더라도
	 * 				이 객체가 보유한 데이타가 몇가지?  다중 타입 및
	 * 			 	다중 데이타 값들은 객체단위로 관리하면 활용 및 데이타 관리 
	 * 				자체가 명확해지고 좋다 */
	
    private static Map<String,Item> FAUX_DATABASE = new HashMap<String,Item>();
    /* 자바의 특화 + 매우 유용한 코드
     * 1. static 블록
     * 2. 실행 시점(개발자 코드상에서는 절대 호출 불가 문법)
     * 	- JVM(java virtual machine= 자바실행환경) 자체적으로 자동 호출
     *  - *** 언제 호출?
     *  	실행 코드가 메모리(JVM)에 로딩되는 시점에 무조건 단 한번 실행
     * 3. 권장 
     * 	- 모든 client들이 공유하면서 리소스 절하고자 할때 초기화 코드로 주로 활용   *    * 
     */
    static {
        FAUX_DATABASE.put( "1", new Item( "Milk", "HCF Milk, gallon", "dairy", "4/23/2010" ) );
        FAUX_DATABASE.put( "2", new Item( "Cole Slaw", "Hill Country Cole Slaw", "prepared", "4/29/2010" ) );
        FAUX_DATABASE.put( "3", new Item( "BBQ Sauce", "Stubb's BBQ Sauce, Spicy", "condiments", "4/23/2010" ) );
        FAUX_DATABASE.put( "4", new Item( "Lunch Meat", "Boar's Head Maple-glazed Turkey", "deli", "4/25/2010" ) );
        FAUX_DATABASE.put( "5", new Item( "Mustard", "Gulden's Spicy Brown Mustard", "condiments", "4/23/2010" ) );
        FAUX_DATABASE.put( "6", new Item( "Hot Sauce", "Sriracha Chile Sauce", "condiments", "12/5/2010" ) );
        FAUX_DATABASE.put( "7", new Item( "Cheese", "Tillamook Sharp Cheddar, 1 lb.", "dairy", "5/12/2010" ) );
        FAUX_DATABASE.put( "8", new Item( "Iced Tea", "Arizona Green tea, 1/2 gallon", "beverages", "4/23/2010" ) );
    }
    
    /* 특정 key값으로 해당 Item객체 반환 메소드    */
    public Item getItem( String key ) {
         return FAUX_DATABASE.get( key );
    }
    
}





