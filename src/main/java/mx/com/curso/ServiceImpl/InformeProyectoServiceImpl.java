package mx.com.curso.ServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.InformeProyectoDTO;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Entidades.InformeProyectoId;
import mx.com.curso.Entidades.RegistroInformacion;
import mx.com.curso.Entidades.UsuariosAdmin;
import mx.com.curso.Repository.InformeProyectoDAO;
import mx.com.curso.Repository.RegistroInformacionDAO;
import mx.com.curso.Service.InformeProyectoService;


@Service
public class InformeProyectoServiceImpl implements InformeProyectoService {

	@Autowired
	private InformeProyectoDAO informeProyectoDAO;
	
	@Autowired
	private RegistroInformacionDAO registroInformacionDAO;
	
	

	
	@Override
	public ResponseDto getInformesByIdRead(InformeProyectoDTO datos) {
		ResponseDto response = new ResponseDto();
		
		InformeProyectoId id = new InformeProyectoId();
		id.setIdInforme(datos.getIdInforme());
		id.setIdProyecto(datos.getIdProyecto());
		id.setAnio(datos.getAnio());
		id.setNumeroConvocatoria(datos.getNumeroConvocatoria());
		id.setCveTipoInforme(datos.getCveTipoInforme());
		
		InformeProyecto resultado = informeProyectoDAO.read(id); // select * from tabla where id1 = ? and id2 = ? and......
		
//		System.out.println(resultado.getId().getIdInforme()); // extraer PK
//		System.out.println(resultado.getId().getIdProyecto());
//		
//		System.out.println(resultado.getEsDecimoAnio()); // extraer NO LLAVES PK Si no campos normal
//		System.out.println(resultado.getUsuario() );
		
		if(resultado != null) {
			response.setCode(200);
			response.setContent(resultado);
			response.setMessage("Informe encontrado");
		} else {
			response.setCode(100);
			response.setMessage("Informe NO encontrado");
		}
		
		return response;
	}


	
	@Override
	public ResponseDto registrarNuevoInforme(InformeProyectoDTO datosInforme) {
//		ResponseDto response = new ResponseDto();

		InformeProyectoId id = new InformeProyectoId();
		id.setIdInforme(datosInforme.getIdInforme());
		id.setIdProyecto(datosInforme.getIdProyecto());
		id.setAnio(datosInforme.getAnio());
		id.setNumeroConvocatoria(datosInforme.getNumeroConvocatoria());
		id.setCveTipoInforme(datosInforme.getCveTipoInforme());
		
//		System.class...datosInforme.id.getIdInforme()
		
		InformeProyecto informeEntity = new InformeProyecto();
		informeEntity.setId(id);
		informeEntity.setUsuario(datosInforme.getUsuario());
		informeEntity.setFechaRegistroInforme(datosInforme.getFechaRegistroInforme());
		informeEntity.setFechaEnvioInforme(datosInforme.getFechaEnvioInforme());
		informeEntity.setCveEstatusInforme(datosInforme.getCveEstatusInforme());
		informeEntity.setCveInstitucion(datosInforme.getCveInstitucion());
		informeEntity.setEsDecimoAnio(datosInforme.getEsDecimoAnio());
		
		informeProyectoDAO.create(informeEntity); // insert into....tabla
//		response.setCode(200);
//		response.setMessage("Informe registrado con exito");
		
		return new ResponseDto(200, "Informe registrado con exito");
	}



	@Override
	public ResponseDto eliminarInformeProyecto(InformeProyectoDTO datosInforme) {
//		delete from tabla where id= 1;
		try {
			
		InformeProyectoId idDelet = new InformeProyectoId();
		idDelet.setAnio(datosInforme.getAnio());
		idDelet.setCveTipoInforme(datosInforme.getCveTipoInforme());
		idDelet.setIdInforme(datosInforme.getIdInforme());
		idDelet.setIdProyecto(datosInforme.getIdProyecto());
		idDelet.setNumeroConvocatoria(datosInforme.getNumeroConvocatoria());
		
//		JDBC -> delete from tabla where id_anio= 1 and id:informe = ?; 
		
		informeProyectoDAO.delete(idDelet);
		
		} catch (Exception e) {
			return new ResponseDto(500, "Ocurrio un error en el server");	
		}
		
		return new ResponseDto(200, "Se elimino el informe");
	}


	

