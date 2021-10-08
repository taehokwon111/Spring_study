package test.example.demo_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.example.demo_test.repository.JdbcMemberRepository;
import test.example.demo_test.repository.MemberRepository;
import test.example.demo_test.repository.MemoryMemberRepository;
import test.example.demo_test.service.MemberService;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {


    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    
    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }

}
