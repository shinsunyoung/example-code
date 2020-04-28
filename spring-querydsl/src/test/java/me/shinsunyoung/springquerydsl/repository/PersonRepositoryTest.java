package me.shinsunyoung.springquerydsl.repository;


import static org.assertj.core.api.Assertions.assertThat;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import me.shinsunyoung.springquerydsl.domain.Person;
import me.shinsunyoung.springquerydsl.domain.QPerson;
import me.shinsunyoung.springquerydsl.predicate.PersonPredicate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

  @Autowired
  private PersonRepository repository;

  @PersistenceContext // 영속성 객체를 자동으로 삽입해줌
  private EntityManager em;

  @Before
  public void cleanUp() throws Exception {
    repository.deleteAll();

    repository.save(new Person("철수", "김", 22, "kim@chulsu.com"));
    repository.save(new Person("차차", "김", 15, "cha@cha.cha"));
    repository.save(new Person("프링", "스", 41, "spring@bo.com"));
    repository.save(new Person("자바", "김", 38, "imjava@java.net"));
    repository.save(new Person("쿼리", "최", 19, "choi@que.com"));
    repository.save(new Person("고당", "최", 76, "best@good.com"));
    repository.save(new Person("선화", "스", 11, "flower@cha.cha"));
  }

  @Test
  public void 모든_리스트_가져오기() throws Exception {
    List<Person> personList = repository.findAll();
    assertThat(personList.size()).isEqualTo(7); // 총 갯수
  }

  @Test
  public void 김씨_성_찾기() throws Exception {

    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    QPerson person = QPerson.person;

    long result = queryFactory.selectFrom(person).where(person.lastName.eq("김")).fetchCount(); // 성이 김씨인 사람 찾기
    List<Person> result2 = queryFactory.selectFrom(person).where(person.lastName.eq("김"), person.email.like("%.com")).fetch(); // 성이 김씨이고 메일 뒤가 com으로 끝나는 사람 찾기
    QueryResults<Person> result3 = queryFactory.selectFrom(person).where(person.lastName.eq("김"), person.age.between(20,40)).fetchResults(); // 성이 김씨이고 나이가 20~40세 사이인 사람 찾기

    assertThat(result).isEqualTo(3);
    assertThat(result2.get(0).getFirstName()).isEqualTo("철수");
    assertThat(result3.getTotal()).isEqualTo(2);
  }

  @Test
  public void 스선화_찾기() throws Exception {

    List<Person> result = (List<Person>) repository.findAll(PersonPredicate.search("선화", "스")); // 성이 스이고 이름이 선화인 사람 찾기
    List<Person> result2 = (List<Person>) repository.findAll(PersonPredicate.search(null, "스")); // 성이 스씨인 사람 찾기
    List<Person> result3 = (List<Person>) repository.findAll(PersonPredicate.search(null, null));

    assertThat(result.size()).isEqualTo(1);
    assertThat(result2.size()).isEqualTo(2);
    assertThat(result3.size()).isEqualTo(7);
  }

}