$(document).ready( function () {
    $('#tablaProductos').DataTable({
        order:[[3, "asc"]],
        lengthMenu: [2, 5, 10, 15, 20],
        columns: [
            null,
            {orderable: false},
            null,
            null,
            null,
            {bSearchable: false},
            {orderable: false}
        ],
        language: {
            "search": "Buscar",
            "lengthMenu": "Mostrar _MENU_ registros",
            "info": "Mostrando de _START_ a _END_ de _TOTAL_ productos",
            "infoFiltered": "(Filtrado de _MAX_ de productos)",
            "emptyTable": "Todavía no hay productos",
            "paginate": {
                "previous": "Anterior",
                "next": "Siguiente"
            }
        }
    });
});