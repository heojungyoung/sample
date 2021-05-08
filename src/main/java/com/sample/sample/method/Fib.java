package com.sample.sample.method;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class Fib implements IFib {
	
	@Override
	public void allFib(int n) {
			int[] memo = new int[n+1];
			
			for(int i =0 ; i < n ; i++) {
				log.info(i + " : " + fib(i, memo));
			}		
	}

	@Override
	public int fib(int n, int[] memo) {
		if(n <=0 ) return 0;
		else if(n == 1) return 1;
		else if(memo[n] > 0 ) return memo[n];
		memo[n] = fib(n-1, memo ) + fib(n-2 , memo);
		return memo[n];
	}

	
}