	@Override
	public ResponseDto updateInforme(InformeProyectoDTO datosInforme) {
		
		InformeProyectoId idDelet = new InformeProyectoId();
		idDelet.setAnio(datosInforme.getAnio());
		idDelet.setCveTipoInforme(datosInforme.getCveTipoInforme());
		idDelet.setIdInforme(datosInforme.getIdInforme());
		idDelet.setIdProyecto(datosInforme.getIdProyecto());
		idDelet.setNumeroConvocatoria(datosInforme.getNumeroConvocatoria());
		
		InformeProyecto informeEntity = new InformeProyecto();
		informeEntity.setId(idDelet);
		informeEntity.setUsuario(datosInforme.getUsuario());
		informeEntity.setFechaRegistroInforme(datosInforme.getFechaRegistroInforme());
		informeEntity.setFechaEnvioInforme(datosInforme.getFechaEnvioInforme());
		informeEntity.setCveEstatusInforme(datosInforme.getCveEstatusInforme());
		informeEntity.setCveInstitucion(datosInforme.getCveInstitucion());
		informeEntity.setEsDecimoAnio(datosInforme.getEsDecimoAnio());
		
		informeProyectoDAO.update(informeEntity);
		
		return new ResponseDto(200, "Se actualizo el informe");
	}



