$(function() { //peticion ajax al controller para agregar un auto

	    $("#btn-confirmar").click(function (e) {
	            e.preventDefault(); 
	            var modelo =$("#modelo").val();
	            var marca =$("#marca").val();
				var descripcion =$("#descripcion").val();
	            var stock =$("#stock").val();
				var precio =$("#precio").val();
				var sucursal_id =$("#sucursal_id").val();
				var disponibilidad =$("#disponibilidad").val();
				
				
				
	                $.ajax({
	                    url: contextPath + '/crearAuto',
	                    dataType: 'json',
	                    success: function (data) {
	                        alert(data.mensaje   );
	                        window.location.href=contextPath+'/LeerAuto';
	                    },
	                    error: function(xhr, status, error) {
	                          alert(error);               
	                    },
	                    data: {
	                        modelo: modelo,
	                        marca: marca,
							descripcion: descripcion,
	                        stock: stock,
							precio: precio,
							sucursal_id: sucursal_id,
							disponibilidad: disponibilidad
	                    },
	                    cache: true,
	                    type: 'post'
	                });
	        });

	});