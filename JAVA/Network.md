# 네트워크 (Network)

서버는 서비스를 **제공하는** 프로그램으로 클라이언트의 연결을 수락하고 요청 내용을 처리 후 응답을 보내는 역할을 합니다.

클라이언트는 서비스를 **받는** 프로그램으로 네트워크 데이터를 필요로 하는 모든 어플리케이션이 해당됩니다.

* IP 주소

네트워크 상에서 컴퓨터를 식별하는 번호로 네트워크 어댑터(랜카드) 마다 할당 되어 있습니다.

* 포트(Port)

같은 컴퓨터 내에서 프로그램을 식별하는 번호로 클라이언트는 서버 연결 요청 시 IP주소와 포트 번호를 알아야 합니다.

* InetAddress 클래스

IP주소를 다루기 위해 자바에서 제공하는 클래스입니다.

주로 사용하는 메소드로는 아래와 같습니다.

```java
// static InetAddress getLocalHost() : 지역 호스트(네트워크에 연결되어 있는 컴퓨터)의 Host명과 IP주소 반환
InetAddress localIP = InetAddress.getLocalHost();

// String getHostName() : 호스트 이름 반환
System.out.println("내 PC 명 : " + localIP.getHostName());

// String getHostAddress() : 호스트의 IP주소 반환
System.out.println("내 IP : " + localIP.getHostAddress());

// byte[] getAddress() : IP주소를 byte배열로 반환
byte[] ipAddress = localIP.getAddress();
System.out.println(Arrays.toString(ipAddress));

// static InetAddress getByName(String host) : 도메인 명(host)을 통해 IP주소 얻음
InetAddress naverIP = InetAddress.getByName("www.naver.com");
System.out.println("naver 서버 명 : " + naverIP.getHostName());
System.out.println("naver 서버 ip : " + naverIP.getHostAddress());

InetAddress[] googleIPs = InetAddress.getAllByName("www.google.com");
System.out.println("구글 IP 개수 : "+ googleIPs.length);
for(InetAddress ip : googleIPs) {
	System.out.println(ip.getHostAddress());
}
```

## 소켓 프로그래밍

### 소켓

소켓이란 **프로세스 간의 통신에 사용되는 양쪽 끝 단입니다.**

### TCP

데이터 전송 속도는 느리지만 정확하고 안정적으로 전달할 수 있는 연결 지향적 프로토콜입니다.

### UDP

데이터 전송 속도는 빠르지만 신뢰성 없는 데이터를 전송하는 비연결 지향적 프로토콜입니다.

### TCP/UDP 연결 방식 및 특징

||TCP|UDP|
|:---:|:---:|:---:|
|연결방식|연결형 프로토콜<br>연결 후 통신<br>1:1 통신 방식|비연결형 프로토콜<br>연결 없이 통신<br>1:1, 1:N, N:N 통신 방식|
|특징|- 데이터의 경계를 구분 안함<br>- 신뢰성 있는 데이터 전송<br>- 데이터의 전송 순서 보장<br>- 데이터의 수신 여부 확인<br>- 패킷을 관리할 필요 없음<br>- UDP보다 전송속도가 느림|- 데이터의 경계를 구분함<br>- 신뢰성 없는 데이터 전송<br>- 데이터의 전송 순서가 바뀔 수 있음<br>- 데이터의 수신 여부를 확인 안함<br>- 패킷을 관리해야함<br>- TCP보다 전송속도가 빠름|
|관련 클래스|.Socket<br>.ServerSocket|.DatagramSocket<br>.DatagramPacket<br>.MulticastSocket|

### TCP 소켓 프로그래밍

클라이언트와 서버간의 1:1 소켓 통신으로 서버가 먼저 실행되어 클라이언트의 요청을 기다려야 하고<br>
서버용 프로그램과 클라이언트용 프로그램을 따로 구현해야 합니다.

자바에서는 TCP 소켓 프로그래밍을 위해 java.net패키지에서 `ServerSocket`과 `Socket`클래스를 제공합니다.

![TCP](https://github.com/kleg26315/TIL/blob/master/resources/TCP.PNG)

#### 서버용 TCP 소켓 프로그래밍 순서

```
1. 서버의 포트번호 정함
2. 서버용 소켓 객체 생성
3. 클라이언트 쪽에서 접속 요청이 오길 기다림
4. 접속 요청이 오면 요청 수락( accept() ) 후 해당 클라이언트에 대한 소켓 객체 생성
5. 연결된 클라이언트와 입출력 스트림 생성
6. 보조 스트림을 통해 성능 개선
7. 스트림을 통해 읽고 쓰기
8. 통신 종료
```
#### 클라이언트용 TCP 소켓 프로그래밍 순서

```
1. 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
2. 서버와의 입출력 스트림 오픈
3. 보조 스트림을 통해 성능 개선
4. 스트림을 통해 읽고 쓰기
5. 통신 종료
```

### UDP 소켓 프로그래밍

UDP는 연결 지향적이지 않기 때문에 연결 요청을 받아줄 서버 소켓이 필요가 없습니다.

java.net패키지에서 제공하는 두 개의 `DatagramSocket`간에 `DatagramPacket`으로 변환된 데이터를 주고 받습니다.


![UDP](https://github.com/kleg26315/TIL/blob/master/resources/UDP.PNG)

#### 서버용 UDP 소켓 프로그래밍 순서

```
1. 서버의 포트번호 정함
2. DatagramSocket 객체
3. 연결한 클라이언트 IP주소를 가진 InetAddress 객체 생성
4. 전송할 메시지를 byte[]로 바꿈
5. 전송할 메시지를 DatagramPacket 객체에 담음
6. 소켓 레퍼런스를 사용하여 메시지 전송
7. 소켓 닫음
```

#### 클라이언트용 UDP 소켓 프로그래밍 순서

```
1. 서버가 보낸 메시지를 받을 byte[] 준비
2. DatagramSocket 객체 생성
3. 메시지 받을 DatagramPacket 객체 준비
4. byte[]로 받은 메시지를 String으로 바꾸어 출력
5. 소켓 닫음
```
