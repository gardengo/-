# 프로젝트 한 일(0129 ~ 0202)
### 이준범
- 포인트(마일리지)
  - 포인트(마일리지) 제도에 필요한 api, repository작성
  - redis를 이용한 현재 포인트값 캐싱
  - redis 만료시 중간 포인트 값 갱신 작업 (service)

- 인프라
  - ec2에 mariadb, elk, openvidu 배포
  - ec2에 프론트 npm run build를 통한 statc한 파일로 배포
  - ec2에 백엔드 이미지로 배포
  - application.properties에 배포환경에 맞는 포트설정
  - nginx에서 https를 통한 리버스 프록시 구축. 프론트-백,    -백-오픈비두 연결 구현.
  - 프론트-오픈비두 미구현
---

### 노성은
- DM
  - 메시지 파싱 처리 (메시지 입력 타입 따라 다르게 처리하는)
  - 1:1 dm 페이지 생성
- feed
  - SNS 상세 피드 페이지 (feed detail) 생성
  - 본인 계정 피드 페이지 (MyProfile)생성
---
### 송준석
- BE
  - [karaoke] Song controller/model/repo/service 구축
  - [AWS S3] 버킷 생성 및 커넥션 설정
  - [AWS S3] S3fileUploader 구현

- FE
  - [노래방] 퍼펙트스코어, MML형식 -> ScoreData 파싱하는 ScoreParser 구현
  - [노래방] 퍼펙트스코어, 음성 인식 및 주파수로 변환하는 ToneDetector 구현
  - [노래방] 퍼펙트스코어, 입력 주파수 및 Scoredata를 그리는 ScoreDrawer 구현
  - [노래방] 일반모드, 노래 데이터 변환 및 출력 구현
  - [노래방] 일반모드, 진행중인 노래 싱크에 맞게 가사 렌더링 구현
