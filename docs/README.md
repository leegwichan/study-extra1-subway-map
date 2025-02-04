## 구현 할 기능

- 초기 역 설정
  - 2호선: 교대역 - 강남역 - 역삼역
  - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
  - 신분당선: 강남역 - 양재역 - 양재시민의숲역


- 지하철 역 등록
  - 역 이름은 2글자 이상, 역 이름 중복 X
- 지하철 역 삭제 (노선에 등록된 역 제외)
- 지하철 역 목록 조회


- 지하철 노선 등록
  - 노선 이름 중복 X, 노선 이름은 2글자 이상
  - 등록 시 상행 종점역, 하행 종점역을 입력 받는다.
- 지하철 노선 삭제
- 지하철 노선 목록 조회

- 지하철 구간 추가 기능 (노선에 역을 추가하는 기능)
  - 하나의 역은 여러개의 노선에 추가될 수 있다.
  - 역과 역 사이에 새로운 역이 추가 될 수 있다.
  - 갈래길 X

- 지하철 구간 삭제 기능
  - 노선에 등록된 역을 제거
  - 종점을 제거할 경우 다음 역이 종점
  - 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.

- 지하철 노선에 등록된 역 조회 기능
  - 노선의 상행 종점부터 하행 종점까지 연결된 순서대로 역 목록을 조회


## Class 별 설정

### Line
- [x] 생성시에 노선 이름 형식이 맞는지 확인, Station이 2개 이상 있는지 확인
  - 노선 이름 형식 : 3글자 이상이며 "선"으로 끝나야 한다.
  - Station이 2개 이상
- [x] Line에 Station을 추가하는 기능 # addStation()
  - Line에 같은 이름이 있는 Station이 있는 경우 에러 발생
- [x] Line에 Station을 제거하는 기능 # deleteStation()
  - 제거하려는 Station이 Line에 없는 경우 에러 발생
  - 현재 역이 2개 이하인 경우 에러 발생
- [x] Stations 조회 기능 # getStations()
- [x] Line 정보 복제 # copy()
- [x] 현재 있는 역인지 확인 # isStationInLine()

### Station
- [x] 생성시에 지하철 역 이름 형식이 맞는지 확인
  - 역 이름 형식 : 3글자 이상이며 "역"으로 끝나야 한다.

### LineRepository
- [x] 노선 등록 # addLine()
  - 같은 이름의 Line이 있을 경우, 예외를 발생시킴
- [x] 노선 삭제 # deleteLine()
  - 같은 이름의 Line이 없을 경우, 예외를 발생시킴
- [x] 노선 가져오기 # lines()
  - 모든 노선의 정보 가져오기
- [x] 노선 가져오기 # getLine()
  - 입력한 String과 일치하는 노선 가져오기
  - 같은 이름의 Line이 없을 경우, 예외를 발생시킴
- [x] 역 찾기 # isEnrollStation()
  - 현재 노선에 등록되어 있는 역인지 확인하기
- [x] 노선 업데이트 # updateLine()
  - 같은 이름의 Line이 없을 경우, 예외를 발생시킴

### StationRepository
- [x] 지하철 역 등록 # addStation()
  - 같은 이름이 있을 경우, 예외를 발생 시킴
- [x] 지하철 역 삭제 # deleteStation()
  - 같은 이름이 없을 경우, 예외를 발생 시킴
- [x] 지하철 역 목록 조회 # stations()
- [x] 지하철 역 하나 조회 # getStation()
    - 같은 이름이 없을 경우, 예외를 발생 시킴

### SubwayMap
- [x] 생성 시에 초기 역 설정함
- [x] 역 등록 # enrollStation
- [x] 역 삭제 # deleteStation
  - 이미 등록된 역을 삭제할 경우 에러 발생
- [x] 전체 역 조회 # getStations
- [x] 노선 등록 # enrollLine
  - 노선 등록시에 사용되는 역은 이미 역 등록이 되어있어야 한다.
- [x] 노선 삭제 # deleteLine
- [x] 노선 조회 # getLine
- [x] 구간 등록 # enrollSection
- [x] 구간 삭제 # deleteSection
- [x] 전체 노선 조회 # getLines

### InputView
- [ ] 원하는 기능 선택 #readFunction()
- [ ] 역 이름 입력 #readStationName()
- [ ] 노선 이름 입력 #readLineName()
- [ ] 순서 (노선에 역 추가시) 입력 #readOrder()

### OutputView
- [x] 화면 출력
  - 메인 화면, 역 관리 화면, 노선 관리 화면, 구간 관리 화면
- [x] 행동 정상 작동 확인 출력
  - [INFO] 지하철 역이 등록되었습니다.
  - [INFO] 지하철 역이 삭제되었습니다.
  - [INFO] 지하철 노선이 등록되었습니다.
  - [INFO] 지하철 노선이 삭제되었습니다.
  - [INFO] 구간이 등록되었습니다.
  - [INFO] 구간이 삭제되었습니다.
- [x] 역 목록 출력 # printStations
    ```text
    ## 역 목록
    [INFO] 교대역 
    [INFO] 강남역
    [INFO] 역삼역
    [INFO] 남부터미널역
    [INFO] 양재역
    [INFO] 양재시민의숲역
    [INFO] 매봉역
    [INFO] 잠실역
    ```
- [x] 노선 목록 출력 # printLines
    ```text
    ## 노선 목록
    [INFO] 2호선
    [INFO] 3호선
    [INFO] 신분당선
    [INFO] 1호선
    ```
- [x] 지하철 노선도 출력 # printSubwayMap
    ```text
    [INFO] 2호선
    [INFO] ---
    [INFO] 교대역
    [INFO] 강남역
    [INFO] 역삼역
    
    [INFO] 3호선
    [INFO] ---
    [INFO] 교대역
    [INFO] 남부터미널역
    [INFO] 양재역
    [INFO] 매봉역
    ```

### SubwayApplication
- 전반적인 기능 로직 구현