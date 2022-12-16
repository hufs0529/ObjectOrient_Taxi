# ObjectOrient_Taxi

![image](https://user-images.githubusercontent.com/81501114/208058351-13dc03ca-b773-4c9a-bfac-126f85b1dbb8.png)

---

### 어플 시작 화면 모습

![kakaotaxi](https://user-images.githubusercontent.com/81501114/208058465-5b070141-20c1-4b35-aa9c-40b2d4529f2a.png)
---
#### 1. 손님의 평점이 택시 기사에게 노출되며 택시 기사가 거절할 수 있다
![택시 호출과 기사의 승낙](https://user-images.githubusercontent.com/81501114/208058850-91bc774c-96a5-43ef-93ac-566427e45b27.png)
![택시 호출과 기사의 거절](https://user-images.githubusercontent.com/81501114/208058954-013ec8f1-6b50-4fbf-9288-e48d8990a45d.png)

```
	public static List<Driver> letDriverLocConverToInt() {
		
		HashMap<String, Integer> maps = TaxiManager.getInstance().getLocation();
		
		for(int i = 0; i < drivers.size(); i++) {
			String driver = drivers.get(i).getLocation();
			
			Iterator<Map.Entry<String, Integer>> entries = maps.entrySet().iterator();
			while(entries.hasNext()) {
				Map.Entry<String, Integer> entry = entries.next();
				
				if(driver == entry.getKey()) {
					//drivers.get(i).setLocation(entry.getValue());
					drivers.get(i).setLoc(entry.getValue());
				}
			}	
		}
		return drivers;
	}
	
public static Integer letCustomerLocConverToInt(Customer customer) {
		
		HashMap<String, Integer> maps = TaxiManager.getInstance().getLocation();
		
		for(int i = 0; i < customers.size(); i++) {
			String cust = customer.getLocation();
			
			Iterator<Map.Entry<String, Integer>> entries = maps.entrySet().iterator();
			while(entries.hasNext()) {
				Map.Entry<String, Integer> entry = entries.next();
				
				if(cust == entry.getKey()) {
					//drivers.get(i).setLocation(entry.getValue());
					return entry.getValue();
				}
			}	
		}
		return 0;
	}
```
##### 생성자에서 생성된 고객, 기사의 String 위치값은 고유한 Integer값으로 변환해준다
---

#### 2. 기사가 승낙시 고객이 위치한 장소로 이동한다

![고객에게 가는  택시](https://user-images.githubusercontent.com/81501114/208059164-f0d82f56-55ac-4069-bf44-d0b7f83e135c.png)

```
	public static boolean contrastAllowDistance(Customer customer) throws InterruptedException {
		drivers = letDriverLocConverToInt();
		
		int cusLoc = findCusLocation(customer);
		int desLoc = findCusDestination(customer);
		
		for(int i = 0; i < drivers.size(); i++) {
			int comeToCus = drivers.get(i).getAllowDistanceToCustomer();
			int moveToDes = drivers.get(i).getAllowDistanceToDestination();
			
			if ((comeToCus < Math.abs(drivers.get(i).getLoc() - cusLoc))
					&& (moveToDes < Math.abs(drivers.get(i).getLoc() - desLoc))){
				
				tmp = i;
				System.out.println("[Customer]");
				System.out.println(drivers.get(tmp).getName()+"님의 택시가 배차되었습니다 평점은 " + drivers.get(tmp).getRate());
				//permitRequestTaxi(drivers.get(tmp));
				System.out.println();
				Thread.sleep(1500);
				return true;
			}
		}
		System.out.println("조건에 부합한 운전자가 없습니다.");
		return false;
	}
```
##### 기사는 고객에게 이동 가능한 거리, 목적지 이동 가능한 거리가 있으며, 조건 충족시 고객과 매칭된다
```
int cusLoc = findCusLocation(customer);
int desLoc = findCusDestination(customer);
```
##### 조건이 충족되지 않을시 발생하는 메시지
![운전자 미스매칭](https://user-images.githubusercontent.com/81501114/208060308-e0d9f09f-de1e-4c63-a96b-c4618ee06187.png)



---
#### 3. 고객이 위치한 자리에서 고객의 목적지로 택시가 이동한다
![목적지로의 택시이동](https://user-images.githubusercontent.com/81501114/208060206-df2c1c48-43bc-4986-b935-4ddd70a3d743.png)

---
#### 4. 운행 종료 후

##### 고객의 잔고에 돈이 없을 때
![지불 불가 별점테러](https://user-images.githubusercontent.com/81501114/208060478-dc7d38e0-7436-4b59-a410-444e66259f6f.png)

##### 고객의 잔고에 돈이 있을 때
![결제완료](https://user-images.githubusercontent.com/81501114/208060679-5782bf0f-7433-41b3-8a13-30c71f9c031c.png)


