# mySQL



- ORDER BY
  
  - 쿼리 결과를 특정 열(컬럼) 기준으로 정렬할 수 있음.
  
  ```sql
  SELECT COLUMN1, COLUMN2, ...
  FROM TABLE
  ORDER BY COLUMN1 ASC/DESC, COLUMN2 ASC/DESC, ...;
  ```
  
  - ASC는 오름차순
  
  - DESC는 내림차순
    
    
    
    

------



- LIKE
  
  - 문자열 패턴 매칭을 수행하는데 사용함.
  
  - 주어진 열(컬럼)값과 비교하여 특정 패턴과 일치하는지 확인하는데 사용.
    
    

```sql
SELECT column1, column2, ...
FROM table
WHERE column LIKE pattern;


// COLUMN1과 COLUMN2를 선택하고,
// WHERE 문으로 조건을 설정. PATTERN과 일치하는 컬럼을 가져온다.

SELECT column1, column2, ...
FROM table
WHERE LOWER(column) LIKE LOWER('%apple%');


```



- GROUP BY
  
  - 그룹화된 데이터에 대한 집계(AGGREGATE) 함수를 사용하여 결과를 그룹별로 요약할 수 있는 구문
  
  - SUM, COUNT, AVG와 같이 사용함.

- HAVING
  
  - GROUP BY와 함께 사용되며 그룹화된 결과에 조건을 적용하여 조건을 만족하는 그룹만을 선택하는 구문.
  
  - WHERE절과 비슷하지만 HAVING은 그룹화된 결과에 대한 조건을 처리함.

- JOIN
  
  - 두 개이상의 테이블을 연결하여 관련된 데이터를 결합하는 구문.
  
  - INNER JOIN, LEFTJOIN, RIGHT JOIN, FULL JOIN 등 다양한 유형이 존재

- SUBQUERY
  
  - 쿼리 안에 다른 쿼리를 사용하는 구문.
  
  - 주로 WHERE절이나 FROM절에서 사용되며, 더 복잡한 데이터의 추출이나 필터링을 위해 사용될 수 있음.

- UNION
  
  - 두 개이상의 SELECT문의 결과를 결합하여 하나의 결과셋으로 만듬
  
  - UNION은 중복된 행을 제거하고 UNION ALL은 중복을 제거하지 않고 모두 포함. 

- INDEX
  
  - 데이터 베이스 성능을 향상시키기 위해 사용되는 구조.
  
  - CREATE INDEX문을 사용하여 인덱스를 생성, SELECT문에서 인덱스를 활용하여 효율적인 검색을 수행할 수 있음.

- TRANSACTION
  
  - 데이터베이스 작업의 원자성, 일관성, 격리성, 지속성을 보장하기 위해 사용하는 구문.
  
  - BEGIN, COMMIT, ROLLBACK등의 키워드를 사용하여 트랜잭션을 시작, 종료할 수 있음.









- 프로시저(Procedure)
  
  - 쿼리를 묶어놓은 하나의 클래스라고 생각하면된다.





- 트리거
  
  - 