---
### 조현우
- elk를 통해 유저 닉네임 검색 시 user pk 반환
- elk stack spring boot 프로젝트에 적용
- aop를 통해 백엔드 서버 내 함수 호출 시 각각의 정보 출력
- SSE를 통한 알림 기능 구현
- 서버 RSA 복호화
- 클라이언트 RSA 암호화
- 프론트엔드 Vue & Quasar 환경설정
- 기획 발표
- docker compose with elk stack
- Logstash 설정을 통해 MySQL, elastic search 데이터 동기화
- 댓글 백엔드 스켈레톤 코드 작성
- 피드 백엔드 스켈레톤 코드 작성
- 좋아요 백엔드 스켈레톤 코드 작성
- 조회 백엔드 스켈레톤 코드 작성
- 웹소켓 프론트엔드, 백엔드 스켈레톤 코드 작성
- RSA 키매니저 개발 (IP를 키로 각 클라이언트 별 비대칭키 페어를 관리)
- RSA 배치 파일 개발 (일정 주기마다 RSA 변수를 확인하며 최근 =- - 요청이 10분 이상 지난 경우 데이터 삭제)
- bcrypt를 통해 hash 값 비교
- 내부적으로는 AutoIncrement INT type UserPK를 사용하도록 외부 노출 시에 UUID type UserKey를 사용하도록 설정
- elastic search 랭킹 서비스 개발 중
---
### 연정흠
작업물 branch : [websocket](https://lab.ssafy.com/s10-webmobile1-sub2/S10P12A705/-/tree/websocket?ref_type=heads)

- STOMP pub sub & RabbitMQ & Redis & MySQL 활용 DM(채팅) 구현
- 방생성
- 실시간 채팅
- 이전 채팅 내역 및 새로운 채팅 내역 GET
-  redis <-> JPA 데이터 로딩 & 저장
- 데이터 Batch apic Testing Tool로 테스트
---
### 고정원
[BE] 노래방
- /api/v1/karaoke/sessions/getToken
  - SessionName으로 OpenVidu Session 객체 생성, 이미 존재하면 생성하지 않고 가져옴
  - 세션에 연결된 Connection 객체 생성(입장하기) 
  - BE 서버에 Session과 Token을 저장하여 관리
  - Connection 객체의 토큰 반환

- /api/v1/karaoke/sessions/removeToken
  - SessionName과 Token을 받아서 해당하는 Session에 Token 제거
  - 해당 Session에 더이상 Token이 존재하지 않으면 Session도 제거

- /api/v1/karaoke/sessions/closeSession
  - SessionName에 해당하는 Session 강제 제거
  - Session에 들어와있던 Token도 모두 제거

- /api/v1/karaoke/sessions/sessionList
  - BE 서버에서 관리하고 있는 모든 Session 반환

- /api/v1/karaoke/sessions/sessionInfo
  - SessionName에 해당하는 Session 객체 반환

- /api/v1/karaoke/recording/start
  - SessionName에 해당하는 세션 녹화 시작
  - OutputMode를 설정할 수 있음(Computed, Individual)

- /api/v1/karaoke/recording/stop
  - 녹화 종료, 녹화된 영상은 OpenVidu 서버에 저장

- /api/v1/karaoke/recording/delete
  - RecordingId에 해당하는 녹화 영상을 OpenVidu 서버에서 제거

- /api/v1/karaoke/recording/get/{recordingId}
  - RecordingId에 해당하는 녹화 영상의 정보 반환

- /api/v1/karaoke/recording/list
  - OpenVidu 서버에 저장되어있는 모든 영상 정보 반환

- /api/v1/karaoke/file/upload
  - OpenVidu에 저장되어 있는 영상을 AWS S3에 업로드
___
# firstPjtTest

공통테스트

## src/pages/HomePage.vue

-   vertical carousel
-   일단 페이지 문구만 기입함
-   로그인/회원가입 진행되는 모달 만듦(src/components/StartTest.vue)
-   > src/components/SignIn.vue는 로그인 모달, 회원가입 모달 따로 만든 것

-   써드 파티 로그인은 더 공부해야 함
-   홈페이지 배경색, 아이콘, gif 추후 추가 해야함

# OPENVIDU TEST

## 기존 server 변경점

-   application.properities 값 추가
-   OpenViduAPI.java 파일 추가
-   build.gradle에 dependency 추가

## DOCKER에 OPENVIDU 띄우기

-   DOCKER 설치 후, cmd 창에서

```
docker run -p 4443:4443 --rm -e OPENVIDU_SECRET=MY_SECRET -e OPENVIDU_RECORDING=true -e OPENVIDU_RECORDING_PATH=/opt/openvidu/recordings -v /var/run/docker.sock:/var/run/docker.sock -v /opt/openvidu/recordings:/opt/openvidu/recordings openvidu/openvidu-dev:2.29.0
```

## 백서버는 그대로 실행(port=5000)

## 프론트 서버 띄우기

```
cd S10P12A705/front
npm install
npm run serve
```

-   이후 localhost:8080으로 접속해서 확인
-   localhost:4443에서 connectionTest 가능
-   필터 추가

## ELK stack 설치 및 확인하기

### 패키지 목록 업데이트

```
sudo apt-get update
```

### Docker 설치

```
sudo apt-get install docker.io
```

### Docker 서비스 시작

```
sudo systemctl start docker
```

### 부팅 시에 Docker 자동 실행 설정

```
sudo systemctl enable docker
```

### Docker Compose 설치

```
sudo apt-get install docker-compose
```

### gedit 텍스트 편집기 설치

```
sudo apt-get install gedit
```

```
$ mkdir [프로젝트 폴더]
$ cd [프로젝트 폴더]
$ gedit docker-compose.yml
```

// docker-compose.yml
```
version: '3.6'
services:
  Elasticsearch:
    image: elasticsearch:7.17.16
    container_name: elasticsearch
    restart: always
    volumes:
    - elastic_data:/usr/share/elasticsearch/data/
    environment:
      ES_JAVA_OPTS: "-Xmx256m -Xms256m"
      discovery.type: single-node
    ports:
    - '9200:9200'
    - '9300:9300'
    networks:
      - elk

  Logstash:
    image: logstash:7.17.16
    container_name: logstash
    restart: always
    volumes:
    - ./logstash/:/logstash_dir
    command: logstash -f /logstash_dir/logstash.conf
    depends_on:
      - Elasticsearch
    ports:
    - '9600:9600'
    environment:
      LS_JAVA_OPTS: "-Xmx256m -Xms256m"
    networks:
      - elk

  Kibana:
    image: kibana:7.17.16
    container_name: kibana
    restart: always
    ports:
    - '5601:5601'
    environment:
      - ELASTICSEARCH_URL=http://elasticsearch:9200
    depends_on:
      - Elasticsearch
    networks:
      - elk
volumes:
  elastic_data: {}

networks:
  elk:

```
// end of docker-compose.yml

```
$ mkdir logstash
$ cd logstash
$ gedit logstash.conf
```

// logstash.conf
```
# synchronization with elasticseasrch & mysql
input {
  jdbc {
    jdbc_connection_string => "jdbc:mysql://localhost:3306/testuser"                      # test uesr db 사용
    jdbc_user => "root"                                                                   # mysql user id
    jdbc_password => "1234"                                                               # mysql user password
    jdbc_driver_library => "/user/share/logstash/config/mysql-connector-java-8.0.30.jar"  # ubuntu에서 mysql jar 다운로드 받아 이 디렉터리로 복사해놓기
    jdbc_driver_class => "com.mysql.cj.jdbc.Driver"
    
    statement => "SELECT * FROM likes"                                                    # likes 테이블 데이터 모두 옮기기
    
    schedule => "* * * * *"
    clean_run => true
    use_column_value => true
    tracking_column => "timestamp"
    tracking_column_type => "timestamp"
    last_run_metadata_path => "/user/share/logstash/config/like_last_run_metadata"        # 메타 정보를 기록하는 경로
    type => "like"
  }

  jdbc {
    jdbc_connection_string => "jdbc:mysql://localhost:3306/testuser"
    jdbc_user => "root"
    jdbc_password => "1234"
    jdbc_driver_library => "/user/share/logstash/config/mysql-connector-java-8.0.30.jar"
    jdbc_driver_class => "com.mysql.cj.jdbc.Driver"
    
    statement => "SELECT * FROM hit"
    
    schedule => "* * * * *"
    clean_run => true
    use_column_value => true
    tracking_column => "timestamp" 
    tracking_column_type => "timestamp"
    last_run_metadata_path => "/user/share/logstash/config/view_last_run_metadata"
    type => "view"
  }
}

filter {
}

output {
  if [type] == "like" {
    elasticsearch {
      hosts => ["localhost:9200"]
      index => "like"                             # index를 like로 데이터 동기화
    }
  }

  if [type] == "view" {
    elasticsearch {
      hosts => ["localhost:9200"]
      index => "hit"                              # index를 hit로 데이터 동기화
    }
  }
}

```
// end of logstash-config

```
$ docker-compose up
```

localhost:5601로 접속하면 확인 가능

