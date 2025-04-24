function myFunction(button) {
    var autoId = $(button).data('id');
    console.log('Id del auto a eliminar:', autoId); 

    $.ajax({
        url: contextPath + '/AutoEliminar', 
        type: 'GET',
        data: { id: autoId }, 
        success: function(response) {
            console.log('Auto eliminado:', response);
            

            if (response.estatus === 'ok') {
                location.reload(); 
            }
        },
        error: function(error) {
            console.log('Error al eliminar el auto:', error);
        }
    });
}