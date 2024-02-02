package com.react;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@SpringBootTest
class SpringReactiveProjectApplicationTests {

	//@Test
	public void test() {
		
		System.out.println("Test is started");
		
		Mono<String> monoPublisher =  Mono.just("testing");
		
		monoPublisher.subscribe(new CoreSubscriber<String>() {
			@Override
			public void onSubscribe(Subscription s) {
				System.out.println("Subscription done");
				s.request(1);
			}
			
			@Override
			public void onNext(String data) {
				System.out.println("data : "+data);
				
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("Error : "+t.getMessage());
				
			}

			@Override
			public void onComplete() {
				System.out.println("Completed");
				
			}
		});
		
		monoPublisher.subscribe(new Consumer<String>() {

			@Override
			public void accept(String t) {
				 
				System.out.println("Testing the data from new consumer");
			}
		});
		
		monoPublisher.subscribe(data->{
			
			System.out.println("Testing data from the lambda functional prgramming");
		});
		
		var a=10;
		System.out.println(a);
		
	}
	
	@Test
	public void testingMono() {
		
		Mono<String> errorMono  =Mono.error(new RuntimeException("Error"));
		Mono<String> m1 = Mono.just("Test mono 1").log();
		Mono<String> m2 = Mono.just("Test mono 2").log();
		Mono<String> m3 = Mono.just("Stirng data").then(m1).then(m2).log();		
		
		
		/*
		 * m3.subscribe(data->{ System.out.println(data); });
		 */

		Mono<Tuple2<String, String>> monoZip =  Mono.zip(m1, m2);
		
		
		monoZip.subscribe(data->{
			
			System.out.println(data.getT1());
			System.out.println(data.getT2());
		});
	}
}
