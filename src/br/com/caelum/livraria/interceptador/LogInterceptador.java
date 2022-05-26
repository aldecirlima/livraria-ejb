package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		Long millis = System.currentTimeMillis();

		// Chamada do método
		Object obj = context.proceed();
		String metodo = context.getMethod().getName();
		String nameClass = context.getTarget().getClass().getSimpleName();

		System.out.println("[ INFO ] Classe: " + nameClass + ", Método: " + metodo);
		System.out.println("[ INFO ] Tempo gasto: " + (System.currentTimeMillis() - millis));

		return obj;
	}

}
