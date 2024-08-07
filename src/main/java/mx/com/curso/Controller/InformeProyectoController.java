package mx.com.curso.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.curso.Service.InformeProyectoService;

@Controller
@RequestMapping(value = "api/informeProyecto")
public class InformeProyectoController {

	@Autowired
	private InformeProyectoService informeProyectoService;
}
