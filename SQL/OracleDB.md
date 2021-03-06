# Oracle Database 개요

Data란 관찰 결과로 나타난 정량적 혹은 정성적인 실제 값입니다.

정보란 데이터를 기반으로 의미를 부여한 것입니다.

## Database

Database란 한 조직에 필요한 정보를 여러 응용 시스템에서 공용할 수 있도록 논리적으로 연관된<br>
데이터를 모으고 중복되는 데이터를 최소화하여 구조적으로 통합/저장해놓은 것입니다.

### 정의

**1. 운영 데이터(Operational Data)**

조직의 목적을 위해 사용되는 데이터

**2. 공용 데이터(Shared Data)**

공동으로 사용되는 데이터

**3. 통합 데이터(Integrated Data)**

중복 최소화로 중복으로 인한 데이터 불일치 현상 제거

**4. 저장 데이터(Stored Data)**

컴퓨터 저장장치에 저장된 데이터

### 특징

**1. 실시간 접근성(real time accessibility)**

사용자가 데이터 요청 시 실시간으로 결과 서비스

**2. 계속적인 변화(continuos change)**

데이터 값은 시간에 따라 항상 바뀜

**3. 동시 공유(concurrent sharing)**

서로 다른 업부 또는 여러 사용자에게 동시 공유됨

**4. 내용에 따른 참조(reference by content)**

데이터의 물리적 위치가 아닌 데이터 값에 따라 참조

## DBMS

데이터베이스에서 데이터 추출, 조작, 정의, 제어 등을 할 수 있게 해주는 데이터베이스 전용 관리 프로그램

### 기능

|데이터 추출<br>(Retrieval)|사용자가 조회하는 데이터|
|:---:|:---|
|데이터 조작<br>(Manipulation)|데이터를 조작하는 소프트웨어(응용 프로그램)가 요청하는<br>데이터 삽입, 수정, 삭제 작업 지원|
|데이터 정의<br>(Definition)|데이터의 구조를 정의하고 데이터 구조에 대한<br>삭제 및 변경 기능 수행|
|데이터 제어<br>(Control)|데이터베이스 사용자를 생성하고 모니터링하며<br>접근 제어 백업과 회복, 동시성 제어 등의 기능 지원|

### DBMS 사용 이점

**1. 데이터 독립화**

데이터와 응용 프로그램을 분리시킴으로써 상호 영향 정도를 줄일 수 있음

**2. 데이터 중복 최소화, 데이터 무결성 보장**

중복되는 데이터를 최소화 시키면 데이터 무결성이 손상될 가능성이 줄어듦<br>
중복되는 데이터를 최소화 시키면 필요한 저장공간의 낭비를 줄일 수 있음

**3. 데이터 보안 향상**

응용프로그램은 DBMS를 통해 DBMS가 허용하는 데이터에만 접근 가능<br>
권한에 맞게 데이터 접근을 제한하거나 데이터를 암호화시켜 저장 가능

**4. 관리 편의성 향상**

다양한 방법으로 데이터 백업 가능<br>
장애 발생 시 데이터 복구 가능

