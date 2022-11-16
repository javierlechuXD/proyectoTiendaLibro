function cargarEventos(){
	//con jquery digo que va a pasar cuando se haga click en un enlace
	$("#inicio").click(function(){
		mostrar_productos();
	});

	$("#carrito").click(function(){
		mostrar_productos_carrito();
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
			// Forma para mandar directamente toda l ainformación dle form que tenga o no
			// uno o más input type file
			
			// No podemos coger el elemento por JQUERY
			let formulario = this;
			let formData = new FormData(formulario);
			$.ajax("ServicioWebUsuarios/registrarUsuario",{
				type: "POST",
				data: formData,
				cache: false,
				contentType: false,
				processData: false,
				success: function(res){
					alert(res);
				}
			});
			
			
// FORMA POR AJAX
//			var nombre = $("#nombre").val();
//			var email = $("#email").val();
//			var pass = $("#pass").val();
//			//ahora se deberian validar los campos
//			var usuario = {nombre: nombre, email: email, pass: pass};
//			console.log(usuario);
//			var json = JSON.stringify(usuario);//transformar a string un json del 
//											  //objeto usuario
//			alert("json a enviar: " + json);
//			$.ajax("ServicioWebUsuarios/registrarUsuario",{
//				type: "POST",
//				data: "info="+json,
//				success: function(res){
//					if(res == "ok"){
//						alert("registro ok, ya puedes identificarte - por hacer..");
//						$("#nombre").val("");
//						$("#email").val("");
//						$("#pass").val("");
//					}
//				}
//			});//end ajax						
		});//end submit
	});//end click



	$("#logout").click(function(e){
		logout();		
	});//end click logout
	
}//cargar eventos
