package com.react;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

	/*
	 * @Test public void testMono() {
	 * 
	 * Mono<?> monoString = Mono.just("hello").then(Mono.error(new
	 * RuntimeException())).log();
	 * 
	 * monoString.subscribe(System.out::println);
	 * 
	 * }
	 */	
	
	@Test
	public void testFlux(){
		Flux<String> fluxString = Flux.just("A","B","C","D").log();
		
		fluxString.subscribe(System.out::println);
	}
}

