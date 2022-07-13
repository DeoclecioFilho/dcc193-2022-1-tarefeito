package br.dcc.ufjf.deocleciofilho.tarefeito;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/tarefa")
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

    @RequestMapping({"/index.html"})
    
    public ModelAndView index() {
        ModelAndView mv =new ModelAndView("tarefa-index");
        mv.addObject("mensagem", "Ola Mundo!");
       // int i = 1/0;
        return mv;
    }

    @RequestMapping(path = "/nova.html", method = RequestMethod.GET)
    public ModelAndView novaGET(){
        ModelAndView mv = new ModelAndView("tarefa-new");
        Tarefa t = new Tarefa("Criado em " + new Date());
        mv.addObject("tarefa",t);
        return mv;
    }

    @RequestMapping(path = "/nova.html", method = RequestMethod.POST)
    public ModelAndView novaPOST(Tarefa t){
        ModelAndView mv = new ModelAndView();
        rep.save(t);
        mv.addObject("tarefa", t);
        mv.setViewName("redirect:listar.html");
        return mv;       
    }

    @RequestMapping(path = "/listar.html")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("tarefa-list");
        List<Tarefa> tl = rep.findAll();
        mv.addObject("tarefas",tl);
        return mv;

    }
    
}
