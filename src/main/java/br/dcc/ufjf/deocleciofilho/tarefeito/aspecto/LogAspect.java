package br.dcc.ufjf.deocleciofilho.tarefeito.aspecto;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class LogAspect {
    /* 
    @Before("execution(* *..*.*Controller.*(..))")
    private void antesLog(JoinPoint jp){
        System.out.println("O metodo vai ser chamado: "+jp.getSignature());
    }
*/
    @Around("execution(* *..*.*Controller.*(..))")
    
    private Object antesLog(ProceedingJoinPoint jp) throws Throwable{
       
        System.out.println("O metodo vai ser chamado: "+jp.getSignature());
        Object retorno;
        try{
        retorno = jp.proceed();    
        }catch(Exception e){
            System.out.println("O metodo vai ser chamado: "+jp.getSignature());
            throw e;
        }finally{
            System.out.println("O metodo vai ser chamado: "+jp.getSignature());
        }
        return retorno;
    }

    @After("execution(* *..*.*Controller.*(..))")
    private void depoisLog(JoinPoint jp){
        System.out.println("O metodo terminou: "+jp.getSignature());
    }

}
