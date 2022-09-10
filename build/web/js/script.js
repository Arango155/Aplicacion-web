
function enviarForm(){ 
var myForm = document.getElementById("contact-form");

document.getElementById("btn3").addEventListener("click", function(){
  myForm.submit();  
});
 };
 

 function enviarFormularioOpcionDos(){
	const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();

	  // Define what happens on successful data submission
//	  XHR.addEventListener('click', (event) => {
//	    alert('Yeah! Data sent and response loaded.');
//	  });

	  // Define what happens in case of error
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });

	  // Set up our request
	  XHR.open('POST', 'NewServlet', true);
                    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    
                    XHR.onload = () => {
                        if (XHR.readyState === XHR.DONE && XHR.status === 200) {
                            console.log("response => " + XHR.response);
                            document.getElementById("bodyTable").innerHTML=XHR.response;
                            mostrarMensaje();
                        }
                    };
	  // Send our FormData object; HTTP headers are set automatically
            console.log(formData);
	  XHR.send(formData);
//	console.log(formData);
}

function remove (position){
    
    mostrarMensaje2();
    
                        let formData = "position=" + position;

                     const XHR = new XMLHttpRequest();

	  // Define what happens in case of error
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });

	  // Set up our request
	  XHR.open('POST', 'NewServlet', true);
                    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    
                    XHR.onload = () => {
                        if (XHR.readyState === XHR.DONE && XHR.status === 200) {
                            console.log("response => " + XHR.response);
                            document.getElementById("Vector").innerHTML=XHR.response;
                            
                        }
                    };
	  XHR.send(formData);
    
}


function mostrarMensaje(){
  Swal.fire({
  icon: 'success',
  title: 'Estudiante guardado exitosamente',
  showConfirmButton: false,
  timer: 1500
})
}

function mostrarMensaje2(){
Swal.fire({
  title: 'Estas seguro?',
  text: "No podras revertir esto.!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Si, eliminalo!'
}).then((result) => {
  if (result.isConfirmed) {
    Swal.fire(
      'Eliminado!',
      'El alumno ha sido eliminado.',
      'success'
    )
  }
})
}