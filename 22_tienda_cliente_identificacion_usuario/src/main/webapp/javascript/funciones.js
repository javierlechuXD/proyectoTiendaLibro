//funciones de caracter generico
function mostrar_productos(){
	//pedir al servicio de libros los libros
	//y mostrar su resultado usando una plantilla
	$("#contenedor").html(plantillas.productos);
	comienzo = 0;
	titulo_buscar = "";
	$("#buscador_titulo").keyup(
		function(){
			titulo_buscar = this.value;
			refresca_listado();
		}
	);
	$("#enlace_anterior").click(
		function(){
			comienzo -= 10
			refresca_listado();
		}
	);//end click enlace anterior
	$("#enlace_siguiente").click(
		function(){
			comienzo += 10; 
			refresca_listado();
		}	
	);	
	refresca_listado();
}//end mostrar_productos

function refresca_listado(){
	
	if( comienzo <= 0 ){
		$("#enlace_anterior").hide();
	}else{
		$("#enlace_anterior").show();
	}
	
	$.getJSON("ServicioWebLibros/obtenerLibros",{
		titulo: titulo_buscar,
		comienzo: comienzo
	}).done( 
		function(res){
			let libros = res.libros;
			let total_libros = res.total;
			
			if( comienzo + 10 > total_libros ){
				$("#enlace_siguiente").hide();
			}else{
				$("#enlace_siguiente").show();
			}
						
			$("#productos_listado").html(Mustache.render(plantillas.productos_listado,libros));
			$("#total_libros").html(total_libros);
			$(".enlace_detalles").click(mostrar_detalles);//end click detales
			$(".enlace_comprar").click(comprar_producto);
		}
	);//end get obtenerLibros
}//end refresca_listado

function mostrar_detalles(){
	//this -> es el elemento sobre el que se hizo click en este caso
	//$(this) es obtener el mismo elemento en forma de jquery
	let id = $(this).attr("id_producto");
	alert("mostrar detalles del libro de id: " + id + "\n" + 
	"pedir a un servicio web todos los datos del libro dandole diche id" +
	"y mostrarlos en una nueva plantilla, junto con sus dos imagenes " + "\n" +
    "en dicha plantilla debera estar el enlace 'comprar producto' ");
	//ahora lo suyo es llamar a obter libro por id y mostrar
	//en una plantilal el resultado obtenido
}

function comprar_producto(){
	if(nombre_login == ""){
		alert("debes identificarte para poder comprar productos");
	}else{
		//asi obtengo la id del producto a agregar al carrito
		var id = $(this).attr("id_producto");
		var cantidad = $("#input-cantidad-"+id).val();
		
		//para hacer un post con jquery es mas comodo 
		//lo siguiente:
		$.post("ServicioWebCarrito/agregarLibro",
			{
				idProducto: id,
				cantidad: cantidad
			}
		).done(function(res){
			alert(res);
		});//end post
	}//end else
	
}//end comprar_producto

function identificar_usuario(){
	var email = $("#email").val();
	var pass = $("#pass").val();
	$.ajax("ServicioWebUsuarios/identificarUsuario",{
		type: "post",
		data: "email="+email+"&pass="+pass,
		success: function(res){
			var respuesta = res.split(",")[0];
			var mensaje = res.split(",")[1];
			if(respuesta == "ok"){
				alert("bienvenido " + mensaje + " ya puedes comprar");
				nombre_login = mensaje;
				mostrar_productos();
				$("#inicio_span_nombre_usuario").html("hola "+ nombre_login);
				$("#login").hide();
				$("#registrarme").hide();
				$("#logout").show();
			}else if( respuesta == "error"){
				alert(mensaje);
			}
		}//end success
	});//end ajax
	
}//end identificar_usuario


function mostrar_productos_carrito(){
	
	if(nombre_login == ""){
		alert("debes identificarte para acceder a tu carrito");
		return;
	}
	
	$.getJSON("ServicioWebCarrito/obtenerProductosCarrito",function(res){
		//alert(res);
		console.log(res);
		$("#contenedor").html( Mustache.render(plantillas.carrito,res) );
		$(".input_cantidad").change(function(){
			alert("mandar al servidor la nueva cantidad, por hacer...");
		});
		$(".enlace_borrar_producto").click(function(){
			alert("borrar producto del carrito, por hacer...");
		});
		$("#realizar_pedido").click(function(){
			checkout_paso_1();
		});
	});
	
}//end mostrar_productos_carrito


function logout(){
	$.ajax("ServicioWebUsuarios/logout",{
		success: function(res){
			if(res == "ok"){
				alert("hasta pronto");
				nombre_login="";
				$("#login").show();
				$("#registrarme").show();
				$("#logout").hide();
				$("#inicio_span_nombre_usuario").html("(Usuario no identificado)");
			}
		}
	});
}//end logout

