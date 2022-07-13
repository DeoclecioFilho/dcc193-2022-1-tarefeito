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
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepositorio rep;

    @RequestMapping("/")
    @ResponseBody
    public String index2(){
        Usuario u = new Usuario();
        rep.save(u);
        StringBuilder sb = new StringBuilder();
        sb.append("<h1> Olá Mundo<h1>");

        List<Usuario> usuarios =rep.findAll();
        for(Usuario usuario:usuarios){
            sb.append("<li>" + usuario);
        }
       
        return  sb.toString();
    }

    @RequestMapping({"/index.html"})
    
    public ModelAndView index() {
        ModelAndView mv =new ModelAndView("usuario-index");
        mv.addObject("mensagem", "Ola Mundo!");
       // int i = 1/0;
        return mv;
    }

    @RequestMapping(path = "/nova.html", method = RequestMethod.GET)
    public ModelAndView novaGET(){
        ModelAndView mv = new ModelAndView("usuario-new");
        Usuario u = new Usuario();
        mv.addObject("usuario",u);
        return mv;
    }

    @RequestMapping(path = "/nova.html", method = RequestMethod.POST)
    public ModelAndView novaPOST(Usuario u){
        ModelAndView mv = new ModelAndView();
        rep.save(u);
        mv.addObject("usuario", u);
        mv.setViewName("redirect:listar.html");
        return mv;       
    }

    @RequestMapping(path = "/listar.html")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("usuario-list");
        List<Usuario> ul = rep.findAll();
        mv.addObject("usuarios",ul);
        return mv;

    }
    
}
