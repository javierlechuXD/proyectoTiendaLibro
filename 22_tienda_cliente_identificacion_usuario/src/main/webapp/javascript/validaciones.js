let regexp_nombre = /^[a-z áéíóúñ]{2,10}$/i;
let regexp_pass = /^[a-z0-9áéíóú]{3,10}$/i;
let regexp_email = /^([a-z0-9_.-]+)@([a-z0-9_.-]+)\.([a-z.]{2,6})$/i

function validarNombre(nombre){
	if(regexp_nombre.test(nombre)){
		return true;
	}else{
		alert("Nombre incorrecto");
		return false;
	}
}

function validarEmail(email){
	if(regexp_email.test(email)){
		return true;
	}else{
		alert("Email incorrecto");
		return false;
	}
}

function validarPass(pass){
	if(regexp_pass.test(pass)){
		return true;
	}else{
		alert("Contraseña incorrecto");
		return false;
	}
}