package br.dcc.ufjf.deocleciofilho.tarefeito;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.engine.AttributeName;

import aj.org.objectweb.asm.Attribute;



@Controller
public class TarefaController {
    @Autowired
    TarefaRepositorio rep;


    @RequestMapping("/")
    @ResponseBody
    public String index2(){
        Tarefa t = new Tarefa("Criado em "+new Date());
        rep.save(t);
        StringBuilder sb =new StringBuilder();
        sb.append("<h1> Olá Mundo<h1>");

        List<Tarefa> tarefas =rep.findAll();
        for(Tarefa tarefa:tarefas){
            sb.append("<li>" + tarefa);
        }
       
        return  sb.toString();
    }

    @RequestMapping({"/tarefa", "/tarefa/index.html"})
    
    public ModelAndView index() {
        ModelAndView mv =new ModelAndView("tarefa-index");
        mv.addObject("mensagem", "Ola Mundo!");
        return mv;
    }
    
}
