package br.dcc.ufjf.deocleciofilho.tarefeito;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TarefaController {
    @Autowired
    private TarefaRepositorio rep;


    @RequestMapping("/")
    @ResponseBody
    public String index(){
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
}
