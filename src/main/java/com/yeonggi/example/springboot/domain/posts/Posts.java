package com.yeonggi.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*@Setter -> @Builder*/
@Getter //lombok //6.
@NoArgsConstructor //lombok //5.
@Entity //JPA - must //1.
public class Posts {

    @Id //2.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //3.
    private Long id;

    @Column(length = 500, nullable = false) //4.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //lombok //7.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
/*
1.@Entity
- 테이블과 링크될 클래스임을 나타냅니다.
- 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭합니다.
- ex) SalesManager.java -> sales_manager table
2.@Id
- 해당 테이블의 PK 필드를 나타냅니다.
3.@GeneratedValue
- PK의 생성 규칙을 나타냅니다.
- 스프링부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됩니다.
- 스프링부트 2.0버전과 1.5버전의 차이는 http://jojoldu.tistory.com/295에 정리했으니 참고하세요.
4.@Column
- 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됩니다.
- 사용하는 이유는, 기본값 외에 추가로 필요한 변경이 필요한 옵션이 있으면 사용합니다.
- 문자열의 경우 VARCHAR(255)가 기본값인데,
  사이즈를 500으로 늘리고 싶거나(ex: title), 타입을 TEXT로 변경하고 싶거나(ex:content) 등의 경우에 사용됩니다.
5.@NoArgsConstructor
- 기본 생성자 자동 추가
- public Posts() {}와 같은 효과
6.@Getter
- 클래스 내 모든 필드의 Getter 메소드를 자동생성
7.@Builder
- 해당 클래스의 빌더 패턴 클래스를 생성
- 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
* 참고
- 웬만하면 Entity의 Pk는 Long 타입의 Auto_increment를 추천합니다(MySQL 기준으로 이렇게 하면 bigint 타입이 됩니다).
  주민등록번호와 같이 비즈니스상 유니크 키나, 여러 키를 조합한 복합키로 PK를 잡을 경우 난감한 상황이 종종 발생합니다.
  1) FK를 맺을 때 다른 테이블에서 복합키 전부를 갖고 있거나, 중간 테이블을 하나 더 둬야하는 상황이 발생합니다.
  2) 인덱스에 좋은 영향을 끼치지 못합니다.
  3) 유니크한 조건이 변경될 경우 PK 전체를 수정해야하는 일이 발생합니다.
  주민등록번호, 복합키 등은 유니크 키로 별도로 추가하시는 것을 추천드립니다.*/
