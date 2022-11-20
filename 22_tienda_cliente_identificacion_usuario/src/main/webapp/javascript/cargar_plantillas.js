var plantillas = {};// este objeto contendra como atributo
//el nombre de cada uno de los archivos que hay en /plantillas
//de esta forma desde js sera muy como usar cualquier plantilla
//de la siguiente forma:
// plantillas.inicio  -> contendra el html de plantillas/inicio.html
// y asi para el resto de archivos


//variable para gestionar la ejecucion cada segundo
//que comprueba que las plantillas esten listas
var intervalo = null;

function carga_archivos_plantillas(idioma){
	//cargar los nombres de los archivos de plantillas que hay:
	$.get("ServicioWebPlantillas",function(res){
		//alert("recibido: " + res);
		//guardos los nombres de las plantillas que hay en el objeto plantillas
		//y ya pido el contenido de cada una
		var arr = JSON.parse(res);
		for(i in arr){
			var nombre_archivo = arr[i].split(".")[0];
			plantillas[nombre_archivo] = "";
		}
		console.log("contenido del objeto plantillas");
		console.log(plantillas);
		cargarPlantillas(idioma);
	});
}//end carga_archivos_plantillas

function cargarPlantillas(idioma){
	
	var carpeta = "plantillas";
	if(idioma == "en"){
		carpeta = "plantillas_en";
	}
	//funcional:
	for (i in plantillas){
		var plantilla_a_cargar = carpeta + "/" + i + ".html";
		//alert("descargando plantilla: " + plantilla_a_cargar);
	
		$.ajax(plantilla_a_cargar,
				{
					parametro : i,
					success: function(res ){
						plantillas[this.parametro] = res;
						//alert("cargado en " + this.parametro + " : " + res);
					}//end function
				}
		);//end get
	}//end for
	$("#contenedor").html("cargando...");
	//la siguiente linea ejecuta la funcion comprobarPlantillas una y otra vez 
	//cada segundo
	intervalo = setInterval(comprobarPlantillas,1000);
}//end cargarPlantillas

function comprobarPlantillas(){
	var listo = true;
	for(i in plantillas){
		if ( plantillas[i] == "" ){
			listo = false;
		}
	}//end for
	if( listo ){
		//$("#contenedor").html("");
		mostrar_productos();
		cargarEventos();
		//parar el interval, para que deje de ejecutar comprobarPlantillas cada seg
		clearInterval(intervalo);
	}//end if
}//end comprobarPlantillas