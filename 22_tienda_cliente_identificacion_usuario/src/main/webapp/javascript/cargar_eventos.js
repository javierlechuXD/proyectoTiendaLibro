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
			//forma nueva para mandar directamente toda la informacion de un form
			//que tenga o no, uno o mas input type file
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
		});//end submit
	});//end click

	$("#logout").click(function(e){
		logout();		
	});//end click logout
	
}//cargar eventos
