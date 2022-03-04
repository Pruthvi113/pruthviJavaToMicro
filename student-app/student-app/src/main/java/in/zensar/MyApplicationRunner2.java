package in.zensar;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component //wont be called if this is NOT mentioned
@Order(5) //order in which this will be executed e.g if there are other runners
public class MyApplicationRunner2 implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ApplicationRunner2 implemented method"+Arrays.toString(args.getSourceArgs()));		

	}

}
