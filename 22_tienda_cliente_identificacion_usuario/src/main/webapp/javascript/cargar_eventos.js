function cargarEventos(){
	//con jquery digo que va a pasar cuando se haga click en un enlace
	$("#inicio").click(function(){
		mostrar_productos();
	});

	$("#carrito").click(function(){
		$("#contenedor").html(plantillas.carrito);
	});
	
	$("#login").click(function(){
		$("#contenedor").html(plantillas.login);
		$("#form_login").submit(function(e){
			e.preventDefault();
			identificar_usuario();
		});
	});

	$("#registrarme").click(function(){
		$("#contenedor").html(plantillas.registrarme);
		$("#form_registro_usuario").submit(function(e){
			//este codigo se ejecuta cuando se 
			//pulsa el boton de submit del form 
			e.preventDefault();//se cancela el envio de form de forma tradicional
			var nombre = $("#nombre").val();
			var email = $("#email").val();
			var pass = $("#pass").val();
			//ahora se deberian validar los campos
			var usuario = {nombre: nombre, email: email, pass: pass};
			console.log(usuario);
			var json = JSON.stringify(usuario);//transformar a string un json del 
											  //objeto usuario
			alert("json a enviar: " + json);
			$.ajax("ServicioWebUsuarios/registrarUsuario",{
				type: "POST",
				data: "info="+json,
				success: function(res){
					if(res == "ok"){
						alert("registro ok, ya puedes identificarte - por hacer..");
						$("#nombre").val("");
						$("#email").val("");
						$("#pass").val("");
					}
				}
			});//end ajax						
		});//end submit
	});//end click

	$("#logout").click(function(e){
		logout();		
	});//end click logout
	
}//cargar eventos