	@Override
	public ResponseDto procesoBatchProyectoInforme(InformeProyectoDTO datos) {
		
		List<InformeProyecto> listaInformesProy = informeProyectoDAO.procesoBatchProyectoInforme(datos);
		String resultadoInforme = null;
		String estatusTxt = null;
		String anio = null;
		String proyecto = null;
		
		System.out.println("1.- Lista normal -> " + listaInformesProy);
		System.out.println("2.- Lista de informe -> " + listaInformesProy.size());
	
		for(InformeProyecto datosInforme : listaInformesProy) {
			System.out.println("3.- Lista normal -> " + datosInforme.getUsuario());
			System.out.println("4.- Lista normal -> " + datosInforme.getId().getIdInforme());
//			RESULTADO = (ANIO)_(ID_PROYECTO)_(NUMERO_CONVOCATORIA)_(CVE_ESTATUS_INFORME)_(ES_DECIMO_ANIO)
//					----------> 2014_500_CATEDRAS-2014-01_2_1_Fecha_actual->(YYYY-MM-DD HR-MM-SS)-> fecha en que se procesa la informaci�n
			resultadoInforme = datosInforme.getId().getAnio()+"_"+datosInforme.getId().getIdProyecto()+"_"+
					datosInforme.getId().getNumeroConvocatoria()+"_"+datosInforme.getId().getCveTipoInforme()+"_"+
					datosInforme.getEsDecimoAnio()+"_"+new Date();
			
			RegistroInformacion entity = new  RegistroInformacion();
//			entity.setId(1L); //-- autoincrementable por medio de la secuencia que viene de oracle
			entity.setUsuario(datosInforme.getUsuario());
			entity.setFechaActual(new Date()); // extrae la fecha actual
			entity.setNumeroProyecto(datosInforme.getId().getIdProyecto());
			entity.setCadenaOriginal(resultadoInforme);
			entity.setStatus(datosInforme.getCveEstatusInforme() == 1 ? "En captura" : "Enviado");
			
//			if(datosInforme.getCveEstatusInforme()==1) {
//				estatusTxt = "En captura";
//			}else {
//				estatusTxt = "Enviado";
//			}
//			System.out.println("5.- estatusTxt -> " + estatusTxt);
//			entity.setStatus(estatusTxt);
			
			registroInformacionDAO.create(entity); // registrar iformacion a la nueva tabla
			
/*			
BITACORA_INFORME_ESTATUS bitacora = new BITACORA_INFORME_ESTATUS();
bitacora.setIdproyecto(datosInforme.getId().getIdProyecto());
bitacora.setUsuario(datosInforme.getUsuario());
bitacora.setFechaActual(new Date());
bitacora.setFechaRegistroInforme(datosInforme.getFechaRegistroInforme());
bitacora.setFechaEnvioInforme(datosInforme.getFechaEnvioInforme());
bitacora.setEstatus(datosInforme.getCveEstatusInforme() == 1 ? "01_ACTIVO" : "02_EN_PROCESO_DE_VALIDACION");

anio = (datosInforme.getId().getAnio()).subSrting(2); -> 2024 = 24
bitacora.setFolio(anio+datosInforme.getId().getIdProyecto());v = 241515

DAO.create(bitacora);


------------------------------------
stream() -> agiliza los filtros


 */
			
		}
		
		
		return null;
	}
	
// Yo quiero recorrer una lista de datos en java
// Yo quiero juntar informecion dentro de un for en java
	
	
	
/*
 
-> INFORME_PROYECTO
De preferencia con hibernate/ si no con JDBC -> ESto es solo para entregar FUNCIONALIDAD

1.- Un servicio que consulte todos los registros del a�o = 2014 y el tipo informe sea el trienal y ES_DECIMO_ANIO = 1
----------------------
SELECT * FORM INFORME_PROYECTO WHERE ANIO = 2014 AND CVE_TIPO_INFORME = 2 AND  ES_DECIMO_ANIO = 1;

1.2.- Sobre la consulta del punto #1 recorrer cada una y crear la siguiente estrutura:

--> Aqui deje un detalle no se como hacer lo de la fecha -->(pendiente revisarlo al final)<<<<-----------------
RESULTADO = (ANIO)_(ID_PROYECTO)_(NUMERO_CONVOCATORIA)_(CVE_ESTATUS_INFORME)_(ES_DECIMO_ANIO)
----------> 2014_500_CATEDRAS-2014-01_2_1_Fecha_actual->(YYYY-MM-DD HR-MM-SS)-> fecha en que se procesa la informaci�n

Crear una nueva tabla: Nombre lo ponen ustedes

Usuario:X_dnoriega1439
Fecha actual: fecha en que se guarda ese registro
Numero de proyecto
Estatus = 1 = en capotura o 2 = enviados SE DEBE REGISTRA EN ESTATUS EN TEXTO -> En captura/ Enviado
guardar en un campo: RESULTADO


}


---------------------------
1.- Crear una tabla de bitacora => BITACORA_INFORME_ESTATUS
ID_PROYECTO
USUARIO
FECHA_ACTUAL
fechaRegistroInforme
fechaEnvioInforme
Estatus -> Estatus = 1 = en capotura o 2 = enviados-> Crean un campo con nombre BANDERA_TRANSACCION
 ->Si Estatus = 1 => 01_ACTIVO
 ->Si Estatus = 2 => 02_EN_PROCESO_DE_VALIDACION

Campo: FOLIO_PROYECTO -> (A�O tomar las ultimas 2 cifras)ID_PROYECTO
==>EJEMPLO-> a�o=2014 y idProyecto=2240 Resultado => 142240


*/
	
/* ---------------  TODO LO VISTO EN EL CURSO -----------------

1.-
En el curso usamos conexion normal: Conexion a oracle simple: DRIVER LA CONEXIO, USUARIO, PASWW...lo que esta en el properties
JNDI -> (JNDI_cursoJulio)

cursoJulio.war

YOUTUBE
1.- Como configurar mi JNDI si mi proyecto lo usa, trabajando con tomcat
2.- Explicacion de un JNDI


-------------------------------------------------------------------------------------------------------

1.- Oracle 11g: CRUD, SP, SECUENCIAS, TRIGGERS.....
2.- Java 8
3.- Spring Framework 4.0 ->{

 3.1-> MVC->Modelo vista controlador
 3.2-> Spring security -> Darle seguridad al proyecto web -> {
 		JWT = Json Web Token <--- Generar token para la seguridad que permitan consumir los servicios
 }
 3.3-> DAO ->va enfocado a hibernate
 3.4-> ORM
 3.5->.....
4.- Framework de Hibernate 4.0 para consultas por medio de entidades
5.- Postman
6.- Git bash/GitHub


---------------------------------------------------------------------------------
Spring Framework -> Soporta el BackEnd/FrontEnd
-> scr/main/webapp/index.jsp
-> Vistas => .jsp => .html NO ES UN LENGUAJE DE PROGRAMMACION-> Dise�o
-> JS=>(JavaScript) -> SI ES UN LENGUAJE DE PROGRAMACION -> Movimiento/funcion a la pagina -> Tengo un boton cuando yo le de clic me muestra un mensaje


}


4.-

---> HIBERNATE -> JDBC

NOMBRE_COMPLETO
RFC
CURP
EDAD
SEXO (Campo que va a recibir M = masculino y F = femenino)
DIRECCION
NSS (Campo que va a recibir numeros 10 dijitos)
TELEFONO
ACTIVO (Campo que va a recibir 0 = BAJA y 1 = ACTIVO)
------------------------------------------------------------------

----------      NOTA: Registrar informacion por script y guardar los script    -----------------
----   NOMBRE_COMPLETO    ---   EDAD - SEXO - ACTIVO
FABIANA ANDREA ALVAREZ ANRIQUE - 33  -  F   -  0
CARLOS BORELLO ANRIQUE         - 35  -  M   -  0
DAVID CASTILLO SALCEDO         - 25  -  M   -  0
SERGIO ALTAMIRANO RAMIREZ      - 23  -  M   -  1
ABRIL ACU�A ALANIZ             - 29  -  F   -  1
DANIELA CABRERA SILVA          - 25  -  F   -  1
NATALIA CARRIZO CASAS          - 35  -  F   -  1
BRISA BARREDA PEREZ            - 35  -  F   -  1
LUCAS ANRIQUE BARRERA          - 39  -  M   -  1
ROMINA ARGUELLO ANRIQUE        - 28  -  F   -  1



==========================================================================================
=====================================     FASE: 01   ====================================
===========================================================================================

Tarea: Utilizar Postman

1.- Un service para insertar nuevos empleados
REGLA I.- Antes de insertar un empleado verificar si ya EXISTE ese usuario en la base de datos
------------------------------------------------------------------------------------------------------------

2.- Servicio para eliminar un empleado 
REGLA I.- Se puede eliminar siempre y cuando este dado de baja, si no esta dado de baja
ese empleado mostrar un mensaje de -> "Imposible eliminar Empleado, Sigue Laborando (Activo)...! ", 
En caso contrario el siguiente mensaje -> "Empleado eliminado correctamente"
------------------------------------------------------------------------------------------------------------

3.- Servicio para actualizar los datos de un empleado 
REGLA I.- Para poder actualizar los datos el empleado debe de estar en estatus ACTIVO 
(Si no esta activo lanzar el mensaje -> "El empleado esta dado de baja, No puede actualizar su informacion.! ")
------------------------------------------------------------------------------------------------------------

4.- Servicio para consultar todos los usuarios de sexo Masculino
------------------------------------------------------------------------------------------------------------

5.- Servicio para consultar todos los usuarios de sexo Femenino de 35 a�os
------------------------------------------------------------------------------------------------------------

6.- Servicio para buscar el usuario por RFC
------------------------------------------------------------------------------------------------------------



==========================================================================================
=====================================     FASE: 02   ====================================
===========================================================================================

El servicio #1.- para insertar nuevos empleados validar con expresiones regulares los siguiente:
1.- CURP
1.1.- Si la curp no es correcta mandar mensaje -> ("La curp no cuenta con la estrutura adecuada")

2.- RFC
2.1.- Si el rfc no es correcta mandar mensaje -> ("El rfc no cuenta con la estrutura adecuada")

3.- NSS -> 
3.1.- Validar que solo reciba n�meros y no texto, si el usuario ingresa texto informar con un mensaje -> ("El campo nss debe ser n�merico")
3.2.- Validar que nss sea exactamente 10 dijitos, si es menor mandar mensaje -> ("Su nss no cuenta con la estrutura adecuada")
	











 */
	
	
	
	
	
	
	
	
} // fin de clase
