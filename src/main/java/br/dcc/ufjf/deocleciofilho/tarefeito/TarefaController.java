package br.dcc.ufjf.deocleciofilho.tarefeito;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TarefaController {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "<h1> Olá Mundo<h1>";

    }
}
