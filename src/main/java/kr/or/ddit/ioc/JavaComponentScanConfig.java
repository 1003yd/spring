package kr.or.ddit.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration	//설정파일임을 알려준다. => bean을 사용하기 위해서 필요함
@ComponentScan(basePackages= {"kr.or.ddit.board"})
public class JavaComponentScanConfig {

}
