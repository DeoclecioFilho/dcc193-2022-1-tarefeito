package br.dcc.ufjf.deocleciofilho.tarefeito.aspecto;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class LogAspect {
    @Before("execution(* *..*.*Controller.*(..))")
    private void antesLog(JoinPoint jp){
        System.out.println("O metodo vai ser chamado: "+jp.getSignature());
    }
    @After("execution(* *..*.*Controller.*(..))")
    private void depoisLog(JoinPoint jp){
        System.out.println("O metodo terminou: "+jp.getSignature());
    }
}
